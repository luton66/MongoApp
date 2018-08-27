package com.fecklefacemassive.www.education.MongoApp.pojo;

import org.springframework.data.annotation.Id;

public class Beginning {
    @Id
    public String id;

    public String name;

    public Beginning() {}

    public Beginning(String name) {
        this.name = name;
    }
}
