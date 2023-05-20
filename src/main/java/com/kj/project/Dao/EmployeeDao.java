package com.kj.project.Dao;

import java.util.List;

import com.kj.project.Utility.Employee;

public interface EmployeeDao
{
	public int saveEmp(Employee emp);
	public Employee getEmpById(int id);
	public List<Employee> getAllEmp();
	public void update(Employee emp);
	public void deleteEmp(int id);
}
