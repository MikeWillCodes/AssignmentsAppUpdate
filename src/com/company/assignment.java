package com.company;

import java.util.Random;

public class assignment {

    public String day;
    public String courses;
    public String category;
    public Integer priority;


    public assignment(String day, String courses, String category, Integer priority) {
        this.day = day;
        this.courses = courses;
        this.category = category;
        this.priority = priority;
    }

    public String getDay() {
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
