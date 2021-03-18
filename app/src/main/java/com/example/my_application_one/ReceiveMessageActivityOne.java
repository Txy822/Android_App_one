package com.example.my_application_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivityOne extends AppCompatActivity {

    public static final String INTENT_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message_one);

        Intent intent = getIntent();
        String text = intent.getStringExtra(INTENT_MESSAGE);
        TextView receivedMessage = findViewById(R.id.messageReceived);
        receivedMessage.setText(text);
    }
}