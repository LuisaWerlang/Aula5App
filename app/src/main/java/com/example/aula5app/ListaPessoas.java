package com.example.aula5app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

public class ListaPessoas extends ListActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lista_pessoas);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listarPessoas()));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);
    }

    private List<String> listarPessoas() {
        return Arrays.asList("Lamb Ari", "Beto Neira", "Brita Deira", "Gil Ete", "Astolfo");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView textView = (TextView) view;
        String nome = (String) textView.getText();

        Intent intent = new Intent(ListaPessoas.this, Pessoa.class);
        intent.putExtra("nome", nome);
        startActivity(intent);

        //String mensagem = "Pessoa selecionada: "+ textView.getText();
        //Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();
    }
}