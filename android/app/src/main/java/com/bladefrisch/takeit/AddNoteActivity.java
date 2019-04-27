package com.bladefrisch.takeit;

import com.bladefrisch.takeit.data.NoteRepository;
import com.bladefrisch.takeit.data.entity.Note;
import com.bladefrisch.takeit.utils.InjectorUtils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import androidx.core.app.NavUtils;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;

public class AddNoteActivity extends AppCompatActivity {

    private NoteRepository    mRepository;
    private MaterialButton    mSubmitButton;
    private TextInputEditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRepository = InjectorUtils.provideRepository(getApplicationContext());

        mEditText = findViewById(R.id.note_edit_text);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length() == 0) {
                    mSubmitButton.setEnabled(false);
                } else {
                    mSubmitButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        mSubmitButton = findViewById(R.id.submit);
        mSubmitButton.setOnClickListener((View v) -> {
            takeNote();
            NavUtils.navigateUpFromSameTask(this);
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(AddNoteActivity.this);
        }

        return super.onOptionsItemSelected(item);
    }

    private void takeNote() {
        String text = mEditText.getEditableText().toString();
        Note   note = new Note();
        note.text = text;

        mRepository.takeNote(note);
    }
}