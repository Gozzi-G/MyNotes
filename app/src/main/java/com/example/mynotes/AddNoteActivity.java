package com.example.mynotes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class AddNoteActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextDescription;
    private Spinner spinnerDayOfWeak;
    private RadioGroup radioGroupPriority;

//    private NotesDBHelper dbHelper;
//    private SQLiteDatabase database;

    private NotesDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        dataBase = NotesDataBase.getInstance(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

//        dbHelper = new NotesDBHelper(this);
//        database = dbHelper.getWritableDatabase();
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        spinnerDayOfWeak = findViewById(R.id.spinnerDayOfWeak);
        radioGroupPriority = findViewById(R.id.radioGroupPriority);
    }

    public void onClickSaveNote(View view) {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        int dayOfWeak = spinnerDayOfWeak.getSelectedItemPosition();

        int radioButtonId = radioGroupPriority.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButtonId);
        int priority = Integer.parseInt(radioButton.getText().toString());

//        if (isFilled(title, description)) {
//            ContentValues contentValues = new ContentValues();
//            contentValues.put(NotesContract.NotesEntry.COLUMN_TITLE, title);
//            contentValues.put(NotesContract.NotesEntry.COLUMN_DESCRIPTION, description);
//            contentValues.put(NotesContract.NotesEntry.COLUMN_DAY_OF_WEEK, dayOfWeak + 1);
//            contentValues.put(NotesContract.NotesEntry.COLUMN_PRIORITY, priority);
//            database.insert(NotesContract.NotesEntry.TABLE_NAME, null, contentValues);
//
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//        } else {
//            Toast.makeText(this, R.string.warning_fill_fields, Toast.LENGTH_SHORT).show();
//        }

        if(isFilled(title, description)) {
            Note note = new Note(title, description, dayOfWeak, priority);
            dataBase.notesDao().insertNote(note);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.warning_fill_fields, Toast.LENGTH_SHORT).show();
        }



    }

    private boolean isFilled(String title, String description) {
        return !title.isEmpty() && !description.isEmpty();
    }
}