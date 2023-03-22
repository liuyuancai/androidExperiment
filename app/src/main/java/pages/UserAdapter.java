package pages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.bumptech.glide.Glide;


import java.util.List;

import po.User;

public class UserAdapter extends ArrayAdapter<User> {
    private List<User> userList;
    public UserAdapter(@NonNull Context context, int resource, @NonNull List<User> userList) {
        super(context, resource, userList);
        this.userList = userList;
    }
    public void addView(User user){
        this.userList.add(user);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent){
        User user = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.user_itme,parent,false);
        ImageView userImage = view.findViewById(R.id.userImage);
        TextView userTitle = view.findViewById(R.id.user_title);
        TextView userMessage = view.findViewById(R.id.user_message);
        Glide.with(getContext()).load(user.getUrl()).disallowHardwareConfig().into(userImage);
        userTitle.setText(user.getName());
        userMessage.setText(user.getMessage());
        return view;
    }
}
