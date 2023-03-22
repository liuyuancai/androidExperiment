package pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ExpFourthEditInfo extends AppCompatActivity {
    private Button save_info;
    private EditText user_name,user_phone,user_email;
    private String userName,userPhone,userEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_fourth_edit_info);
        setTitle("编辑个人信息");
        //获取标签
        user_name = findViewById(R.id.user_name);
        user_phone = findViewById(R.id.user_phone);
        user_email = findViewById(R.id.user_email);
        save_info = findViewById(R.id.save_info);
        //获取其它页面传送过来的值
        Intent intent = getIntent();
        userName = intent.getStringExtra("user_name");
        userPhone = intent.getStringExtra("user_phone");
        userEmail = intent.getStringExtra("user_email");
        //设置页面数据
        user_name.setText(userName);
        user_phone.setText(userPhone);
        user_email.setText(userEmail);
        //对保存按钮设置点击事件
        save_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                //获取页面数据
                userName = user_name.getText().toString();
                userPhone = user_phone.getText().toString();
                userEmail = user_email.getText().toString();
                intent1.putExtra("user_name",userName);
                intent1.putExtra("user_phone",userPhone);
                intent1.putExtra("user_email",userEmail);
                ExpFourthEditInfo.this.setResult(RESULT_OK,intent1);
                ExpFourthEditInfo.this.finish();
            }
        });
    }
}