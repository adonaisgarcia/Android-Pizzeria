package com.example.adonaisgn.pizzeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pedido(View v){
        Intent intent = new Intent(this,PedidoActivity.class);
        startActivity(intent);
    }

    public void instrucciones(View v){
        Intent intent = new Intent(this,InstruccionesActivity.class);
        startActivity(intent);
    }
}
