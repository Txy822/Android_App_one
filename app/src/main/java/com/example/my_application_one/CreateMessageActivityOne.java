package com.example.my_application_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message_one);
    }
    public void onSendMessage(View view){
        Intent intent = new Intent(this, ReceiveMessageActivityOne.class);
        EditText message = (EditText) findViewById(R.id.message);
        intent.putExtra(ReceiveMessageActivityOne.INTENT_MESSAGE, message.getText().toString());
        startActivity(intent);
    }
}