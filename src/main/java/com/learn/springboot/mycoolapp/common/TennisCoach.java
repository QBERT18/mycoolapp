package com.learn.springboot.mycoolapp.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley for 30 minutes.";
    }
}
