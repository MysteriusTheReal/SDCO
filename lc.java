package com.example.sdco;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class lc extends AppCompatActivity {
    // clase nodo
    static class Nodo {
        public int dato;
        public Nodo siguiente;
        public Nodo anterior;

        public Nodo(int valor) {
            dato = valor;
            siguiente = null;
            anterior = null;
        }
    }

    private Nodo inicio = null;
    private Nodo ultimo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lc);

        // encuentra vistas por su id en el layout
        final EditText ed3 = findViewById(R.id.ed3);
        final Button bt4 = findViewById(R.id.bt4);

        // cuando se da click al botón encontrado en el layout "bt4"
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // convierte el valor de int a string
                int valor = Integer.parseInt(ed3.getText().toString());
                // se crea nuevo nodo con el valor escrito en el edit text
                Nodo nuevoNodo = new Nodo(valor);
                if (inicio == null) {
                    inicio = nuevoNodo;
                    ultimo = nuevoNodo;
                    // Hacer la lista circular
                    ultimo.siguiente = inicio;
                    inicio.anterior = ultimo;
                } else {
                    nuevoNodo.anterior = ultimo;
                    ultimo.siguiente = nuevoNodo;
                    ultimo = nuevoNodo;
                    // Hacer la lista circular
                    ultimo.siguiente = inicio;
                    inicio.anterior = ultimo;
                }
                ed3.setText("");
                // llamando al metodo actualizar salida
                actualizarSalida();
            }
        });
    }

    // metodo actualizar salida
    private void actualizarSalida() {
        StringBuilder resultado = new StringBuilder();
        Nodo imp = inicio;

        do {
            resultado.append(imp.dato).append("\n");
            imp = imp.siguiente;
        } while (imp != inicio);

        // Encuentra los TextView en el layout
        final TextView tvAnterior = findViewById(R.id.tvAnterior);
        final TextView tvActual = findViewById(R.id.tvActual);
        final TextView tvSiguiente = findViewById(R.id.tvSiguiente);

        // el resultado a cadena en tvAnterior
        tvAnterior.setText(resultado.toString());

        //  nodo anterior y el nodo actual a tvActual y tvSiguiente
        if (ultimo != null) {
            tvActual.setText("Nodo Actual:\n" + ultimo.dato);

            // caso en el que el nodo anterior es null
            if (ultimo.anterior != null) {
                tvSiguiente.setText("Nodo Anterior:\n" + ultimo.anterior.dato);
            } else {
                tvSiguiente.setText("Nodo Anterior:\nnull");
            }
        } else {
            // caso en el que el último nodo es null
            tvActual.setText("Nodo Actual:\nnull");
            tvSiguiente.setText("Nodo Anterior:\nnull");
        }
    }
}
