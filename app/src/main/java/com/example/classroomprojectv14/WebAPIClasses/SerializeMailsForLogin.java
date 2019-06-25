package com.example.classroomprojectv14.WebAPIClasses;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.classroomprojectv14.FirstActivity;
import com.example.classroomprojectv14.WebAPIClasses.LoginInfos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SerializeMailsForLogin {
    Context mContext;



   public SerializeMailsForLogin
         (
           Context context
         )
    {
        mContext = context;
    }


    public void CallRestEvent(String URL, final TextView mail, final TextView password) {
        final List<LoginInfos> list = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray responseArray) {

                        try
                        {
                            for (int i = 0; i < responseArray.length(); i++)
                            {
                                JSONObject response = responseArray.getJSONObject(i);
                                String Name = response.getString("FName");
                                String LastName = response.getString("LName");
                                String eMail = response.getString("eMail");
                                String Password = response.getString("Password");
                                list.add(new LoginInfos(eMail,Password,Name,LastName));



                            }

                            for (int i = 0; i < responseArray.length(); i++) {
                                if (mail.getText().toString().equals(list.get(i).eMail) && password.getText().toString().equals(list.get(i).Password)) {
                                    Intent intent = new Intent(mContext, FirstActivity.class);
                                    intent.putExtra("name", list.get(i).Name);
                                    intent.putExtra("surname", list.get(i).LastName);
                                    mContext.startActivity(intent);
                                    Toast.makeText(mContext, "Hoşgeldiniz " + list.get(i).Name + " " +list.get(i).LastName, Toast.LENGTH_SHORT).show();
                                    i= responseArray.length();
                                }
                                else {
                                    if(i == responseArray.length()) {
                                        Toast.makeText(mContext, "Yanlış Kullanıcı Adı veya Şifre", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                           // Log.e("EMAİL BİLGİSİ", list.get(i).eMail);
                           // Log.e("ŞİFRE BİLGİSİ", list.get(i).Password);
                            // list.add(Password);

                            //txtMain.setText("ID : "+list.get(0).Id+"\n Date: "+list.get(0).Date+ "\n Title: "+list.get(0).Title+"\n EntireContent: " + list.get(0).EntireContent);


                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("HATA: ", error.getMessage());
            }
        }
        );

        requestQueue.add(jsonArrayRequest);
    }
}
