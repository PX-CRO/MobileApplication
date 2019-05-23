package com.example.classroomprojectv14.HomePages;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.classroomprojectv14.R;

public class View_Holder extends RecyclerView.ViewHolder
{
    CardView cv;
    TextView title;
    TextView description;
    TextView datetime;

    View_Holder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.row_layout_cardView);
        title = (TextView) itemView.findViewById(R.id.row_layout_title);
        description = (TextView) itemView.findViewById(R.id.row_layout_description);
        datetime = (TextView) itemView.findViewById(R.id.row_layout_date);
    }
}
