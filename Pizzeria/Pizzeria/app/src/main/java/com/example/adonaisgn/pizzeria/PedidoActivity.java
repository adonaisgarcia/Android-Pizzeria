package com.example.adonaisgn.pizzeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.adonaisgn.pizzeria.modelo.entidad.Pedido;
import com.example.adonaisgn.pizzeria.modelo.negocio.GestorPedido;

import java.util.ArrayList;

public class PedidoActivity extends AppCompatActivity {

    RadioGroup rgTamaños;
    CheckBox cbMarcadoBacon, cbMarcadoPiña, cbMarcadoChampiñones, cbMarcadoMaiz;
    EditText etNombre, etDireccion, etTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        rgTamaños = (RadioGroup)findViewById(R.id.rgEleccion);
        cbMarcadoBacon = (CheckBox)findViewById(R.id.cbBacon);
        cbMarcadoPiña = (CheckBox)findViewById(R.id.cbPiña);
        cbMarcadoChampiñones = (CheckBox)findViewById(R.id.cbChampiñones);
        cbMarcadoMaiz = (CheckBox)findViewById(R.id.cbMaiz);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etDireccion = (EditText) findViewById(R.id.etDireccion);

        cbMarcadoBacon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                CheckBox checkBox = (CheckBox)v;
                String ingrediente = "";
                boolean estaMarcado = checkBox.isChecked();
                if(estaMarcado){
                    ingrediente = "Marcado";
                }else{
                    ingrediente = "Desmarcado";
                }
                Toast.makeText(PedidoActivity.this,ingrediente,Toast.LENGTH_SHORT).show();
            }
        });

        cbMarcadoPiña.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                CheckBox checkBox = (CheckBox)v;
                boolean estaMarcado = checkBox.isChecked();
                String ingrediente = "";
                if(estaMarcado){
                    ingrediente = "Marcado";
                }else{
                    ingrediente = "Desmarcado";
                }
                Toast.makeText(PedidoActivity.this,ingrediente,Toast.LENGTH_SHORT).show();
            }
        });

        cbMarcadoChampiñones.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                CheckBox checkBox = (CheckBox)v;
                boolean estaMarcado = checkBox.isChecked();
                String ingrediente = "";
                if(estaMarcado){
                    ingrediente = "Marcado";
                }else{
                    ingrediente = "Desmarcado";
                }
                Toast.makeText(PedidoActivity.this,ingrediente,Toast.LENGTH_SHORT).show();
            }
        });

        cbMarcadoMaiz.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                CheckBox checkBox = (CheckBox)v;
                boolean estaMarcado = checkBox.isChecked();
                String ingrediente = "";
                if(estaMarcado){
                    ingrediente = "Marcado";
                }else{
                    ingrediente = "Desmarcado";
                }
                Toast.makeText(PedidoActivity.this,ingrediente,Toast.LENGTH_SHORT).show();
            }
        });

        rgTamaños.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            //RadioGroup, radiogroup que desencadena la accion
            //checkedId, el id el radiobutton seleccionado
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String tamaño = "";
                RadioButton rb = (RadioButton)findViewById(checkedId);
                tamaño = rb.getText().toString();
                Toast.makeText(PedidoActivity.this, tamaño, Toast.LENGTH_SHORT).show();
            }
        });
    }


    //View v es el elemento que produce el evento
    public void hacerPedido (View v){
        //Recogemos los valores del pedido

        //tomamos los datos del pedido
        int iBotonSeleccionado = rgTamaños.getCheckedRadioButtonId();
        RadioButton radioButtonSeleccionado = (RadioButton)findViewById(iBotonSeleccionado);
        String tamaño = radioButtonSeleccionado.getText().toString();

        ArrayList<String> listaIngredientes = recogerIngredientes();
        //metemos en el array los checkbox chequeados

        String nombre = etNombre.getText().toString();
        String direccion = etDireccion.getText().toString();
        String telefono = etTelefono.getText().toString();

        //hacemos el pedido
        Pedido pedido = new Pedido();
        pedido.setNombre(nombre);
        pedido.setDireccion(direccion);
        pedido.setTelefono(telefono);
        pedido.setListaIngredientes(listaIngredientes);
        pedido.setTamaño(tamaño);

        //para el precio me ayudo de negocio
        GestorPedido gestorPedido = new GestorPedido(this);
        pedido = gestorPedido.calcularPrecio(pedido);

        //ahora vamos a la otra actividad, para ello necesitamos intent
        //con el intent le pasamos toda la info

        Intent intent = new Intent (this,ResumenActivity.class);
        intent.putExtra("pedido", pedido);
        startActivity(intent);

    }

    private ArrayList<String> recogerIngredientes(){
        ArrayList<String> listaIngredientes = new ArrayList<>();
        if(cbMarcadoBacon.isChecked()){
            listaIngredientes.add(cbMarcadoBacon.getText().toString());
        }
        if(cbMarcadoPiña.isChecked()){
            listaIngredientes.add(cbMarcadoPiña.getText().toString());
        }
        if(cbMarcadoChampiñones.isChecked()){
            listaIngredientes.add(cbMarcadoChampiñones.getText().toString());
        }
        if(cbMarcadoMaiz.isChecked()){
            listaIngredientes.add(cbMarcadoMaiz.getText().toString());
        }
        return listaIngredientes;
    }
}
