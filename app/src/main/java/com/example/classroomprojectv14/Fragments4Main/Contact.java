package com.example.classroomprojectv14.Fragments4Main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.classroomprojectv14.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Contact extends Fragment
{




    public static Contact newInstance()
    {
        return new Contact();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_main_contact, container, false);
    }

}
