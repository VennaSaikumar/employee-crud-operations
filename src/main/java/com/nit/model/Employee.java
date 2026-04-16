package com.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Data
@Table(name="boot_emp")
@SQLDelete(sql="UPADTE BOOT_EMP SET STATUS ='deleted' WHERE EMPNO=?")
@Where(clause="STATUS <> 'deleted'")
public class Employee {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "emp_id_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer empno;
	@Column(length=20)
	private String ename;
	@Column(length=20)
	private String job;
	private Double sal;
	private Integer deptno;
	@Column(length=10)
	private String status="active";

}
