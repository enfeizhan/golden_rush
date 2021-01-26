package com.example.learnandroid;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnandroid.model.AddCameraResponse;
import com.example.learnandroid.model.RemoveCameraResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.learnandroid.APIClient.getAPIClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtCounter;
    private Button btnPlus, btnMinus, btnReset, btnHideShow, addCamera, removeCamera;
    private WebView webcam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCounter = findViewById(R.id.text_counter);
        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnReset = findViewById(R.id.btn_reset);
        btnHideShow = findViewById(R.id.btn_hide_show);
        addCamera = findViewById(R.id.btn_add_camera);
        removeCamera = findViewById(R.id.btn_remove_camera);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnHideShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (ivMeme.getVisibility() == View.VISIBLE) {
                    ivMeme.setVisibility(View.GONE);
                } else {
                    ivMeme.setVisibility(View.VISIBLE);
                }*/
            }
        });
        APIService apiService = getAPIClient().create(APIService.class);
        addCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> addCameraBody = new HashMap<>();
                addCameraBody.put("camURL", "0");
                addCameraBody.put("application", "detect_motion");
                addCameraBody.put("detectionMethod", "opencv");
                addCameraBody.put("camUUID", "ok");
                Call<AddCameraResponse> call = apiService.AddCamera(addCameraBody);
                call.enqueue(new Callback<AddCameraResponse>() {
                    @Override
                    public void onResponse(Call<AddCameraResponse> call, Response<AddCameraResponse> response){
                        webcam = findViewById(R.id.webcam);
                        webcam.loadUrl("http://192.168.1.109:5000/api/video/video_streamer/ok");
                    }
                    @Override
                    public void onFailure(Call<AddCameraResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Could not retrieve data!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        removeCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> removeCameraBody = new HashMap<>();
                removeCameraBody.put("camUUID", "ok");
                Call<RemoveCameraResponse> call = apiService.RemoveCamera(removeCameraBody);
                call.enqueue(new Callback<RemoveCameraResponse>() {
                    @Override
                    public void onResponse(Call<RemoveCameraResponse> call, Response<RemoveCameraResponse> response) {
                    }
                    @Override
                    public void onFailure(Call<RemoveCameraResponse> call, Throwable t) {
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