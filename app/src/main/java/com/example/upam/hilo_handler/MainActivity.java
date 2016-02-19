package com.example.upam.hilo_handler;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Handler mhandler=new Handler();
    TextView etiqueta;
    boolean bandera=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etiqueta=(TextView) findViewById(R.id.textView2);
        String mensaje=etiqueta.getText().toString();
        etiqueta.setText(mensaje+" Software");


    }

    public void handler_click(View v)
    {
      miHijo();
    }

    protected void miHijo()
    {
        Thread t=new Thread(){
            public void run(){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                mhandler.post(ejecutar_accion);
            }
        }; t.start();
    }

    final Runnable ejecutar_accion=new Runnable() {
        @Override
        public void run() {
            //Toast.makeText(MainActivity.this,"Accion"+getTaskId(),Toast.LENGTH_SHORT).show();
        if(bandera)
        { bandera=false;
            //cambiar Color a anaranjado
            etiqueta.setTextColor(Color.rgb(239,134,14));
        }else{//color gris
            bandera=true;
            etiqueta.setTextColor(Color.rgb(132,118,103));

        }


        }
    };





}
