package com.ericmenis.map_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnSearch;

    private EditText editTextLAT, editTextLON;
    private TextView textViewLAT, textViewLON;

    private Button buttonAceptar;

    private Double latitud, longitud;
    private String lat, lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Forzar el Logo
        getSupportActionBar().setLogo(R.mipmap.ic_app);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnSearch = (ImageButton) findViewById(R.id.buttonConfirm);

        buttonAceptar = (Button) findViewById(R.id.buttonToSecondActivity);

        editTextLAT = (EditText) findViewById(R.id.editTextLAT);
        editTextLON = (EditText) findViewById(R.id.editTextLON);

        textViewLAT = (TextView) findViewById(R.id.titleLAT);
        textViewLON = (TextView) findViewById(R.id.titleLON);

        btnSearch.setOnClickListener(this);

        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lat = editTextLAT.getText().toString();
                latitud = Double.parseDouble(lat);

                lon = editTextLON.getText().toString();
                longitud = Double.parseDouble(lon);

                if (longitud != null && latitud != null) {
                    Intent i = new Intent(MainActivity.this, MapsActivity.class);
                    i.putExtra("latitud", latitud);
                    i.putExtra("longitud", longitud);
                    startActivity(i);
                }else {
                    Toast.makeText(MainActivity.this, "The number is mandatory, please type it", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public void onClick(View v) {
        textViewLAT.setVisibility(View.VISIBLE);
        textViewLON.setVisibility(View.VISIBLE);
        editTextLAT.setVisibility(View.VISIBLE);
        editTextLON.setVisibility(View.VISIBLE);
        buttonAceptar.setVisibility(View.VISIBLE);
    }
}

