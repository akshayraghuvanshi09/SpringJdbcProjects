package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext aContext = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        StudentDao sDao = aContext.getBean("StudentDao", StudentDao.class);
        
        // insert student
        Student student = new Student();
        student.setId(104);
        student.setName("Rajesh");
        student.setCity("Mhow");
        int res = sDao.insert(student);
        System.out.println(res+" item added");
        
        
        // update student
//        Student student = new Student();
//        student.setId(222);
//        student.setName("Kamlesh");
//        student.setCity("Mumbai");
//        int update = sDao.update(student);
//        System.out.println(update+" items Updated");
        
        
        // delete student
//        Student student = new Student();
//        student.setId(222);
//        int delete = sDao.delete(student);
//        System.out.println(delete+" items deleted");
        
        // selecting single rw data
//        Student student = sDao.getStudent(101);
//        System.out.println(student);
        
        // select all records from DB
        List<Student> students = sDao.getAllStudent();
        for(Student student1 : students) {
        	System.out.println(student1);
        }
        
    }
}
