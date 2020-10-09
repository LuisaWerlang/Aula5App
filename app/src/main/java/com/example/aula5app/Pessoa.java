package com.example.aula5app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Pessoa extends AppCompatActivity {

    private TextView txt;
    private Spinner lista_estados;
    private ListView cidades;

    String[] ufs = {"","Rio Grande do Sul","Santa Catarina","Paraná","São Paulo","Minas Gerais"};
    String[][] lista_cidades = {
            new String[]{""},
            new String[]{"Porto Alegre","Santa Maria","Caxias do Sul","Santa Cruz do Sul","Pelotas","Rio Grande"},
            new String[]{"Florianópolis","Joinville","Criciúma","Chapecó","Blumenau"},
            new String[]{"Curitiba","Londrina","Maringá","Foz do Iguaçu"},
            new String[]{"São Paulo","Campinas","Osasco"},
            new String[]{"Belo Horizonte","Uberaba"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa);

        cidades = (ListView) findViewById(R.id.cidades);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");

        txt = findViewById(R.id.nome);
        txt.setText(nome);

        lista_estados = findViewById(R.id.estados);
        final ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, ufs);
        lista_estados.setAdapter(adapter);

        lista_estados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] selected = getRow(i);
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Arrays.asList(selected));
                cidades.setAdapter(adapter1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        cidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //String[] item = lista_cidades[i][]
                Toast.makeText(getApplicationContext(), "Cidade selecionada!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String[] getRow(int index)
    {
        String[] row = new String[lista_cidades[index].length];
        for(int i =0; i<row.length; i++)
            row[i] = lista_cidades[index][i];
        return row;
    }

}