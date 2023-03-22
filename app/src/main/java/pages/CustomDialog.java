package pages;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;



import po.User;


public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView mTitle, mMessage, mCancer, mConfirm;
    private EditText add_user, add_introduction;
    private String title, message, cancel, confirm;
    private IOnCancelListener cancelListener;
    private IOnConfirmListener confirmListener;

    private User user;
    //Dialog的构造方法，继承Dialog需要写出其相应构造方法
    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public User getUser() {
        return this.user;
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    //public CustomDialog返回值是CustomDialog,不是void，所以使用CustomDialog自定义类型时只需要  .方法
//在private String title,message,cancel,confirm;中右键,Generate，setter中快捷构建相应方法
    public CustomDialog setTitle(String title) {
        this.title = title;
        //可以使用return this，来返回某个类的引用。此时这个this关键字就代表类的名称,即CustomDialog
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;
    }

    //重写onCreate方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog);

        //设置宽度
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * 0.9);//设置diglog的宽度是手机屏幕宽度的80％
        getWindow().setAttributes(p);


        add_user= (EditText) findViewById(R.id.dialog_add_user);
        add_introduction = (EditText) findViewById(R.id.dialog_add_introduction);
        mCancer = (TextView) findViewById(R.id.tv_cancel);
        mConfirm = (TextView) findViewById(R.id.tv_confirm);

        //使用TextUtils.isEmpty()，用来判断字符串是否为空
        if (!TextUtils.isEmpty(title)) {
            mTitle.setText(title);
        }
        mCancer.setOnClickListener(this);
        mConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                if (cancelListener != null) {
                    cancelListener.onCancel(this);
                }
                dismiss();
                break;
            case R.id.tv_confirm:
                if (confirmListener != null) {
                    this.user = new User();
                    this.user.setName(add_user.getText().toString());
                    this.user.setMessage(add_introduction.getText().toString());
                    this.user.setUrl("https://img.tukuppt.com/photo-big/00/00/94/6152bc0ce6e5d805.jpg");
                    confirmListener.onConfirm(this);
                     }
                dismiss();
                break;
        }
    }

    public interface IOnCancelListener {
        void onCancel(CustomDialog dialog);
    }

    public interface IOnConfirmListener {
        void onConfirm(CustomDialog dialog);

    }
}
