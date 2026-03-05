package com.learn.springboot.mycoolapp.rest;

import com.learn.springboot.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController2 {

    private Coach myCoach;

    @Autowired
    public void setCoach(@Qualifier("baseballCoach") Coach newCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = newCoach;
    }

    @GetMapping("/dailyworkout2")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
