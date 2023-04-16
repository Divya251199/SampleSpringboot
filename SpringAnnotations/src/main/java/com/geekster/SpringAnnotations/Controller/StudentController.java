package com.geekster.SpringAnnotations.Controller;

import com.geekster.SpringAnnotations.HandleMail;
import com.geekster.SpringAnnotations.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
@Autowired
    // when we use Autowired, all the beans are autowired
    // component scan annotation which is present in SpringBootApplication will scan all the beans
    Student s1;
@Autowired
HandleMail h1;
    @GetMapping("/student")
    public Student getStudent()
    {
        h1.sendMail();
        return s1;

    }
}
