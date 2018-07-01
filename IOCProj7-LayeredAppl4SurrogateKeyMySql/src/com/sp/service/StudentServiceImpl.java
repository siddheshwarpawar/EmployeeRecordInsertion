package com.sp.service;

import com.sp.bo.StudentBO;
import com.sp.dao.StudentDAO;
import com.sp.dto.StudentDTO;

public class StudentServiceImpl  implements StudentService{
	private StudentDAO dao;
	
	public StudentServiceImpl(StudentDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public String genrateResult(StudentDTO dto) throws Exception {
		// Business  logic
		String result;
		int total = dto.getM1() + dto.getM2() + dto.getM3() ;
		float avg = total / 3.0f;
		if(dto.getM1() < 35 && dto.getM2() < 35  && dto.getM3()<35)
			result = "Fail";
		else
			result = "Pass";
		
		// Create  BO  class  obj
		StudentBO bo =  new StudentBO();
		//bo.setSno(dto.getSno());
		bo.setSname(dto.getName());
		bo.setTotal(total);
		bo.setResult(result);
	
		// Dump All BO data to DAO
		int cnt = dao.insert(bo);
		if(cnt == 0)
			return "\t\t\t\t\tResult ::"+bo.getResult()+"\t\t Record Insertion Failed";
		else
			return  "\t\t\t\t\tResult ::"+bo.getResult()+"\t\t Registration Successful";
	}// method

} // class
