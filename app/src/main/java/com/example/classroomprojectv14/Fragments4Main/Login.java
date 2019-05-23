package com.example.classroomprojectv14.Fragments4Main;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.classroomprojectv14.FirstActivity;
import com.example.classroomprojectv14.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment
{
    private TextView text_mail;
    private TextView text_pass;
    private Button button_login;




    public static Login newInstance()
    {
        return new Login();
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
        return inflater.inflate(R.layout.activity_main_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        text_mail = (TextView)view.findViewById(R.id.login_txt_Mail);
        text_pass = (TextView)view.findViewById(R.id.login_txt_Password);
        button_login = (Button) view.findViewById(R.id.login_button);
        
        myOperations();
    }

    private void myOperations()
    {
        button_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(text_mail.getText().toString().equals("huseynbicen@gmail.com") && text_pass.getText().toString().equals("Hb.123"))
                {
                    Intent intent = new Intent(getActivity(), FirstActivity.class);
                    intent.putExtra("Text", text_mail.getText().toString());
                    startActivity(intent);
                }
                else
                {
                    text_pass.setText("");
                    text_mail.setText("");
                }

                Intent intent = new Intent(getActivity(), FirstActivity.class);
                intent.putExtra("Text", text_mail.getText().toString());
                startActivity(intent);
            }
        });
    }
}
