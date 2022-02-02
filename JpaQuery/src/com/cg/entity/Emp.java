 package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@org.hibernate.annotations.Entity(dynamicUpdate =true)
@Table(name="cmr_emp")
public class Emp {

			@Id
			@Column(name="emp_id")
			private int empId;
			@Column(name="emp_name",nullable=false, length=25)
			private String empName;
			@Column(name="emp_sal")
			private double empSal;
			@Column(name="emp_desig", length=20)
			private String desig;
			
			
			public int getEmpId() {
				return empId;
			}
			public void setEmpId(int empId) {
				this.empId = empId;
			}
			public String getEmpName() {
				return empName;
			}
			public void setEmpName(String empName) {
				this.empName = empName;
			}
			public double getEmpSal() {
				return empSal;
			}
			public void setEmpSal(double empSal) {
				this.empSal = empSal;
			}
			public String getDesig() {
				return desig;
			}
			public void setDesig(String desig) {
				this.desig = desig;
			}
			@Override
			public String toString() {
				return  empId + " " + empName + " " + empSal + " "+  desig ;
			}
			
			
	}


