package com.example.learnandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnandroid.model.SearchResponse;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtCounter;
    private Button btnPlus, btnMinus, btnReset, btnHideShow, send;
    private ImageView ivMeme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCounter = findViewById(R.id.text_counter);
        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnReset = findViewById(R.id.btn_reset);
        btnHideShow = findViewById(R.id.btn_hide_show);
        ivMeme = findViewById(R.id.iv_meme);
        send = findViewById(R.id.btn_send);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnHideShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ivMeme.getVisibility() == View.VISIBLE) {
                    ivMeme.setVisibility(View.GONE);
                } else {
                    ivMeme.setVisibility(View.VISIBLE);
                }
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIService apiService = APIClient.getAPIClient().create(APIService.class);
                Map<String, String> params = new HashMap<>();
                params.put("action", "query");
                params.put("format", "json");
                params.put("list", "search");
                params.put("srsearch", "Nikola Tesla");

                Call<SearchResponse> call = apiService.searchWiki(params);
                call.enqueue(new Callback<SearchResponse>() {
                    @Override
                    public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {

                    }

                    @Override
                    public void onFailure(Call<SearchResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Could not retrieve data!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

/*
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
        Toast.makeText(this, "Plus Button Is Clicked", Toast.LENGTH_SHORT).show();
        int counter = Integer.parseInt(txtCounter.getText().toString());
        counter++;
        txtCounter.setText(counter+"");
    }
    public void minusFunction () {
        Toast.makeText(this, "Minus Button Is Clicked", Toast.LENGTH_SHORT).show();
        int counter = Integer.parseInt(txtCounter.getText().toString());
        if (counter > 0) {
            counter--;
            txtCounter.setText(counter + "");
        }
    }
    public void resetFunction () {
        Toast.makeText(this, "Reset Button Is Clicked", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onClick(View v) {
        operation(v);
    }
}