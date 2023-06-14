package com.balmes.model;

import java.sql.Date;

import jakarta.persistence.*;
@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no")
    private int empNo;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "gender")
    private char gender;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "role")
    private String role;

    @Column(name = "salary")
    private float salary;

    @ManyToOne
    @JoinColumn(name = "deptno")
    private Departments deptno;

    public Employees() {
    }

    public Employees(String lastName, String firstName, Date birthDate, char gender, Date hireDate, String role, float salary, Departments deptno) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.hireDate = hireDate;
        this.role = role;
        this.salary = salary;
        this.deptno = deptno;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Departments getDepartment() {
        return deptno;
    }

    public void setDepartment(Departments deptno) {
        this.deptno = deptno;
    }
}