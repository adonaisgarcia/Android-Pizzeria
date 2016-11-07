package com.example.adonaisgn.pizzeria;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.adonaisgn.pizzeria.modelo.negocio.GestorPedido;

public class ConfirmacionActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
    }

    public void aceptar(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public  void cancelar(View v){
        GestorPedido gp = new GestorPedido(context);
        gp.limpiarPedidos();
        Toast.makeText(ConfirmacionActivity.this, "Pedido cancelado", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
