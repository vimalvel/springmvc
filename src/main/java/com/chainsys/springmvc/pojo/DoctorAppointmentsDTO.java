package com.chainsys.springmvc.pojo;

import java.util.ArrayList;
import java.util.List;

public class DoctorAppointmentsDTO {
	private Doctor doctor;
	private List<Appointment> applist=new ArrayList<Appointment>();
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public List<Appointment> getApplist() {
		return applist;
	}
	public void setApplist(List<Appointment> applist) {
		this.applist = applist;
	}
	public void addAppointment(Appointment app) {
		applist.add(app);
	}
	public List<Appointment> getAppointments(){
		return applist;
	}


}
