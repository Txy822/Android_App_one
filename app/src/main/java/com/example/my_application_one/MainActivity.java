package com.example.my_application_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickUpdate(View view){
        TextView currentgreeting = (TextView) findViewById(R.id.textView);
        Spinner greetings = (Spinner) findViewById(R.id.spinner);
        currentgreeting.setText(greetings.getSelectedItem().toString());
    }
    public void StopClock(View view){
        Intent intent = new Intent(this, StopClock.class);
        startActivity(intent);
    }
    public void onSendMessage(View view){
        Intent intent = new Intent(this, CreateMessageActivityOne.class);
        //EditText message = (EditText) findViewById(R.id.message);
        //intent.putExtra(ReceiveMessageActivityOne.INTENT_MESSAGE, message.getText().toString());
        startActivity(intent);
    }
    public void timerStart(View view){

    }

    public void timerStop(View view){

    }

    public void timerReset(View view) {

    }


}