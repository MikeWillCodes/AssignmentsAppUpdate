package com.company;

import java.util.Random;

public class assignment {

    public Main.DaysOfTheWeek day;
    public Main.CourseList courses;
    public Main.Category category;
    public Integer priority;


    public assignment(Main.DaysOfTheWeek day, Main.CourseList courses, Main.Category category, Integer priority) {
        this.day = day;
        this.courses = courses;
        this.category = category;
        this.priority = priority;
    }

    public Main.DaysOfTheWeek getDay() {
        return day;
    }

    public Main.CourseList getCourses() {
        return courses;
    }

    public Main.Category getCategory() {
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
