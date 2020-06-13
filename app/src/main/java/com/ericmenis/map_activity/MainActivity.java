package com.ericmenis.map_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   //Boton principal
    @BindView(R.id.buttonConfirm)
    ImageButton btnSearch;
    //Boton buscar
    @BindView(R.id.buttonToSecondActivity)
    Button buttonAceptar;
    //EditText LATITUD y LONGITUD
    @BindView(R.id.editTextLAT)
    EditText editTextLAT;
    @BindView(R.id.editTextLON)
    EditText editTextLON;
    //Titulo LATITUD y LONGITUD
    @BindView(R.id.titleLAT)
    TextView textViewLAT;
    @BindView(R.id.titleLON)
    TextView textViewLON;

    private Double latitud, longitud;
    private String lat, lon;
    
    @OnClick(R.id.buttonConfirm)
    void onClicked(){
        textViewLAT.setVisibility(View.VISIBLE);
        textViewLON.setVisibility(View.VISIBLE);
        editTextLAT.setVisibility(View.VISIBLE);
        editTextLON.setVisibility(View.VISIBLE);
        buttonAceptar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Forzar el Logo
        getSupportActionBar().setLogo(R.mipmap.ic_app);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

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
}

