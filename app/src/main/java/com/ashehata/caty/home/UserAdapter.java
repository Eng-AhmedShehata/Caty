package com.ashehata.caty.home;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ashehata.caty.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private OnUserClicked onUserClicked;

    //1. define interface
    public interface OnUserClicked {
        void onUserSingleClicked(User user);
        void onUserLongClicked(User user);
        //.....
    }

    //3.
//    public void registerView(OnUserClicked onUserClicked) {
//        this.onUserClicked = onUserClicked;
//    }

    private List<User> users;
    private Activity activity;

    public UserAdapter(List<User> users, OnUserClicked onUserClicked) {
        this.users = users;
        this.onUserClicked = onUserClicked;
        //this.activity = activity;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View myView = inflater.inflate(R.layout.root_user, parent, false);
        return new UserViewHolder(myView, onUserClicked);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.bindData(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}


