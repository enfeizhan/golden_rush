package com.example.learnandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView txtCounter;
    private Button btnPlus, btnMinus, btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCounter = findViewById(R.id.text_counter);
        /*btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnReset = findViewById(R.id.btn_reset);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt(txtCounter.getText().toString());
                counter++;
                txtCounter.setText(counter+"");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = Integer.parseInt(txtCounter.getText().toString());
                counter--;
                txtCounter.setText(counter+"");
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCounter.setText("0");
            }
        });*/
    }
    public void plusFunction () {
        int counter = Integer.parseInt(txtCounter.getText().toString());
        counter++;
        txtCounter.setText(counter+"");
    }
    public void minusFunction () {
        int counter = Integer.parseInt(txtCounter.getText().toString());
        if (counter > 0) {
            counter--;
            txtCounter.setText(counter + "");
        }
    }
    public void resetFunction () {
        txtCounter.setText("0");
    }

    public void operation (View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_plus:
                plusFunction();
                break;
            case R.id.btn_minus:
                minusFunction();
                break;
            case R.id.btn_reset:
                resetFunction();
                break;
        }
    }
}