package pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import po.Image;

public class ExpFifth extends AppCompatActivity {

    private Button image_preview,image_next,image_auto,image_stop;
    private static final String TAG = "MainActivity";
    private PagesAdapter pagesAdapter;
    private ViewPager viewPager;
    private List<Image> imageList;
    private int currentItem = 0;
    private final Handler handler = new Handler();
    private static final int CAROUSEL_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_fifth);
        imageList = new ArrayList<>();
        imageList.add(new Image("t2", R.drawable.t2));
        imageList.add(new Image("t3",R.drawable.t3));
        imageList.add(new Image("t4",R.drawable.t4));
        imageList.add(new Image("t5",R.drawable.t5));
        //获取页面
        viewPager = findViewById(R.id.image_view);
        image_preview = findViewById(R.id.image_preview);
        image_next = findViewById(R.id.image_next);
        image_auto = findViewById(R.id.image_auto);
        image_stop = findViewById(R.id.image_stop);
        //获取适配器
        pagesAdapter = new PagesAdapter(imageList,this);
//        myPagerAdapter.setOnBannerClickListener(onBannerClickListener);
        //设置缓存页数
        viewPager.setOffscreenPageLimit(imageList.size()-1);
        viewPager.setAdapter(pagesAdapter);



        //下一张按钮的点击事件
        image_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem((viewPager.getCurrentItem()+1)%imageList.size());
                currentItem = viewPager.getCurrentItem();
            }
        });
        //上一张按钮的点击事件
        image_preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentItem = viewPager.getCurrentItem()-1;
                if(currentItem<0)currentItem+=imageList.size();
                viewPager.setCurrentItem(currentItem);
            }
        });
        //自动播放按钮的点击事件
        image_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加页面更改监听器
                handler.postDelayed(mTicker,CAROUSEL_TIME);
            }
        });
        //停止播放的点击事件
        image_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(mTicker);
            }
        });
    }
    private final Runnable mTicker = new Runnable() {
        @Override
        public void run() {
            long now = SystemClock.uptimeMillis();
            Log.d(TAG, "now:" + now);
//            long next = now + (CAROUSEL_TIME - now % CAROUSEL_TIME);
            //等同于
            long next = now + CAROUSEL_TIME;
            Log.d(TAG, "next: " + next);
            //回调应该运行的绝对时间 3秒后发送消息
            handler.postAtTime(mTicker, next);
            currentItem++;
            currentItem%=imageList.size();
            viewPager.setCurrentItem(currentItem);
        }
    };



}