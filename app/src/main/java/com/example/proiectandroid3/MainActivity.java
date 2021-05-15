package com.example.proiectandroid3;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private ListView lv;
    List<Curs> cursuri = new ArrayList<Curs>();
    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        lv = (ListView) findViewById(R.id.list);


        new GetContacts().execute();
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://api.npoint.io/d84b2567aff8963db2e2";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node

                    JSONArray categorii_2=jsonObj.getJSONArray("categorii");
                    // looping through All Contacts
                    for (int i = 0; i < categorii_2.length(); i++) {
                        JSONObject c = categorii_2.getJSONObject(i);

                        String titlu = c.getString("categorie");
                        String continut = c.getString("continut");
                        String poza = c.getString("poza");
                        int x = getResources().getIdentifier(poza, "drawable",getPackageName());
                        cursuri.add(new Curs(titlu,continut,x));
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            CategorieAdapter adapter = new CategorieAdapter(cursuri, getApplicationContext());


            lv.setAdapter(adapter);


            lv.setOnItemClickListener( new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Curs c1=cursuri.get(position);
                    Intent it = new Intent(MainActivity.this, PaginaCurs.class);

                    Toast.makeText(MainActivity.this,c1.getNume_curs() , Toast.LENGTH_SHORT).show();
                    it.putExtra("titlu",c1.getNume_curs());
                    it.putExtra("continut",c1.getContinut_curs());
                    it.putExtra("poza",c1.getImagine_curs());
                    startActivity(it);
                }
            });
        }

    }
}