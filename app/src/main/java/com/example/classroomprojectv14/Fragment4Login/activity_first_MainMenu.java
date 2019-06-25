package com.example.classroomprojectv14.Fragment4Login;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.classroomprojectv14.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class activity_first_MainMenu extends Fragment {
    public  TextView txtName;
    public  TextView txtClass;
    public TextView txtGroup;


    public activity_first_MainMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity_first__main_menu, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtName = view.findViewById(R.id.FragmentLoginName);
        txtClass = view.findViewById(R.id.FragmentLoginClass);
        txtGroup = view.findViewById(R.id.FragmentLoginGroup);
    }
}
