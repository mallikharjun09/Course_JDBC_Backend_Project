package com.tmf.students.backend.repository;

import java.util.List;

import com.tmf.students.backend.entities.Course;

public interface CourseRepository {
	public void addCourse(Course course);
	public void displayCourse(Course course);
	public Course displayCourseById(int courseId);
	public List<Course> displayAllCourses();
	public void updateCourse(Course course);
	public void deleteCourse(Course course);
}
