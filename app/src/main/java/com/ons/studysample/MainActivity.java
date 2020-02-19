package com.ons.studysample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ons.studysample.gridview.GridViewActivity;
import com.ons.studysample.listview.ListViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button01 = findViewById(R.id.button01);
        button01.setOnClickListener(this);

        Button button02 = findViewById(R.id.button02);
        button02.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button01:
                startActivity(new Intent(this, ListViewActivity.class));
                break;

            case R.id.button02:
                startActivity(new Intent(this, GridViewActivity.class));
                break;

            default:
                break;
        }
    }
}
