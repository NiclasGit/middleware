package com.example.Middleware;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    long Id;

    String todo;

    public Todo(){}
}
