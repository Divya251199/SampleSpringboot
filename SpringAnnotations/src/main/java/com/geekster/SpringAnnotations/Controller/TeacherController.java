package com.geekster.SpringAnnotations.Controller;

import com.geekster.SpringAnnotations.Student;
import com.geekster.SpringAnnotations.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired

    // when we use Autowired, all the beans are autowired
    // component scan annotation which is present in SpringBootApplication will scan all the beans and store thos           e in IOC container
        Teacher t1;

//    @GetMapping
    @RequestMapping(value = "teach", method = RequestMethod.GET)
    public String teach() {
        return t1.teach();
    }
}
