package com.example.aula5app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meumenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.itemNew:
                Toast.makeText(this, "Novo!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemSave:
                Toast.makeText(this, "Salvar!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemAdd:
                Toast.makeText(this, "Adicionar!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemLista:
                //Toast.makeText(this, "Lista!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,ListaPessoas.class));
                return true;
        }
        return false;
    }
}