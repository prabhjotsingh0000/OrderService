package com.example.prabhjot.orderservice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderServiceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    ArrayList<OrderServiceModel> al;
    Context context;
    OrderServiceFragment orderServiceFragment;

    public OrderServiceAdapter(ArrayList<OrderServiceModel> al, Context context, OrderServiceFragment orderServiceFragment) {
        this.al = al;
        this.context = context;
        this.orderServiceFragment=orderServiceFragment;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.os_model_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder mvh = (MyViewHolder) holder;
        mvh.labName.setText(al.get(position).getLabName());
        mvh.provDiag.setEnabled(true);
        mvh.remarks.setEnabled(true);

        String provisionalDiagnosis = mvh.provDiag.getText().toString();
        al.get(position).setProvDiag(provisionalDiagnosis);

        String remarks = mvh.remarks.getText().toString();
        al.get(position).setRemarks(remarks);

    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView labName;
        private TextInputEditText provDiag;
        private TextInputEditText remarks;
        private ImageView heart;
        private Button delete;

        public MyViewHolder(View view) {
            super(view);

            labName = (TextView) view.findViewById(R.id.lab_name);
            provDiag= (TextInputEditText)view.findViewById(R.id.prov_diag);
            remarks= (TextInputEditText)view.findViewById(R.id.remarks);
            heart= (ImageView) view.findViewById(R.id.heart);
            delete= (Button) view.findViewById(R.id.delete);

            heart.setOnClickListener(this);
            delete.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {

            if(v.equals(heart)) {

                boolean isFavourite = al.get(getAdapterPosition()).getIsFavourite();
                if (!isFavourite) {
                    heart.setImageResource(R.drawable.ic_favorite_red_24dp);
                    al.get(getAdapterPosition()).setFavourite(true);
                    Toast toast = Toast.makeText(context, "Service added to favourites successfully", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    heart.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    al.get(getAdapterPosition()).setFavourite(false);
                }

            }

            if(v.equals(delete))
            {
                removeAt(getAdapterPosition());
            }


        }
    }


    public void removeAt(int position) {
        al.remove(position);
        notifyDataSetChanged();

        if(orderServiceFragment instanceof OrderServiceFragment)
        {
            ((OrderServiceFragment)orderServiceFragment).updateCount();
        }
    }
}
