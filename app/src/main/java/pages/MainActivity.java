package pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button exp_second,exp_third,exp_fourth,exp_fifth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取标签
        exp_second = findViewById(R.id.exp_second);
        exp_third = findViewById(R.id.exp_third);
        exp_fourth = findViewById(R.id.exp_fourth);
        exp_fifth = findViewById(R.id.exp_fifth);
        //对exp_second设置点击事件
        exp_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ExpSecond.class);
                startActivity(intent);
            }
        });
        //对exp_third设置点击事件
        exp_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ExpThird.class);
                startActivity(intent);
            }
        });
        //对exp_fourth设置点击事件
        exp_fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ExpFourth.class);
                startActivity(intent);
            }
        });
        //对exp_fifth设置点击事件
        exp_fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ExpFifth.class);
                startActivity(intent);
            }
        });
    }
}