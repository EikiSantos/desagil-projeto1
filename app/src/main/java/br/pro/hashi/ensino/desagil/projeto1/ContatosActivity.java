package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.LinkedList;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class ContatosActivity extends ListActivity {
    ArrayAdapter arrayAdapter;
    private ListView listView;
    public ArrayList<String> listaNomes;
    public ArrayList<String> listaNumeros;


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_contatos);
        /* Metodo para checar se foi enviado algo para a intent */
        Intent intenta = getIntent();
        if (intenta.hasExtra("NomesContatos")) {
            listaNomes =  (ArrayList<String>) getIntent().getSerializableExtra("NomesContatos");
            listaNumeros = (ArrayList<String>) getIntent().getSerializableExtra("NumerosContatos");
            listView = findViewById(R.id.list);
            arrayAdapter = new ArrayAdapter(ContatosActivity.this, android.R.layout.simple_list_item_1, listaNomes);
            listView.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();
            listView.invalidateViews();
            listView.refreshDrawableState();
        }



        /* Botão para o ir para a home*/
        ImageButton buttonHome = findViewById(R.id.button_home);
        buttonHome.setOnClickListener((view) -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


    }
}
