package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.sp.bo.StudentBO;

public class StudentDAOImpl  implements StudentDAO{

	private static final String STUDENT_INSERT_QUERY = "INSERT INTO SPRING_STUDENT(sname,total,avg,result) VALUES(?, ?, ?, ?)";
	
	// Parameterized  constructor  to inject ds
	private DataSource drds;
	public StudentDAOImpl(DataSource drds) {
		super();
		this.drds = drds;
	}
	
	
	@Override
	public int insert(StudentBO bo) throws Exception {
	//  JDBC code to insert record
		
			// Get  JDBC Connection
			Connection con = drds.getConnection();
			System.out.println("StudentDAOImpl.insert()");
			// Create PreparedStatement object
			PreparedStatement psmt = con.prepareStatement(STUDENT_INSERT_QUERY);
			
			// Set  Query  parameter value
		//	psmt.setInt(1, bo.getSno());
			psmt.setString(1, bo.getSname());
			psmt.setInt(2, bo.getTotal());
			psmt.setFloat(3, bo.getAvg());
			psmt.setString(4, bo.getResult());
			System.out.println("StudentDAOImpl.insert()1");
			int result = psmt.executeUpdate();
			System.out.println("StudentDAOImpl.insert()2");
			psmt.close();
			con.close();
			return result;
			

	}// insert()
}// Class
