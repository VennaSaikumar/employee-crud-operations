pipeline {
    agent any

    stages {

        stage('Build & Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'ls -la'
                sh 'ls -la target'
                sh 'docker build -t employee-crud-operations:latest .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    docker stop employee-crud-operations || true
                    docker rm employee-crud-operations || true

                    docker run -d \
                      --name employee-crud-operations \
                      --add-host=host.docker.internal:host-gateway \
                      -p 8081:8080 \
                      -e DB_URL="jdbc:mysql://host.docker.internal:3306/realdb" \
                      -e DB_USERNAME="root" \
                      -e DB_PASSWORD="C@r3eR25" \
                      employee-crud-operations:latest

                    echo "Waiting for application to start..."
                    sleep 15

                    echo "Container status:"
                    docker ps -a --filter "name=employee-crud-operations"

                    if [ "$(docker inspect -f '{{.State.Running}}' employee-crud-operations)" != "true" ]; then
                        echo "Container failed to start!"
                        echo "Container logs:"
                        docker logs employee-crud-operations
                        exit 1
                    fi

                    echo "Container is running successfully!"
                '''
            }
        }
    }

    post {
        success {
            echo 'Build, Test, Docker Build and Deployment completed successfully!'
        }

        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}
