package com.ktds.cocomo.mybeacon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.estimote.sdk.SystemRequirementsChecker;

public class MainActivity extends CustomAppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("                      Smart Check");

        btn1= (Button)findViewById(R.id.imagebtn2);
        btn2= (Button)findViewById(R.id.imagebtn3);
        btn3=(Button)findViewById(R.id.imagebtn1);

btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
Intent intent1 = new Intent(MainActivity.this,Attandance.class);
        startActivity(intent1);
    }
});
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,CreateAtt.class);
                startActivity(intent2);
            }
        });

btn3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent3 = new Intent(MainActivity.this,CheckCheck.class);
        startActivity(intent3);
    }
});

    }


    @Override
    protected void onResume() {
        super.onResume();

        // 블루투스 권한 및 활성화 코드드
        SystemRequirementsChecker.checkWithDefaultDialogs(this);
    }
}
