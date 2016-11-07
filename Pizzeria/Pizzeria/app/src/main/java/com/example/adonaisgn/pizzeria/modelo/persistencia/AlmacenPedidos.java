package com.example.adonaisgn.pizzeria.modelo.persistencia;

import android.content.Context;
import android.util.Log;

import com.example.adonaisgn.pizzeria.modelo.entidad.Pedido;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Adonais.gn on 06/11/2016.
 */

public class AlmacenPedidos {
    Context context;
    //creamos variable con el fichero para no equivocarnos al usarlo
    private static final String FICHERO = "pedidos.txt";

    public AlmacenPedidos (Context context){
        this.context = context;
    }

    public void guardarPedidos (Pedido pedido){
        FileOutputStream fos = null;
        PrintStream out = null;

        try{
            fos =context.openFileOutput(FICHERO,Context.MODE_APPEND);
            out = new PrintStream(fos);
            out.println(pedido.toFichero()); //asi llamamos al metodo en usuario para guardarlo como queremos
            out.flush();
        }catch (Exception e){
            Log.e("AlmacenPedidos","Error al abrir el fichero");
        }finally {
            if(out!=null){
                out.close();
            }
        }
    }

    public void borrarPedido(){
        FileOutputStream fos = null;
        try { //al ser modo privado resetea
            context.openFileOutput(FICHERO,Context.MODE_PRIVATE);
        }catch (Exception e){
            //siempre nos obliga a poner una excepción por si no se puede
            Log.e("AlmacenPedido","Error al borrar el pedido");
        }
    }
}

