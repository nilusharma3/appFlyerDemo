package com.example.anil.appflyerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.appsflyer.AFInAppEventParameterName;
import com.example.anil.appflyerdemo.r.ApiClient;
import com.example.anil.appflyerdemo.r.ApiInterface;
import com.example.anil.appflyerdemo.r.CommonResponse;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEventA, btnEventB, btnEventC, btnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        btnEventA = findViewById(R.id.btnEventA);
        btnEventB = findViewById(R.id.btnEventB);
        btnEventC = findViewById(R.id.btnEventC);
        btnMove = findViewById(R.id.btnMove);

        btnEventA.setOnClickListener(this);
        btnEventB.setOnClickListener(this);
        btnEventC.setOnClickListener(this);
        btnMove.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.btnEventA:
                triggerEventA();
                break;
            case R.id.btnEventB:
                triggerEventB();
                break;
            case R.id.btnEventC:
                triggerEventC();
                //d();
                break;
            case R.id.btnMove:
                moveToSecondActivity();
                break;
            default:
                break;
        }
    }


    private void moveToSecondActivity() {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }


    private void triggerEventA() {
        Map<String, Object> evenData = new HashMap<>();
        evenData.put("name", "dummyNAme");
        evenData.put(AFInAppEventParameterName.CITY, "CHD");
        evenData.put("field_for_a", "event A");
        AppFlyerEventHandler.logAppFlyerEvent(AppFlyerEventHandler.EVENT_A, evenData);
    }


    private void triggerEventB() {
        Map<String, Object> evenData = new HashMap<>();
        evenData.put("name", "dummyName");
        evenData.put(AFInAppEventParameterName.CITY, "US");
        evenData.put("field_for_a", "event B");
        AppFlyerEventHandler.logAppFlyerEvent(AppFlyerEventHandler.EVENT_B, evenData);
    }


    private void triggerEventC() {
        Map<String, Object> evenData = new HashMap<>();
        evenData.put("name", "dummyName");
        evenData.put(AFInAppEventParameterName.CITY, "UK");
        evenData.put("field_for_a", "event C");
        AppFlyerEventHandler.logAppFlyerEvent(AppFlyerEventHandler.EVENT_C, evenData);
    }

    private void d() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getAppVersion("en");
        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(final Call<CommonResponse> call, final Response<CommonResponse> response) {
                Log.e("ddddd", "ddddd " + response.message() + response.body().toString());
            }

            @Override
            public void onFailure(final Call<CommonResponse> call, final Throwable t) {

            }
        });
    }


}
