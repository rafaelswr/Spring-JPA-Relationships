package dev.jpa.Services;

import dev.jpa.Models.Course;
import dev.jpa.Models.Student;
import dev.jpa.Repositories.CourseRepository;
import dev.jpa.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public AppService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }
    public List<Student> getListStudents() {
            return studentRepository.findAll();
    }
    public List<Course> getListCourses() {
       return courseRepository.findAll();

    }

    public Optional<Student> getStudent(Long studentId) {
        Optional<Student> stu = studentRepository.findStudentById(studentId);
        if(stu.isPresent()){
            return stu;
        }else{
            throw  new IllegalStateException("Student not found");
        }
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
}
