package pages;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import po.Image;

public class PagesAdapter extends PagerAdapter {
    private List<Image> imageList;
    private Context context;
    private static final String TAG = "PagesAdapter";

    public PagesAdapter(List<Image> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }



    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        position %= imageList.size();
        ImageView imageView = new ImageView(context);


        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setTag(position);
        imageView.setImageResource(imageList.get(position).getImg());
        container.addView(imageView);
//        Log.d("tag","image"+imageList.get(position).getImg());
        return imageView;
    }
}
