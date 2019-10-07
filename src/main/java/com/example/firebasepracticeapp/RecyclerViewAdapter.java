package com.example.firebasepracticeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RV_ViewHolder> {

    private Context context;
    private List<User> user;

    public RecyclerViewAdapter(Context context, List<User> user) {
        this.context = context;
        this.user = user;
    }

    @NonNull
    @Override
    public RV_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_items_layout,parent,false);
        return new RV_ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RV_ViewHolder holder, int position) {

        User user = this.user.get(position);

        holder.nameTV.setText(user.toString());
        holder.emailAddressTV.setText(user.emailAddress);
        holder.jobTitleTV.setText(user.jobTitleName);
        holder.phoneTV.setText(user.phoneNumber);
        Picasso.get().load(user.preferredFullName).into(holder.profileImageView);

    }

    @Override
    public int getItemCount() {
        return user.size();
    }


    // View Holder Class

    public class RV_ViewHolder extends RecyclerView.ViewHolder{

        ImageView profileImageView;
        TextView nameTV, emailAddressTV, jobTitleTV, phoneTV;

        public RV_ViewHolder(@NonNull View itemView) {
            super(itemView);

            profileImageView = itemView.findViewById(R.id.profileImageView);
            nameTV = (TextView) itemView.findViewById(R.id.nameTV);
            emailAddressTV = itemView.findViewById(R.id.emailAddressTV);
            jobTitleTV = itemView.findViewById(R.id.jobTitleTV);
            phoneTV = (TextView) itemView.findViewById(R.id.phoneTV);


        }
    }

}
