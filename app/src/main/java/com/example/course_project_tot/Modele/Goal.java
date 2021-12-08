package com.example.course_project_tot.Modele;

import java.time.LocalDate;
import java.util.UUID;

public class Goal{
    private String id;
    private String name;
    private LocalDate date;
    private String description;
    private int timeRequired;
    private int priority;

    private Goal(Builder builder) {
        id = builder.id;
        name = builder.name;
        date = builder.date;
        description = builder.description;
        timeRequired = builder.timeRequired;
        priority = builder.priority;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getTimeRequired() {
        return timeRequired;
    }

    public int getPriority() {
        return priority;
    }

    public static class Builder {
        private String id;
        private String name;
        private LocalDate date;
        private String description;
        private int timeRequired;
        private int priority;

        public Builder(String name) {
            this.id = UUID.randomUUID().toString();
            this.name = name;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder timeRequired(int timeRequired) {
            this.timeRequired = timeRequired;
            return this;
        }

        public Builder priority(int priority) {
            this.priority = priority;
            return this;
        }

        public Goal build() {
            return new Goal(this);
        }

    }

}
