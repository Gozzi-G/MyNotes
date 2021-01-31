package com.example.mynotes;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private static NotesDataBase dataBase;
    private LiveData<List<Note>> notes;


    public MainViewModel(@NonNull Application application) {
        super(application);
        dataBase = NotesDataBase.getInstance(getApplication());
        notes = dataBase.notesDao().getAllNotes();
    }

    public LiveData<List<Note>> getNotes() {
        return notes;
    }

    public void insetNote(Note note) {
        new InsetTask().execute(note);
    }

    public void deleteNote(Note note){
        new DeleteTask().execute(note);
    }

    private static class InsetTask extends AsyncTask<Note, Void, Void> {
        @Override
        protected Void doInBackground(Note... notes) {
            if (notes != null && notes.length > 0) {
               dataBase.notesDao().insertNote(notes[0]);
            }
            return null;
        }
    }

    private static class DeleteTask extends AsyncTask<Note, Void, Void> {
        @Override
        protected Void doInBackground(Note... notes) {
            if (notes != null && notes.length > 0) {
                dataBase.notesDao().deleteNote(notes[0]);
            }
            return null;
        }
    }
}
