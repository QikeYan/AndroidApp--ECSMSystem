package com.test.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.test.myapplication.R;

public class MainActivity extends Activity implements View.OnClickListener {
    private LinearLayout lin_one, lin_two, lin_three, lin_four;

    @Override//initial an activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();

        onClick();
    }

    private void findViewById() {
        lin_one = (LinearLayout) findViewById(R.id.lin_one);//get the specific View by id and assign a new name
        lin_two = (LinearLayout) findViewById(R.id.lin_two);
        lin_three = (LinearLayout) findViewById(R.id.lin_three);
        lin_four = (LinearLayout) findViewById(R.id.lin_four);
    }

    private void onClick() {
        lin_one.setOnClickListener(this);// PLACE ACTION LISTENER
        lin_two.setOnClickListener(this);
        lin_three.setOnClickListener(this);
        lin_four.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin_one:
//                Toast.makeText(this,"lin_one",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, ThirdActivity.class);// ==intent.setClass(this, SecondActivity.class); 跳转另一个activity
                intent.putExtra("name", "Electricity Consumption Sum Of ALL Stations");
                startActivity(intent);// Start Activity
                break;
            case R.id.lin_two:
//                Toast.makeText(this,"lin_two",Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(this, StationsListActivity.class);
                intent1.putExtra("tag", 1);//为intent添加额外的信息  
                startActivity(intent1);
                break;
            case R.id.lin_three:
                Intent intent2 = new Intent(this, StationsListActivity.class);
                intent2.putExtra("tag", 2);

                startActivity(intent2);

//                Toast.makeText(this,"lin_three",Toast.LENGTH_LONG).show();
                break;
            case R.id.lin_four:
//                Toast.makeText(this,"lin_four",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
