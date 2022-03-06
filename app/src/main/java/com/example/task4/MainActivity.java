package com.example.task4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.task4.model.User;

public class MainActivity extends AppCompatActivity {
    static  final String TAG = MainActivity.class.toString();
    int LAUNCH_DETAIL = 1001;
    TextView tv_home;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == LAUNCH_DETAIL){
            if(resultCode == Activity.RESULT_OK){
                String member = data.getStringExtra("member");
                Log.d(TAG, member);
                tv_home.setText(member);
            }
        }
    }
    void initViews(){
        tv_home = findViewById(R.id.tv_home);
        Button b_detail = findViewById(R.id.b_detail);
        b_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(20, "Jafar");
                openDetailActivity(user);
            }
        });
    }
    void openDetailActivity(User user){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("user", user);
//        startActivity(intent);
        startActivityForResult(intent, LAUNCH_DETAIL);
    }
}