package com.example.task4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.task4.model.User;


public class DetailActivity extends AppCompatActivity {
    static  final String TAG = DetailActivity.class.toString();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_main);
        initViews();
    }
    void initViews(){
        TextView tv_detail = findViewById(R.id.tv_detail);
        Button b_exit = findViewById(R.id.b_exit);
        b_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backtoFinish();
            }
        });
        User user = (User) getIntent().getSerializableExtra("user");
        Log.d(TAG, user.toString());
        tv_detail.setText(user.toString());
    }

    void backtoFinish(){
        Intent intent = new Intent();
        intent.putExtra("member", "In Gold Member");
        setResult(Activity.RESULT_OK, intent);
//        Finish ni ozi yopib beradi tepadigilar esa malumotni qaytarb yuboradi
        finish();
    }
}
