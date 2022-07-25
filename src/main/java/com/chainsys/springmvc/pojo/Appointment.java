package com.chainsys.springmvc.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {
	@Id
	private int APP_ID;
	private Date APP_DATE;
	private int DOC_ID;
	private String PATIENT_NAME;
	private float FEES_COLLECTED;

	public float getFEES_COLLECTED() {
		return FEES_COLLECTED;
	}

	public void setFEES_COLLECTED(float fEES_COLLECTED) {
		FEES_COLLECTED = fEES_COLLECTED;
	}

	public int getAPP_ID() {
		return APP_ID;
	}

	public void setAPP_ID(int aPP_ID) {
		APP_ID = aPP_ID;
	}

	public Date getAPP_DATE() {
		return APP_DATE;
	}

	public void setAPP_DATE(Date aPP_DATE) {
		APP_DATE = aPP_DATE;
	}

	public int getDOC_ID() {
		return DOC_ID;
	}

	public void setDOC_ID(int dOC_ID) {
		DOC_ID = dOC_ID;
	}

	public String getPATIENT_NAME() {
		return PATIENT_NAME;
	}

	public void setPATIENT_NAME(String pATIENT_NAME) {
		PATIENT_NAME = pATIENT_NAME;
	}

	

}
