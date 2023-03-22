package pages;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ExpFourthInfo extends AppCompatActivity {
    private Button edit_info;
    private TextView user_id,user_name,user_phone,user_email;
    private String userId,userName,userPhone,userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_fourth_info);
        setTitle("个人信息");
        //获取标签
        user_id = findViewById(R.id.user_id);
        user_name = findViewById(R.id.user_name);
        user_phone = findViewById(R.id.user_phone);
        user_email = findViewById(R.id.user_email);
        edit_info = findViewById(R.id.edit_info);
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
                intent1.setClass(ExpFourthInfo.this,ExpFourthEditInfo.class);
                startActivityForResult(intent1,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        userName = data.getStringExtra("user_name");
        userPhone = data.getStringExtra("user_phone");
        userEmail = data.getStringExtra("user_email");
        user_name.setText(userName);
        user_phone.setText(userPhone);
        user_email.setText(userEmail);
    }
}