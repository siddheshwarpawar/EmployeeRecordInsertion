package com.sp.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import java.util.Scanner;
import com.sp.controller.StudentController;
import com.sp.vo.StudentVO;

public class ClientApp {

	public static void main(String[] args) {
		
		Scanner sc = null;
		String  sname = null, m1 = null, m2 = null, m3 = null;
		
		// Read  the  input  from  customer 
		sc =  new Scanner(System.in);
//		System.out.println("\n\nEnter  the  Student  No.  ::");
//		sno = sc.next();

		System.out.println("\nEnter  the  Student  Name::");
		sname = sc.next();

		System.out.println("\nEnter  the  Subject1  Mark::");
		m1 = sc.next();

		System.out.println("\nEnter  the  Subject2  Mark::");
		m2 = sc.next();

		System.out.println("\nEnter  the  Subject1  Mark::");
		m3 = sc.next();

		//Create vo class object
		StudentVO  vo   = new StudentVO();
//		vo.setSno(sno);
		vo.setSname(sname);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		
		//
		//create IOC continer
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/com/sp/cfgs/applicationContext.xml"));
		
		//get Bean
		StudentController controller = factory.getBean("stController", StudentController.class);
		

		try {
			// Invoke method
			
			System.out.println("----------------------------------------------------Student  Marksheet--------------------------------------------------------------");
	//		System.out.println("\t RollNo  ::"+vo.getSno());
			System.out.println("\t Name  ::"+vo.getSname().trim().substring(0, 1).toUpperCase()+vo.getSname().substring(1));
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t SUBJECT.. MARKS OUT OF");
			System.out.println("\t\t\t Subject 1   ::"+vo.getM1()+"/100");
			System.out.println("\t\t\t Subject 2   ::"+vo.getM2()+"/100");
			System.out.println("\t\t\t Subject 3   ::"+vo.getM3()+"/100");
			String result1 = controller.process(vo);
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(result1);
		} catch (Exception e) {
			System.out.println("Internal Problem..Try Again ???-->"+e.getMessage());
		}
		// Call method
		
	}

}
