package com.company;

import java.util.Random;

public class assignment {

    public static Main.DaysOfTheWeek day;
    public Main.CourseList courses;
    public Main.Category category;
    public Integer priority;


    public assignment(Main.DaysOfTheWeek day, Main.CourseList courses, Main.Category category, Integer priority) {
        this.day = day;
        this.courses = courses;
        this.category = category;
        this.priority = priority;
    }

    public static Main.DaysOfTheWeek getDay() {
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

    public assignment(assignment assign){
        this.day = assign.day;
        this.courses = assign.courses;
        this.category = assign.category;
        this.priority = assign.priority;
    }

    public boolean equals(assignment assign){
        return this.day.equals(assign.day) && this.courses.equals(courses) && this.category.equals(category)
                && this.priority.equals(priority);
    }

    public int compareTo(assignment assign){
        return this.day.compareTo(assign.day);
    }
}

