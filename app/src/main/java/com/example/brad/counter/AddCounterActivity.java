package com.example.brad.counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;


public class AddCounterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcounter);

        //CONFIRM ADD COUNTER
        Button button = (Button) findViewById(R.id.confirmcounter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                //exit to MainActivity
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        //CANCEL ADD COUNTER
        Button button2 = (Button) findViewById(R.id.canceladd);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
    }
}

  //receive inputs
        //initialize constructer with the inputs
        //add constructor to list

        //confirm button pressed
