package com.example.classroomprojectv14.HomePages;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.classroomprojectv14.WebAPIClasses.Announcements;
import com.example.classroomprojectv14.R;

import java.util.Collections;
import java.util.List;

public class Recycler_View_Adapter extends RecyclerView.Adapter<View_Holder>
{
    List<Announcements> list = Collections.emptyList();
  //  List<Announcements> announcements = Collections.emptyList();
    Context context;

    public Recycler_View_Adapter(List<Announcements> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_row_layout, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;

    }


    @Override
    public void onBindViewHolder(View_Holder holder, int position) {
        Context context = holder.cv.getContext();

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText(list.get(position).Title);
        holder.description.setText(list.get(position).EntireContent);
        holder.datetime.setText(list.get(position).Date);

        //animate(holder);

    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Announcements data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specifiedData object
    public void remove(Announcements data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }
}
