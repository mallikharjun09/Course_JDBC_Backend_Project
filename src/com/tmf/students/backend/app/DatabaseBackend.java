package com.tmf.students.backend.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.tmf.students.backend.config.DBConfig;
import com.tmf.students.backend.entities.Course;
import com.tmf.students.backend.repository.CourseRepository;
import com.tmf.students.backend.repository.CourseRepositoryImpl;

public class DatabaseBackend {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Course Id ");
		int cid = scan.nextInt();
		System.out.println("Enter the Course Code ");
		String courseCode = scan.next();
		System.out.println("Enter the Course Duration ");
		int duration = scan.nextInt();
		System.out.println("Enter the course Fee ");
		double fee = scan.nextDouble();
		scan.nextLine();
		System.out.println("Enter the course Name ");
		String courseName = scan.nextLine();
		
		CourseRepository repo = new CourseRepositoryImpl();
		
		//Creating an emptry course object
		Course c = new Course();
		
		//Setting all fields details to the Course object.
		c.setCourseCode(courseCode);
		c.setCourseId(cid);
		c.setCourseName(courseName);
		c.setDuration(duration);
		c.setFee(fee);
		
		//Send this course object to the addCourse() method in the repository.
		repo.updateCourse(c);
	}
}
