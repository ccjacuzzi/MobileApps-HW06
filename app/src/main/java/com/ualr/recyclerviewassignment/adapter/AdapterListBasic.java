package com.ualr.recyclerviewassignment.adapter;


import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;

import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.ualr.recyclerviewassignment.R;
import com.ualr.recyclerviewassignment.model.Inbox;


import java.util.List;


public class AdapterListBasic extends RecyclerView.Adapter {

    private List<Inbox> mInbox;
    private Context mContext;

    private OnItemClickListener mOnItemClickListner;
    private OnItemClickListener mOnThumbnailClickListner;

    public interface OnItemClickListener{
        void onItemClick(View view, Inbox obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener){
        this.mOnItemClickListner = mItemClickListener;
    }

    public void setOnThumbnailClickListener(OnItemClickListener mThumbnailClickListener){
        this.mOnThumbnailClickListner = mThumbnailClickListener;
    }

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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        InboxViewHolder viewHolder = (InboxViewHolder)holder;
        Inbox i = mInbox.get(position);
        viewHolder.initial.setText(Character.toString(i.getFromInitial()));
        viewHolder.from.setText(i.getFrom());
        viewHolder.date.setText(i.getDate());
        viewHolder.email.setText(i.getEmail());

        if(i.isSelected()){
            viewHolder.lyt_parent.setBackgroundColor(mContext.getResources().getColor(R.color.grey_10));
            viewHolder.initialImage.setImageDrawable(mContext.getDrawable(R.drawable.ic_delete_24px));
            viewHolder.initial.setText("");
        } else {
            viewHolder.lyt_parent.setBackgroundColor(mContext.getResources().getColor(android.R.color.white));
            viewHolder.initialImage.setImageDrawable(mContext.getDrawable(R.drawable.shape_circle));
            viewHolder.initial.setText(Character.toString(i.getFromInitial()));
        }
    }

    public void toggleItemState(int position){
        this.mInbox.get(position).toggleSelection();
        notifyItemChanged(position);
    }

    @Override
    public int getItemCount(){return this.mInbox.size();}

    public class InboxViewHolder extends RecyclerView.ViewHolder{
        public TextView initial;
        public ImageView initialImage;
        public TextView from;
        public TextView date;
        public TextView email;

        public View lyt_parent;



        public InboxViewHolder(View v){
            super(v);
            initial = v.findViewById(R.id.inboxInitial);
            initialImage = v.findViewById(R.id.inboxImage);
            from = v.findViewById(R.id.inboxFrom);
            date = v.findViewById(R.id.inboxDate);
            email = v.findViewById(R.id.inboxEmail);
            lyt_parent = v.findViewById(R.id.lyt_parent);

            lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*This is the stuff that happens when the parent layout is clicked.*/
                    mOnItemClickListner.onItemClick(view, mInbox.get(getLayoutPosition()),getLayoutPosition());
                }
            });

            initialImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnThumbnailClickListner.onItemClick(view, mInbox.get(getLayoutPosition()),getLayoutPosition());
                }
            });
        }
    }

    public void deleteInboxItem(int position){
        mInbox.remove(position);
        notifyItemRemoved(position);
        notifyItemChanged(position,getItemCount());
    }

    public void addInboxItem(int position, Inbox inboxItem){
        mInbox.add(position, inboxItem);
        notifyItemInserted(position);
    }
}
