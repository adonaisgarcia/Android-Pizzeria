package com.example.adonaisgn.pizzeria;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adonaisgn.pizzeria.modelo.entidad.Pedido;
import com.example.adonaisgn.pizzeria.modelo.negocio.GestorPedido;

public class ResumenActivity  extends AppCompatActivity {
    Context context;
    ListView lvIngredientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        Intent intent = getIntent();
        Pedido pedido = (Pedido)intent.getSerializableExtra("pedido");

        TextView tvNombre = (TextView)findViewById(R.id.tvNombre);
        String nom = pedido.getNombre().toString();
        tvNombre.setText(nom);

        TextView tvTelefono = (TextView)findViewById(R.id.tvTelefono);
        String tel = pedido.getTelefono().toString();
        tvTelefono.setText(tel);

        TextView tvDireccion = (TextView)findViewById(R.id.tvDireccion);
        String dir = pedido.getDireccion().toString();
        tvDireccion.setText(dir);

        TextView tvTamaño = (TextView)findViewById(R.id.tvTamaño);
        String tam = pedido.getTamaño().toString();
        tvTamaño.setText(tam);

        TextView tvPrecio = (TextView)findViewById(R.id.tvPrecio);
        String pre = String.valueOf(pedido.getPrecio());
        tvPrecio.setText(pre);

        lvIngredientes = (ListView)findViewById(R.id.lvIngredientes);
        ArrayAdapter<String> adaptadorIngredientes = new ArrayAdapter<String>
                (this,android.R.layout.simple_expandable_list_item_1,pedido.getListaIngredientes());
        lvIngredientes.setAdapter(adaptadorIngredientes);

    }
    public void confirmar(View v){
        GestorPedido gp = new GestorPedido(context);

        Intent intent = getIntent();
        Pedido pedido = (Pedido)intent.getSerializableExtra("pedido");
        gp.guardarPedido(pedido);
        Toast.makeText(ResumenActivity.this,"Pedido Guardado",Toast.LENGTH_SHORT).show();
        finish();

        Intent intent2 = new Intent(this, ConfirmacionActivity.class);
        startActivity(intent2);
    }

    public void modificar (View v){
        finish();
    }

}


