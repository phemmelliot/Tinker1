package com.example.toyin.tinker.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.toyin.tinker.R;

public class Back extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_main);
    }
    public void backClick(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
