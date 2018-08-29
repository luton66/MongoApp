package com.fecklefacemassive.www.education.MongoApp.RestControllers;

import com.fecklefacemassive.www.education.MongoApp.Dao.BallsRepo;
import com.fecklefacemassive.www.education.MongoApp.pojo.Balls;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/balls")

public class BallsRest {
    private BallsRepo repo;

    public BallsRest(BallsRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public List<Balls> getAllBalls() {
        List<Balls> balls = repo.findAll();
        return balls;
    }

    @PostMapping
    public void addBall(@RequestBody Balls ball) {
        repo.insert(ball);
    }

}
