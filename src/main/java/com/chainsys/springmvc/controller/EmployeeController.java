package com.chainsys.springmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chainsys.springmvc.dao.EmployeeDao;
import com.chainsys.springmvc.pojo.Employee;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@GetMapping("/list")
	public String getAllEmployees(Model model) {
		List<Employee> emplist = EmployeeDao.getAllEmployee();
		model.addAttribute("allemployee", emplist);
		return "list-employee";

	}

	@GetMapping("/addform")
	public String showAddForm(Model model) {
		Employee theemp = new Employee();
		model.addAttribute("addemployee", theemp);
		return "add-employee-form";
	}

	@PostMapping("/add")
	public String addNewEmployee(@ModelAttribute("addemployee") Employee theemp) {
		EmployeeDao.insertEmployee(theemp);
		return "redirect:/employee/list";

	}

	@GetMapping("/updateform")
	public String showUpdateForm(@RequestParam("empid") int id, Model model) {
		Employee theemp = EmployeeDao.getEmployeeById(id);
		model.addAttribute("updateemployee", theemp);
		return "update-employee-form2";
	}

	@PostMapping("/updateemp")
	public String updateEmployee(@ModelAttribute("updateemployee") Employee theemp) {
		EmployeeDao.updateEmployee(theemp);
		return "redirect:/employee/list";

	}

	@GetMapping("deleteemployee")
	public String deleteEmployee(@RequestParam("empid") int id) {
		EmployeeDao.deleteEmployee(id);
		return "redirect:/employee/list";

	}

	@GetMapping("/findemployeebyid")
	public String findEmployeeById(@RequestParam("empid") int id,Model model) {
		Employee theemp=EmployeeDao.getEmployeeById(id);
		model.addAttribute("findemployeebyid", theemp);
		return "find-employee-id-form";

	}

}
