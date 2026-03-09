package com.learn.springboot.cruddemo;

import com.learn.springboot.cruddemo.dao.StudentDAO;
import com.learn.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MycoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			/*for (int i = 0; i < 5; i++) {
				createStudent(studentDAO);
			}*/

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// updateAllStudents(studentDAO);
		};
	}

	private void updateAllStudents(StudentDAO studentDAO) {
		System.out.println("Updating all students...");
		studentDAO.updateAllLastName("Zall");

		System.out.println("Updated all students");
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student student = studentDAO.findById(studentId);

		System.out.println("Updating student...");
		student.setFirstName("Scooby");
		studentDAO.update(student);

		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Zall");

		for (Student temp : students) {
			System.out.println(temp);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> all = studentDAO.findAll();

		for (Student temp : all) {
			System.out.println(temp);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Test", "test@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		int id = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + id);

		System.out.println("Retrieving student with id: " + id);
		Student myStudent = studentDAO.findById(id);

		System.out.println("Found the student: " + myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Wall", "paul@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
	}
}
