package com.example.classroomprojectv14;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.classroomprojectv14.Fragments4Main.Contact;
import com.example.classroomprojectv14.Fragments4Main.Home;
import com.example.classroomprojectv14.Fragments4Main.Login;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    Home fragmentHome;
    Login fragmentLogin;
    Contact fragmentContact;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation_view);

        fragmentHome = new Home();
        fragmentLogin = new Login();
        fragmentContact = new Contact();

        combiarFragment(Home.newInstance());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch(menuItem.getItemId())
                {
                    case R.id.menu_Home:
                        combiarFragment(Home.newInstance());
                        return true;
                    case R.id.menu_Login:
                        combiarFragment(Login.newInstance());
                        return true;
                    case R.id.menu_Contact:
                        combiarFragment(Contact.newInstance());
                        return true;

                }
                return  false;
            }
        });
    }

    private void combiarFragment(Fragment fr)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
        transaction.replace(R.id.frameLayout4Fragments, fr);
        transaction.commit();
    }
}
