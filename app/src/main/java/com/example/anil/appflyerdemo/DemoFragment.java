package com.example.anil.appflyerdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.appsflyer.AFInAppEventParameterName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anil on 2/22/18.
 */

public class DemoFragment extends Fragment implements View.OnClickListener {

    private Context mContext;

    private Button btnA2, btnA1;

    public DemoFragment() {

    }

    public static DemoFragment newInsatnce() {
        return new DemoFragment();
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_layout, container, false);
        initViews(view);
        return view;
    }


    private void initViews(final View view) {
        btnA1 = view.findViewById(R.id.btnA1);
        btnA2 = view.findViewById(R.id.btnA2);

        btnA1.setOnClickListener(this);
        btnA2.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.btnA1:
                trigrEventA1();
                break;
            case R.id.btnA2:
                trigrEventA2();
                break;
            default:
                break;
        }
    }


    private void trigrEventA1() {
        Map<String, Object> evenData = new HashMap<>();
        evenData.put("name", "dummyName");
        evenData.put("field_for_a", "frg event A1");
        AppFlyerEventHandler.logAppFlyerEvent(AppFlyerEventHandler.EVENT_A1, evenData);
    }


    private void trigrEventA2() {
        Map<String, Object> evenData = new HashMap<>();
        evenData.put("name", "dummyName");
        evenData.put("field_for_a", "frg event A2");
        AppFlyerEventHandler.logAppFlyerEvent(AppFlyerEventHandler.EVENT_A2, evenData);
    }


}
