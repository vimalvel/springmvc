package com.chainsys.springmvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chainsys.springmvc.dao.AppointmentRepository;
import com.chainsys.springmvc.dao.DoctorRepository;
import com.chainsys.springmvc.pojo.Appointment;
import com.chainsys.springmvc.pojo.Doctor;
import com.chainsys.springmvc.pojo.DoctorAppointmentsDTO;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository  repo;
	@Autowired
	private AppointmentRepository repos;
	public List<Doctor> getDoctors() {
		List<Doctor> doclist = repo.findAll();
		return doclist;
		
	}
	public Doctor save(Doctor dr){
		return repo.save(dr);
	}
	public Doctor findByid(int id) {
		return repo.findById(id);
	}
	@Transactional
	public void deleteById(int id) {
		 repo.deleteById(id);
		
	}
	public DoctorAppointmentsDTO getDoctorAndAppointments(int id) {
		Doctor dr=findByid(id);
		DoctorAppointmentsDTO dto=new DoctorAppointmentsDTO();
		dto.setDoctor(dr);
		for (int i=0;i<=5;i++)
		{
		Appointment app=new Appointment(); 
		app.setAPP_ID(i);
		Date dt=new Date(22,07,25);
		app.setAPP_DATE(dt);
		app.setDOC_ID(id);
		app.setPATIENT_NAME("SURIYA");
		app.setFEES_COLLECTED(i*500);
		dto.addAppointment(app);
		}
		return dto;
		
		
		
	}
	@Transactional
    public void addDoctorAndAppointments(DoctorAppointmentsDTO dto) {
    	Doctor dr = dto.getDoctor();
    	save(dr);
    	List<Appointment> applist = dto.getAppointments();
    	int count = applist.size();
    	for(int i=0;i<=count;i++) {
    		repos.save(applist.get(i));
    	}
    }
	  public int getNextAppointmentId()
	     {
	         return repos.getNextId();
	     }
}

