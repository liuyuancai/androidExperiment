package pages;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import po.User;

public class ExpThirdListView extends AppCompatActivity {
    private ListView usersView;
    private Button addUser;
    private List<User> userList;
    private TextView userTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_third_list_view);
        //获取标签
        usersView = findViewById(R.id.list_view);
        addUser = findViewById(R.id.addFriend);
        userList =new ArrayList<User>();
        //初始化数据
        userList.add(new User("刘","https://img.tukuppt.com/photo-big/00/00/94/6152bc0ce6e5d805.jpg","软件工程师"));
        userList.add(new User("李","https://img0.baidu.com/it/u=1435639120,2241364006&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500","建筑工程师"));
        userList.add(new User("施","https://img2.baidu.com/it/u=861863691,2776527252&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500","中医学"));
        userList.add(new User("黄","https://img2.baidu.com/it/u=1577373388,3492284830&fm=253&fmt=auto&app=120&f=JPEG?w=1280&h=800","数学家"));

        //设置适配器
        UserAdapter userAdapter = new UserAdapter(ExpThirdListView.this,R.layout.user_itme,userList);
        usersView.setAdapter(userAdapter);

        //设置ListView里面每个item的短点击事件
        usersView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                userTitle = view.findViewById(R.id.user_title);
                Toast.makeText(ExpThirdListView.this,"您点击了"+userTitle.getText().toString(),Toast.LENGTH_SHORT)
                        .show();
            }
        });
        //设置ListView里面每个item的长点击事件
        usersView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                int item = i;
                AlertDialog.Builder builder = new AlertDialog.Builder(ExpThirdListView.this);
                builder.setTitle("是否删除该联系人")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                userList.remove(item);
                                userAdapter.notifyDataSetChanged();
                            }})
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(ExpThirdListView.this,"已取消",Toast.LENGTH_LONG)
                                        .show();
                            }})
                        .show();
                return true;
            }
        });
        //给addUser添加点击事件，该事件为添加联系人
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(ExpThirdListView.this);
                customDialog.setCancel("取消", new CustomDialog.IOnCancelListener() {
                            @Override
                            public void onCancel(CustomDialog dialog) {
                                Toast.makeText(ExpThirdListView.this,"已取消",Toast.LENGTH_LONG)
                                        .show();
                            }})
                        .setConfirm("确认",new CustomDialog.IOnConfirmListener() {
                            @Override
                            public void onConfirm(CustomDialog dialog) {
                                userAdapter.addView(customDialog.getUser());
                                Toast.makeText(ExpThirdListView.this,"添加成功",Toast.LENGTH_LONG)
                                        .show();
                            }}).show();
            }
        });
    }
}