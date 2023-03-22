package pages;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExpSixthInfo extends AppCompatActivity {
    private Button edit_info,edit_exit_login,tally_book;
    private TextView user_id,user_name,user_phone,user_email;
    private String userId,userName,userPhone,userEmail;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_sixth_info);
        setTitle("个人信息");
        //获取标签
        user_id = findViewById(R.id.user_id);
        user_name = findViewById(R.id.user_name);
        user_phone = findViewById(R.id.user_phone);
        user_email = findViewById(R.id.user_email);
        edit_info = findViewById(R.id.edit_info);
        edit_exit_login = findViewById(R.id.edit_exit_login);
        tally_book = findViewById(R.id.tally_book);
        //实例化sharedPreferences和edit
        sharedPreferences = getSharedPreferences("user", ExpSixth.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        //获取其它页面传送过来的值
        Intent intent = getIntent();
        userId = intent.getStringExtra("user_id");
        userName = intent.getStringExtra("user_name");
        userPhone = intent.getStringExtra("user_phone");
        userEmail = intent.getStringExtra("user_email");
//        if (!intent.getStringExtra("user_id").equals(""))
//            userId = intent.getStringExtra("user_id");
//        if (!intent.getStringExtra("user_name").equals(""))
//            userName = intent.getStringExtra("user_name");
//        if (!intent.getStringExtra("user_phone").equals(""))
//            userPhone = intent.getStringExtra("user_phone");
//        if (!intent.getStringExtra("user_email").equals(""))
//            userEmail = intent.getStringExtra("user_email");
        //设置页面数据
        user_id.setText(userId);
        user_name.setText(userName);
        user_phone.setText(userPhone);
        user_email.setText(userEmail);
        //对编辑信息按钮设置点击事件
        edit_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                intent1.putExtra("user_id",userId);
                intent1.putExtra("user_name",userName);
                intent1.putExtra("user_phone",userPhone);
                intent1.putExtra("user_email",userEmail);
                intent1.setClass(ExpSixthInfo.this,ExpSixthEditInfo.class);
                startActivityForResult(intent1,1);
            }
        });
        //退出登入按钮设置点击事件
        edit_exit_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exitLogin = new Intent();
                editor.remove("isLogin");
                editor.apply();
                exitLogin.setClass(ExpSixthInfo.this,ExpSixth.class);
                startActivity(exitLogin);
            }
        });
        //点击记账本按钮(tally_book)跳转到记账本界面
        tally_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                intent1.setClass(ExpSixthInfo.this,ExpSixthTallyBook.class);
                startActivity(intent1);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //实例化sharedPreferences和edit
        sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        userName = data.getStringExtra("user_name");
        userPhone = data.getStringExtra("user_phone");
        userEmail = data.getStringExtra("user_email");
        user_name.setText(userName);
        user_phone.setText(userPhone);
        user_email.setText(userEmail);
    }
}