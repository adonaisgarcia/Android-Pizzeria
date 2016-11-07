package com.example.adonaisgn.pizzeria.modelo.negocio;

import android.content.Context;

import com.example.adonaisgn.pizzeria.modelo.entidad.Pedido;
import com.example.adonaisgn.pizzeria.modelo.persistencia.AlmacenPedidos;

/**
 * Created by Adonais.gn on 06/11/2016.
 */

public class GestorPedido {
    //Introducimos la logica del negocio, el pedido

    Context context;

    public GestorPedido (Context context){
        this.context = context;
    }

    //en este caso gestionamos precio por pizza e ingrediente
    public Pedido calcularPrecio (Pedido pedido){
        double precioBase = 0;
        if (pedido.getTamaño().equals("Personal")){
            precioBase =5;
        } else if(pedido.getTamaño().equals("Mediano")) {
            precioBase = 10;
        }else{
            precioBase =15;
        }
        double precioIngredientes = pedido.getListaIngredientes().size();
        double precioTotal = precioBase +precioIngredientes;
        pedido.setPrecio(precioTotal);
        return pedido;
    }
    public void  guardarPedido( Pedido pedido){
        //no queremos meterle logica de negocio, lo hacemos void
        AlmacenPedidos ap = new AlmacenPedidos(context);
        ap.guardarPedidos(pedido);

    }

    public void limpiarPedidos(){
        AlmacenPedidos ap = new AlmacenPedidos(context);
        ap.borrarPedido();
    }


}