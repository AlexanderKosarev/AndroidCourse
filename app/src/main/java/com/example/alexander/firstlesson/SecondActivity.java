package com.example.alexander.firstlesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText editText;
    public final static String CALLBACK = "com.example.alexander.firstlesson.CALLBACK";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = findViewById(R.id.editText);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra(CALLBACK, editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
