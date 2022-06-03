package com.lt.src.repository;

import org.springframework.stereotype.Repository;

import com.lt.constant.DataCollections;
import com.lt.src.bean.Professor;

@Repository
public class ProfessorDaoImpl{

	
	public void saveProfessor(Professor professor) {
		DataCollections.professors.add(professor);
	}

	public Professor getProfessor(String userName) {
		return DataCollections.professors.stream().filter(professor->professor.getName().equals(userName))
										   .findAny().orElseGet(null);
	}

}
