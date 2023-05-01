package com.example.UniversityManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event_tbl")
@Entity

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventId;

    @NotBlank
    private String eventName;

    @NotBlank
    private String locationOfEvent;

    @NotNull
    @JsonFormat(shape =  JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")

    private LocalDate date;

    @NotNull
    @JsonFormat(shape =  JsonFormat.Shape.STRING,pattern = "HH:mm:ss")

    private String startTime;

    @NotNull
    @JsonFormat(shape =  JsonFormat.Shape.STRING,pattern = "HH:mm:ss")
    private  String endTime;
}
