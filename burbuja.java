package com.example.sdco;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class burbuja extends AppCompatActivity {

    private List<Integer> lista;
    private TextView textViewResultado;
    private EditText editTextValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burbuja);

        lista = new ArrayList<>();
        textViewResultado = findViewById(R.id.textViewResultado);
        editTextValor = findViewById(R.id.editTextValor);

        Button buttonAgregar = findViewById(R.id.buttonAgregar);
        Button buttonOrdenar = findViewById(R.id.buttonOrdenar);

        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarValor();
            }
        });

        buttonOrdenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ordenarLista();
            }
        });
    }

    private void agregarValor() {
        String valorStr = editTextValor.getText().toString();

        if (!valorStr.isEmpty()) {
            int valor = Integer.parseInt(valorStr);
            lista.add(valor);
            editTextValor.setText("");
            mostrarLista();
        }
    }

    private void ordenarLista() {
        metodoBurbuja();
        mostrarLista();
    }

    private void metodoBurbuja() {
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - i - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    // Intercambiar elementos
                    int temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }

    private void mostrarLista() {
        StringBuilder resultado = new StringBuilder("Lista: ");
        for (int valor : lista) {
            resultado.append(valor).append(" ");
        }

        textViewResultado.setText(resultado.toString());
    }
}
