package com.kj.project.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kj.project.Dao.EmployeeDao;
import com.kj.project.Utility.Employee;

@Controller
public class HomeController
{
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(path = "/home")
	public String home(Model m)
	{
		List<Employee> list = employeeDao.getAllEmp();
		m.addAttribute("employeeList", list);
		return "home";
	}
	
	@RequestMapping(path = "/addEmp")
	public String addEmp()
	{
		return "add_emp";
	}
	
	@RequestMapping(path = "/createEmp",method = RequestMethod.POST)
	public String createEmp(@ModelAttribute Employee emp,HttpSession session)
	{
		System.out.println(emp);
		int i = employeeDao.saveEmp(emp);
		session.setAttribute("msg", "Register Successfully");
		return "redirect:/addEmp";
	}
	
	@RequestMapping(path = "/editEmp/{id}")
	public String editEmp(@PathVariable int id,Model m)
	{
		Employee employee = employeeDao.getEmpById(id);
		m.addAttribute("employee", employee);
		return "edit_emp";
	}
	
	@RequestMapping(path = "/updateEmp" , method = RequestMethod.POST)
	public String updateEmp(@ModelAttribute Employee employee,HttpSession session)
	{
		employeeDao.update(employee);
		session.setAttribute("msg", "Update Successfully");
		return "redirect:/home";
	}
	
	@RequestMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session)
	{
		employeeDao.deleteEmp(id);
		session.setAttribute("msg","Employee Record Deleted Successfull...!!!");
		return "redirect:/home";
	}
}