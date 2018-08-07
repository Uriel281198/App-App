package walpaper.appchan.com.appchan.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import walpaper.appchan.com.appchan.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout l1,l2;

    private Animation uptodown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l1= findViewById(R.id.l1);
        l2= findViewById(R.id.l2);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        l1.setAnimation(uptodown);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent  = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },5000);


    }
}
