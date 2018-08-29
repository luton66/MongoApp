package com.fecklefacemassive.www.education.MongoApp.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MyBalls")
public class Balls {
    @Id
    String id;

    public String ballName;
    public String ballType;
}
