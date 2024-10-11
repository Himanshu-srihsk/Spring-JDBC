package com.spring.jdbc.entities;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.Student;

public class StudentdaoImpl implements StudentDao{
	private JdbcTemplate jdbcTemplate;
	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r= this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	public int change(Student student) {
		String query = "update student set name=?,city=? where id=?";
		int r= this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}
	
	@Override
	public List<Student> getallStudents() {
		String query = "select * from student";
		List<Student> students= this.jdbcTemplate.query(query,new RowMapperImpl());
		return students;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public int delete(int studentid) {
		String query = "delete from student where id = ?";
		int r= this.jdbcTemplate.update(query, studentid);
		return r;
	}
	@Override
	public Student getStudent(int student) {
		// TODO Auto-generated method stub
		String query = "select * from student where id = ?";
		RowMapper<Student> rowMapper= new RowMapperImpl();
		Student r= this.jdbcTemplate.queryForObject(query,rowMapper,student);
		return r;
	}
	
	

}
