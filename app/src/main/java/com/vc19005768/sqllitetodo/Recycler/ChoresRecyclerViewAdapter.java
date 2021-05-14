package com.vc19005768.sqllitetodo.Recycler;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.vc19005768.sqllitetodo.ChoreModel;
import com.vc19005768.sqllitetodo.R;

import java.util.ArrayList;
import java.util.List;


public class ChoresRecyclerViewAdapter extends RecyclerView.Adapter<ChoresRecyclerViewAdapter.ViewHolder> {

    private List<ChoreModel> mValues = new ArrayList<>();



    public ChoresRecyclerViewAdapter(List<ChoreModel> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder vholder, int position) { // parameters of Viewholder class defined bottom of page
        ChoreModel item = mValues.get(position);
        vholder.mItem = item;
        vholder.llblcIDItem.setText(item.getcID()+ "");
        vholder.llblcNameItem.setText(item.getChore());
        vholder.llblcTimeItem.setText(item.getTime());

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    } //gets amount of chores

    ////////////////////////////////////////////////////////////////////////////////////////
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public ChoreModel mItem;
        public TextView llblcIDItem;
        public TextView llblcNameItem;
        public TextView llblcTimeItem;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            llblcIDItem = (TextView) view.findViewById(R.id.lblcIDItem);
            llblcNameItem = (TextView) view.findViewById(R.id.lblcNameItem);
            llblcTimeItem = (TextView) view.findViewById(R.id.lblcTimeItem);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + "Bob" + "'";
        }
    }
    /////////////////////////////////////
}