<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty resultMsg}">
    <h2 style="color:green; text-align:center;">${resultMsg}</h2>
</c:if>

<c:choose>
    <c:when test="${not empty empsPage and not empty empsPage.content}">
        <h1 style="color:red; text-align:center;">Employees Report</h1>
        <table border="1" align="center" bgcolor="cyan">
            <tr style="color:red;">
                <th>Emp No</th>
                <th>Emp Name</th>
                <th>Job</th>
                <th>Salary</th>
                <th>Dept No</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="emp" items="${empsPage.content}">
                <tr style="color:blue;">
                    <td>${emp.empno}</td>
                    <td>${emp.ename}</td>
                    <td>${emp.job}</td>
                    <td>${emp.sal}</td>
                    <td>${emp.deptno}</td>
                    <td><a href="emp_edit?no=${emp.empno}"><img src="images/edit.png" width="30" height="30" /></a></td>
                    <!--<td><a href="emp_delete?no=${emp.empno}"><img src="images/delete.png" width="30" height="30" /></a></td>-->
					<td>
					  <a href="emp_delete?no=${emp.empno}" 
					     onclick="return confirm('Are you sure you want to delete Employee ${emp.empno}?');">
					    <img src="images/delete.png" width="30" height="30" />
					  </a>
					</td>

                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h2 style="color:red; text-align:center;">Employees not found</h2>
    </c:otherwise>
</c:choose>

<center>
    <a href="emp_add"><img src="images/add.png" width="40" height="50" /> Add Employee</a>&nbsp;&nbsp;&nbsp;
    <a href="./"><img src="images/home.png" width="40" height="50" /> Home</a>
</center>

<!-- Pagination Links -->
<c:if test="${empsPage.totalPages > 1}">
    <center style="margin-top: 20px;">
        <c:forEach begin="0" end="${empsPage.totalPages - 1}" var="i">
            <c:choose>
                <c:when test="${empsPage.number == i}">
                    <strong style="color:green;">[${i + 1}]</strong>
                </c:when>
                <c:otherwise>
                    <a href="?page=${i}&size=${empsPage.size}">${i + 1}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </center>
</c:if>
