package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entities.StudentDao;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("progrm in use ....\n");
       // ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/Config.xml");
        
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
       StudentDao studentdao= context.getBean("studentdao",StudentDao.class);
       //Student student = new Student();
//       student.setId(777);
//       student.setName("john");
//       student.setCity("Teaas");
//       int result=studentdao.insert(student);
       
//       student.setId(777);
//       student.setName("Raju rastogi");
//       student.setCity("Masaurhi");
//       int result=studentdao.change(student);
       
//       int result=studentdao.delete(777);
       
//       Student result= studentdao.getStudent(222);
//       System.out.println(result);
       List<Student> students = studentdao.getallStudents();
       
       for(Student s:students) {
    	   System.out.println(s);
       }
       
    }
}
