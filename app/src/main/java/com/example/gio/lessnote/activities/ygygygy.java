package com.example.gio.lessnote.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.gio.lessnote.R;

public class ygygygy extends AppCompatActivity implements View.OnClickListener {

    private Button a;
    private Button s;
    private Button d;
    private Button aw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ygygygy);
        initView();

    }

    private void initView() {
        a = (Button) findViewById(R.id.a);
        s = (Button) findViewById(R.id.s);
        d = (Button) findViewById(R.id.d);
        aw = (Button) findViewById(R.id.aw);

        a.setOnClickListener(this);
        s.setOnClickListener(this);
        d.setOnClickListener(this);
        aw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a:

                break;
            case R.id.s:

                break;
            case R.id.d:

                break;
            case R.id.aw:

                break;
        }
    }
}
