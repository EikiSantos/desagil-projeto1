package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MensagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);

        Button buttonContact = findViewById(R.id.button_contato);
        Button buttonDigit = findViewById(R.id.button_number);
        Button buttonAdd = findViewById(R.id.button_add);

        /* Botão para o ir para a home*/
        ImageButton buttonHome = findViewById(R.id.button_home);
        buttonHome.setOnClickListener((view) -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        buttonDigit.setOnClickListener((view) -> {
            Intent intent = new Intent(this, NumberActivity.class);
            startActivity(intent);
            finish();
        });

        buttonContact.setOnClickListener((view) -> {
            Intent intent = new Intent(this, ContatosActivity.class);
            startActivity(intent);
            finish();
        });

        buttonAdd.setOnClickListener((view) -> {
            Intent intent = new Intent(this, AddContactsActivity.class);
            startActivity(intent);
            finish();
        });

    }
}
