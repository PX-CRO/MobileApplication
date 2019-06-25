package com.example.classroomprojectv14.WebAPIClasses;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.classroomprojectv14.HomePages.Recycler_View_Adapter;
import com.example.classroomprojectv14.WebAPIClasses.Announcements;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VolleyService {
    Context mContext;

   public VolleyService(Context context){
        mContext = context;
    }


    public void CallRestEvent(String URL, final List<Announcements> list, final RecyclerView recyclerView ) {



        RequestQueue requestQueue = Volley.newRequestQueue(mContext);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray responseArray) {

                        try {
                            for (int i = 0; i < responseArray.length(); i++) {
                                JSONObject response = responseArray.getJSONObject(i);
                                String Id = response.getString("Id");
                                String Date = response.getString("Date");
                                String Title = response.getString("Title");
                                String EntireContent = response.getString("EntireContent");
                                list.add(new Announcements(Id, Date,Title,EntireContent));
                               // Log.e("LİSTE", list.get(0).EntireContent);

                            }

                            Collections.sort(list, new Comparator<Announcements>() {
                                @Override
                                public int compare(Announcements o1, Announcements o2) {
                                    return o2.Id.compareTo(o1.Id);
                                }
                            });
                            //txtMain.setText("ID : "+list.get(0).Id+"\n Date: "+list.get(0).Date+ "\n Title: "+list.get(0).Title+"\n EntireContent: " + list.get(0).EntireContent);
                            Recycler_View_Adapter rec = new Recycler_View_Adapter(list, mContext);
                            LinearLayoutManager llm = new LinearLayoutManager(mContext);
                            recyclerView.setAdapter(rec);
                            recyclerView.setLayoutManager(llm);


                        } catch (JSONException e) {
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
