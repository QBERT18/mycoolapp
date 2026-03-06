package com.learn.springboot.mycoolapp.rest;

import com.learn.springboot.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("aquatic") Coach newCoach,
                          @Qualifier("cricketCoach") Coach newAnotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = newCoach;
        this.anotherCoach = newAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String getAnotherDailyWorkout() {
        return "Comparing beans: myCoach == anotherCoach? " + (myCoach == anotherCoach);
    }
}
