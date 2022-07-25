package com.chainsys.springmvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.springmvc.pojo.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
	Appointment findById(int id);

	Appointment save(Appointment app);

//	used for adding new doctor 
	void deleteById(int dr_id);

	List<Appointment> findAll();
//	define a native query for this method
	int getNextId();

}
