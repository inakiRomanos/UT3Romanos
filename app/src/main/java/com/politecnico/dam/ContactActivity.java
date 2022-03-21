package com.politecnico.dam;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


@SuppressWarnings("CanBeFinal")
public class ContactActivity extends AppCompatActivity {

    ArrayList<String> nombre = new ArrayList<>();
    ArrayList<String> direccion = new ArrayList<>();
    ArrayList<String> localidad = new ArrayList<>();
    ArrayList<String> telefono = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        // get the reference of RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            // fetch JSONArray named users
            JSONArray itemArray = obj.getJSONArray("ITEMS");
            for (int i = 0; i < itemArray.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject itemDetail = itemArray.getJSONObject(i);
                // fetch email and name and store it in arraylist
                nombre.add(itemDetail.getString("NOMBRE"));
                direccion.add(itemDetail.getString("DIRECCIÓN "));
                localidad.add(itemDetail.getString("LOCALIDAD"));
                telefono.add(itemDetail.getString("TELÉFONO"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(ContactActivity.this, nombre, direccion, localidad, telefono);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("CentrosSanitarios.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
