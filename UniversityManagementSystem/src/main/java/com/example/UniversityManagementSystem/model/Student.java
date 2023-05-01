package com.example.UniversityManagementSystem.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "student_tbl")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_Id")
    private Integer studentId;

    @Pattern(regexp = "[A-Z][a-z]*" , message = "First Letter of Name should be Capital")
    private String firstName;


    private String lastName;

    @NotNull
    @Min(value = 18 , message = "Age should not be smaller than 18")
    @Max(value = 25 , message = "Age should not be greater than 25")
    private Integer age;

    @Enumerated(EnumType.STRING) //only for watching strings in DB.
    private Department department;

}
