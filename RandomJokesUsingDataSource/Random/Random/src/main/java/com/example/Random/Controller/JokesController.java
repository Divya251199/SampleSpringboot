package com.example.Random.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class JokesController {

    static ArrayList<String> jokesList = new ArrayList<>();

    @PostMapping(value = "/jokes")
    public String saveJokes(@RequestBody String jokes) {
        jokesList.add(jokes);
        return "Java saved";
    }
    @GetMapping(value = "/jokes")
    public String getJokes() {

//        jokesList.add("What is a little bear with no teeth is called?\n" +
//                "\n" +
//                "A gummy bear.");
//        jokesList.add("What's an alligator in a vest called?\n" +
//                "\n" +
//                "An investigator");
//        jokesList.add("What's the best way to throw a birthday party on Mars?\n " +
//                "\n" +
//                "You planet.");
//        jokesList.add("What is cheese that doesn't belong to you called?\n" +
//                "\n" +
//                "Nacho cheese!");
//        jokesList.add("What's one way we know the ocean is friendly?\n" +
//                "\n" +
//                "It waves.");
        int randomNumber = 0 + (int) (Math.random() * ((jokesList.size()-1-0) + 1));
        return jokesList.get(randomNumber);

    }

}
