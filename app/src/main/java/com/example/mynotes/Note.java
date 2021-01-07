package com.example.mynotes;

import android.content.SharedPreferences;

public class Note {
    private String title;
    private String description;
    private String dayOfWeak;
    private int priority;

    public Note (String title, String description, String dayOfWeak, int priority) {
        this.title = title;
        this.description = description;
        this.dayOfWeak = dayOfWeak;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDayOfWeak() {
        return dayOfWeak;
    }

    public int getPriority() {
        return priority;
    }
}
