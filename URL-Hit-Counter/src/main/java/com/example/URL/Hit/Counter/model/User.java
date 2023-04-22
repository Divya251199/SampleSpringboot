package com.example.URL.Hit.Counter.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String userName;
    private int urlHitCount;

}
