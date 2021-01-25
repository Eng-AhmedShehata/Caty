package com.ashehata.caty.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ashehata.caty.R;
import com.bumptech.glide.Glide;

public class UserViewHolder extends RecyclerView.ViewHolder {

    private UserAdapter.OnUserClicked onUserClicked;
    private TextView title;
    private TextView des;
    private ImageView image;
    private LinearLayout parent;

    public UserViewHolder(@NonNull View itemView, UserAdapter.OnUserClicked onUserClicked) {
        super(itemView);
        parent = itemView.findViewById(R.id.parent_linear);
        title = itemView.findViewById(R.id.tv_title);
        des = itemView.findViewById(R.id.tv_des);
        image = itemView.findViewById(R.id.iv_image);
        this.onUserClicked = onUserClicked;
    }

    public void bindData(User user) {
        //...
        title.setText(user.getTitle());
        des.setText(user.getDescription());
        // load my image
        Glide.with(image.getContext())
                .load(user.getImageUrl())
                .centerCrop().into(image);

        //...
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUserClicked.onUserSingleClicked(user);
            }
        });
    }
}
