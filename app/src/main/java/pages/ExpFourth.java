package pages;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ExpFourth extends AppCompatActivity {
    private EditText user;
    private EditText password;
    private TextView forgetPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_fourth);
        setTitle("主页");
        //获取标签
        btnLogin = findViewById(R.id.login);
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        forgetPassword = findViewById(R.id.forgetPassword);

        //登入按钮监听
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(user.getText().toString().equals("") || password.getText().toString().equals("")){
                    Toast.makeText(ExpFourth.this,"用户名和密码不能为空",Toast.LENGTH_LONG)
                            .show();
                }else {
                    Intent intent = new Intent();
                    intent.putExtra("user_id",user.getText().toString());
                    intent.setClass(ExpFourth.this,ExpFourthInfo.class);
                    startActivity(intent);
                }
            }
        });

        //忘记密码监听事件
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ExpFourth.this,"您点击了忘记密码",Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}