package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonTranslator = findViewById(R.id.button_translator);
        Button buttonLista = findViewById(R.id.button_list);

        buttonTranslator.setOnClickListener((view) -> {
            Intent intent = new Intent(this, TranslatorActivity.class);
            startActivity(intent);
        });

        buttonLista.setOnClickListener((view) -> {
            Intent intent = new Intent(this, ListActivity.class);
            startActivity(intent);
        });


    }

}
