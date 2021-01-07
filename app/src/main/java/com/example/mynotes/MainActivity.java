package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    public static final ArrayList<Note> NOTES = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        NOTES.add(new Note("Парикмахер", "Сделать прическу", "Вторник", 2));
        NOTES.add(new Note("Ремон", "Забрать ванную", "среда", 1));
        NOTES.add(new Note("Автомобиль", "Заправить", "Вторник", 3));
        NOTES.add(new Note("Учеба", "Сделать прическу", "Вторник", 2));
        NOTES.add(new Note("Тренировка", "Сделать прическу", "Вторник", 2));
        NotesAdapter adapter = new NotesAdapter(NOTES);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewNotes.setAdapter(adapter);
    }

    public void onClickAddNote(View view) {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
    }
}