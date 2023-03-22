package pages;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ExpSecond extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private TextView forgetPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_second);
        //日志
        String content = "日志信息";
        Log.d("tag",content);

        //获取标签
        btnLogin = findViewById(R.id.login);
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        forgetPassword = findViewById(R.id.forgetPassword);

        //登入按钮监听
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ExpSecond.this)
                        .setTitle("简单对话框")
                        .setIcon(R.drawable.baseline_lock_24)
                        .setMessage("您刚刚点击了登入按钮!")
                        .setPositiveButton("确定",null)
                        .setNegativeButton("取消",null);
                dialog.create().show();
            }
        });

        //忘记密码监听事件
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ExpSecond.this,"您点击了忘记密码",Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}