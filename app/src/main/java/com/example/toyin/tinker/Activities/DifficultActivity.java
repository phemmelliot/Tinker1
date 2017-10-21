package com.example.toyin.tinker.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.toyin.tinker.R;

/**
 * Created by Toyin on 29/12/2016.
 */
public class DifficultActivity extends AppCompatActivity {

    public EditText name1;
    public RadioGroup radio;
    public Button start;
    public String difficult = "";
    public String default_name, name;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_page);
        start = (Button) findViewById(R.id.start_button);
        name1 = (EditText) findViewById(R.id.player_name);
        radio = (RadioGroup) findViewById(R.id.radio);

        //Set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



//        Bundle bundle = new Bundle();
//        bundle.putString("name", name.getText().toString());
//        hofFragment hofF = new hofFragment();
//        hofF.setArguments(bundle);

        //Get the name of the player that just finished playing
        default_name = getIntent().getStringExtra("player_name");
        name1.setText(default_name);
    }


    public void buttonClicked(View view) {
        int id = radio.getCheckedRadioButtonId();
        Spinner spinner = (Spinner) findViewById(R.id.select);
        String choice = spinner.toString();

        //Checks if both a radio is picked and a name is inputted
        if (choice == null ||   name1.getText().toString().isEmpty()) {
            Toast.makeText(this, "You have to pick a difficulty level", Toast.LENGTH_SHORT).show();
        }
        else  if (choice == null &&  name1.getText().toString().isEmpty() ) {
            Toast.makeText(this, "You have to pick a difficulty level", Toast.LENGTH_SHORT).show();
        }
        else
        {
            //Switch decision for the clicked button.
            switch (choice){
                case "Easy":
                    difficult = "easy";
                    break;
                case "Medium":
                    difficult = "medium";
                    break;
                case "Difficult":
                    difficult = "hard";
                    break;
                default:
                    break;
            }
            //Get the name and send it to the QuestionActivity.
            name = name1.getText().toString();
            //Start the QuestionActivity Activity.
            Intent intent = new Intent(this, QuestionActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("player_name", name);
            intent.putExtra("difficult", difficult);
            startActivity(intent);

        }
    }
}
