package cz.moneta.interview.controllers;

import cz.moneta.interview.models.QueueItem;
import cz.moneta.interview.services.Exercise1;
import cz.moneta.interview.services.Exercise2;
import cz.moneta.interview.services.Exercise3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private final Exercise1 exercise1;
    private final Exercise2 exercise2;
    private final Exercise3 exercise3;

    @Autowired
    public MainController(Exercise1 exercise1, Exercise2 exercise2, Exercise3 exercise3) {
        this.exercise1 = exercise1;
        this.exercise2 = exercise2;
        this.exercise3 = exercise3;
    }

    @GetMapping(value = "/exercise1")
    public ResponseEntity<String> exercise1(@RequestParam(value = "input", required = true) String input) {
        return ResponseEntity.ok(exercise1.reverseString(input));
    }

    @GetMapping(value = "/exercise2")
    public ResponseEntity<String> exercise2(@RequestParam(value = "input", required = true) Long input) {
        return ResponseEntity.ok(exercise2.compute(input));
    }

    @GetMapping(value = "/exercise3/new")
    public ResponseEntity<QueueItem> exercise3Add() {
        return ResponseEntity.ok(exercise3.addToQueue());
    }

    @GetMapping(value = "/exercise3/all")
    public ResponseEntity<List<QueueItem>> exercise3All() {
        return ResponseEntity.ok(exercise3.getActualStateOfQueue());
    }

    @GetMapping(value = "/exercise3/actual")
    public ResponseEntity<QueueItem> exercise3Actual() {
        return ResponseEntity.ok(exercise3.getActual());
    }

    @GetMapping(value = "/exercise3/pop")
    public ResponseEntity<QueueItem> exercise3Pop() {
        return ResponseEntity.ok(exercise3.removeLast());
    }
}
