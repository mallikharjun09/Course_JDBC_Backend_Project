package com.tmf.students.backend.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tmf.students.backend.config.DBConfig;
import com.tmf.students.backend.entities.Course;

public class CourseRepositoryImpl implements CourseRepository{

	private Connection con = DBConfig.connectDB();
	private PreparedStatement ps;
	private ResultSet rs;
	private String query;
	@Override
	public void addCourse(Course course) {
		try {
			query = "insert into course values(?,?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setInt(1, course.getCourseId());
			ps.setString(2, course.getCourseCode());
			ps.setString(3, course.getCourseName());
			ps.setInt(4, course.getDuration());
			ps.setDouble(5, course.getFee());
			ps.execute();
			System.out.println("Record has been inserted successfully..");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}

	@Override
	public void displayCourse(Course course) {
		// TODO Auto-generated method stub
		System.out.println(course);
	}

	@Override
	public Course displayCourseById(int courseId) {
		// TODO Auto-generated method stub
		Course c = new Course();
		try {
			query = "select * from course where course_id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, courseId);
			rs = ps.executeQuery();
			if(rs.next()) {
				c = getCourse(rs);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c;
	}

	private Course getCourse(ResultSet rs) {
		Course c = new Course();
		try {
			c.setCourseId(rs.getInt(1));
			c.setCourseCode(rs.getString(2));
			c.setCourseName(rs.getString(3));
			c.setDuration(rs.getInt(4));
			c.setFee(rs.getDouble(5));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return c;
	}
	
	@Override
	public List<Course> displayAllCourses() {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<Course>();
		try {
			query = "select * from course";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Course c = getCourse(rs);
				courses.add(c);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return courses;
	}

	@Override
	public void updateCourse(Course course) {
		try {
			query = "update course set course_code = ?, course_name = ?, duration = ?, fee = ? where course_id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(5, course.getCourseId());
			ps.setString(1, course.getCourseCode());
			ps.setString(2, course.getCourseName());
			ps.setInt(3, course.getDuration());
			ps.setDouble(4, course.getFee());
			ps.execute();
			System.out.println("Record has been updated successfully..");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

}
