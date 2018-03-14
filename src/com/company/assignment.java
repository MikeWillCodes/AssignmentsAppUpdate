package com.company;

import java.time.LocalDateTime;
import java.util.Random;

public class assignment {

    public LocalDateTime day;
    public String courses;
    public String category;
    public Integer priority;


    public assignment(LocalDateTime day, String courses, String category, Integer priority) {
        this.day = day;
        this.courses = courses;
        this.category = category;
        this.priority = priority;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public String getCourses() {
        return courses;
    }

    public String getCategory() {
        return category;
    }

    public Integer getPriority() {
        Random random = new Random();
        priority = random.nextInt(3);
        return priority;
    }
    
    @Override
    public String toString() {
        return "assignment{" +
                "day=" + day +
                ", courses='" + courses + '\'' +
                ", category='" + category + '\'' +
                ", priority=" + priority +
                '}';
    }
}
