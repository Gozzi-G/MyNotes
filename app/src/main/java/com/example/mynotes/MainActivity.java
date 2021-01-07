package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    private ArrayList<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        notes.add(new Note("Парикмахер", "Сделать прическу", "Вторник", 2));
        notes.add(new Note("Ремон", "Забрать ванную", "среда", 1));
        notes.add(new Note("Автомобиль", "Заправить", "Вторник", 3));
        notes.add(new Note("Учеба", "Сделать прическу", "Вторник", 2));
        notes.add(new Note("Тренировка", "Сделать прическу", "Вторник", 2));
    }
}