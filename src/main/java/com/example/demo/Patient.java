package com.example.demo;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Patient model.  Includes the name, age, and medications the patient is on.
 * @author Sam Rodberg
 *
 */
@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String age;
	
	private ArrayList<String> meds = new ArrayList<>();

	public ArrayList<String> getMeds() {
		return meds;
	}

	public void setMeds(ArrayList<String> meds) {
		this.meds = meds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	

}
