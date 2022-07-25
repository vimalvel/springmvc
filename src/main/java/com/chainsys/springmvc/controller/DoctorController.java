package com.chainsys.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chainsys.springmvc.pojo.Appointment;
import com.chainsys.springmvc.pojo.Doctor;
import com.chainsys.springmvc.pojo.DoctorAppointmentsDTO;
import com.chainsys.springmvc.service.DoctorService;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@GetMapping("/getdoctor")
	public String getDoctor(@RequestParam("id") int id, Model model) {
		Doctor dr = drservice.findByid(id);
		model.addAttribute("getdoctor", dr);
		return "find-doctor-id-form";
	}

	@GetMapping("/adddocform")
	public String showForm(Model model) {
		Doctor dr = new Doctor();
		model.addAttribute("adddoctor", dr);
		return "add-doctor-form";
	}

	@PostMapping("/adddoc")
	public String addNewDoctor(@ModelAttribute("adddoctor") Doctor dr) {
		drservice.save(dr);
		return "redirect:/doctor/doclist";
	}

	@GetMapping("/updatedocform")
	public String showUpdatedocForm(@RequestParam("docid") int id, Model model) {
		Doctor dr = drservice.findByid(id);
		model.addAttribute("updatedoctor", dr);
		return "update-doctor-form";
	}

	@PostMapping("/updatedoc")
	public String updateDoctor(@ModelAttribute("updatedoctor") Doctor dr) {
		drservice.save(dr);
		return "redirect:/doctor/doclist";
	}

	@GetMapping("deletedoc")
	public String deleteDoctor(@RequestParam("docid") int id) {
		drservice.deleteById(id);
		return "redirect:/doctor/doclist";

	}

	@Autowired
	DoctorService drservice;

	@GetMapping("/doclist")
	public String getAllDoctor(Model model) {
		List<Doctor> doc = drservice.getDoctors();
		model.addAttribute("alldoctor", doc);
		return "list-doctor";
	}

	@GetMapping("/getdocapp")
	public String getAppoinments(@RequestParam("id") int id, Model model) {
		DoctorAppointmentsDTO dto = drservice.getDoctorAndAppointments(id);
		model.addAttribute("getdoc", dto.getDoctor());
		model.addAttribute("applist", dto.getAppointments());
		return "list-doctor-appointment";
	}
// localhost:8080/doctor/trans?id=30
	@GetMapping("/trans")
	public void testTransaction(@RequestParam("id") int id) {
		DoctorAppointmentsDTO dto = new DoctorAppointmentsDTO();
		Doctor dr = new Doctor();
		dr.setDoc_id(id);
		dr.setDoc_name("vimal");
		Date d=new Date(22,7,25);
		dr.setDob(d);
		dr.setCity("madurai");
		dr.setPhone_no(3456789024l);
		dr.setSpeciality("corona");
		dr.setFees(1000);
		dto.setDoctor(dr);
		List<Appointment> applist= new ArrayList<Appointment>(); 
		int nextAppId=drservice.getNextAppointmentId();
		for (int i=200;i<=202;i++)
		{
			
		Appointment app = new Appointment();
	    app.setAPP_ID(id);
		Date dt=new Date(22,7,25);
		app.setAPP_DATE(dt);
		app.setDOC_ID(id);
		app.setFEES_COLLECTED(dr.getFees());
		dto.addAppointment(app);
		}
		drservice.addDoctorAndAppointments(dto);
		System.out.println("Sucessfully completed");
		
	}

}
