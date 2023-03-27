package com.ualr.recyclerviewassignment.adapter;


import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.ualr.recyclerviewassignment.R;
import com.ualr.recyclerviewassignment.model.Inbox;


import java.util.List;


public class AdapterListBasic extends RecyclerView.Adapter {

    private List<Inbox> mInbox;
    private Context mContext;

    public AdapterListBasic(Context context, List<Inbox> inbox){
        this.mInbox = inbox;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        RecyclerView.ViewHolder vh;
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inbox_item,parent,false);
        vh = new InboxViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        InboxViewHolder viewHolder = (InboxViewHolder)holder;
        Inbox i = mInbox.get(position);
        viewHolder.from.setText(i.getFrom());
        viewHolder.date.setText(i.getDate());
        viewHolder.email.setText(i.getEmail());
    }

    @Override
    public int getItemCount(){return this.mInbox.size();}

    public class InboxViewHolder extends RecyclerView.ViewHolder{
        public TextView from;
        public TextView date;
        public TextView email;
        public View lyt_parent;


        public InboxViewHolder(View v){
            super(v);
            from = v.findViewById(R.id.inboxFrom);
            date = v.findViewById(R.id.inboxDate);
            email = v.findViewById(R.id.inboxEmail);
            lyt_parent = v.findViewById(R.id.lyt_parent);
        }
    }
}
