package pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ExpSixth extends AppCompatActivity {
    private EditText user;
    private EditText password;
    private TextView forgetPassword;
    private Button btnLogin;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private boolean isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_sixth);
        setTitle("主页");


        //获取标签
        btnLogin = findViewById(R.id.login);
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        forgetPassword = findViewById(R.id.forgetPassword);

        //实例化sharedPreferences和edit
        sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        //给账号密码框赋值
        user.setText(sharedPreferences.getString("user_name",""));
        password.setText(sharedPreferences.getString("user_password",""));

        //判断是否要自动登入
        isLogin = sharedPreferences.getBoolean("isLogin",isLogin);
        if (!user.getText().toString().equals("")&&!password.getText().toString().equals("")){
            if (isLogin){
                Intent intent = new Intent();
                intent.setClass(ExpSixth.this,ExpSixthInfo.class);
                startActivity(intent);
            }
        }

        //登入按钮监听
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(user.getText().toString().equals("") || password.getText().toString().equals("")){
                    Toast.makeText(ExpSixth.this,"用户名和密码不能为空",Toast.LENGTH_LONG)
                            .show();
                }else {
                    Intent intent = new Intent();
                    intent.putExtra("user_id",user.getText().toString());
                    intent.setClass(ExpSixth.this,ExpSixthInfo.class);
                    editor.putString("user_name",user.getText().toString());
                    editor.putString("user_password",password.getText().toString());
                    editor.putBoolean("isLogin",true);
                    editor.apply();
                    startActivity(intent);
                }
            }
        });

        //忘记密码监听事件
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ExpSixth.this,"您点击了忘记密码",Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}