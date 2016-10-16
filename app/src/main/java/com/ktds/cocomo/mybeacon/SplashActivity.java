package com.ktds.cocomo.mybeacon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final String executeType = getIntent().getStringExtra("executeType");

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = null;

                // 비콘에의해 실행될 때와 아닐때 이동될 Activity를 다르게 줄 수 있습니다.
                if(executeType != null && executeType.equals("beacon")) {
                    intent = new Intent(SplashActivity.this, CouponActivity.class);
                } else {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                }
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                /*
                이 엑티비티 플래그를 사용하여 엑티비티를 호출하게 되면 새로운 태스크를 생성하여 그 태스크안에 엑티비티를 추가하게 됩니다.
                단, 기존에 존재하는 태스크들중에 생성하려는 엑티비티와 동일한 affinity를 가지고 있는 태스크가 있다면 그곳으로 새 엑티비티가 들어가게됩니다.

                하나의 어플리케이션안에서는 모든 엑티비티가 기본 affinity를 가지고 같은 태스크안에서 동작하는것이 기본적(물론 변경이 가능합니다)이지만
                FLAG_ACTIVITY_MULTIPLE_TASK 플래그와 함께 사용하지 않을경우 무조건적으로 태스크가 새로 생성되는것은 아님을 주의하셔야 합니다.
                 */
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
