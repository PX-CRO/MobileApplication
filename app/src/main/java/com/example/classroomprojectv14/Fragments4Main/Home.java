package com.example.classroomprojectv14.Fragments4Main;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.classroomprojectv14.R;
import com.example.classroomprojectv14.WebAPIClasses.Announcements;
import com.example.classroomprojectv14.WebAPIClasses.VolleyService;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment
{

    VolleyService vs;

    private RecyclerView recyclerView;
    Context ctx;



    public static Home newInstance()
    {
        return new Home();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        ctx = getContext();
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_main_home, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {

         List<Announcements> myList = new ArrayList<>();
        String URL = "http://10.34.44.176:55281/api/Announcements";


        super.onViewCreated(view, savedInstanceState);
       // context = getContext();
        vs = new VolleyService(getActivity().getApplicationContext());


        recyclerView = view.findViewById(R.id.myRecyclerView);

       // Recycler_View_Adapter adapter = new Recycler_View_Adapter(myList, getActivity().getApplication());
       // recyclerView.setAdapter(adapter);
       //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        vs.CallRestEvent(URL,myList,recyclerView);

    }



}


