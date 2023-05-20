package com.kj.project.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.kj.project.Utility.Employee;

@Repository
public class EmployeeDaoImp implements EmployeeDao
{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveEmp(Employee emp)
	{
		int i = (Integer) hibernateTemplate.save(emp);
		return i;
	}

	public Employee getEmpById(int id)
	{
		Employee employee = hibernateTemplate.get(Employee.class, id);
		return employee;
	}

	public List<Employee> getAllEmp()
	{
		List<Employee> loadAll = hibernateTemplate.loadAll(Employee.class);
		return loadAll;
	}

	@Transactional
	public void update(Employee emp)
	{
		hibernateTemplate.update(emp);
	}

	@Transactional
	public void deleteEmp(int id)
	{
		Employee employee = hibernateTemplate.get(Employee.class, id);
		hibernateTemplate.delete(employee);
	}
}
