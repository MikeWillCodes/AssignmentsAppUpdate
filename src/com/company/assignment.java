package com.company;

import java.time.LocalDateTime;
import java.util.Random;

public class assignment {

    public LocalDateTime day;
    public String courses;
    public String category;
    public Integer priority;


    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPriority() {
        Random random = new Random();
        priority = random.nextInt(3);
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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
