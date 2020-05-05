package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

public class DictionaryActivity extends AppCompatActivity {
    String frase_morse;
    String frase_romano;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        frase_morse = getIntent().getExtras().getString("Morse");
        frase_romano = getIntent().getExtras().getString("Romano");
        TextView textoRomano = findViewById(R.id.texto_inc_rom);
        TextView textoMorse = findViewById(R.id.texto_inc_morse);
        TextView dicio = findViewById(R.id.scroll_dict);
        dicio.setMovementMethod(new ScrollingMovementMethod());

        

       Translator tradutor = new Translator();

       textoRomano.setText(frase_romano);
       textoMorse.setText(frase_morse);

       for (String letra: tradutor.getCodes()) {
        dicio.setText(dicio.getText() + String.valueOf(tradutor.morseToChar(letra)) + ":       " + letra + "\n");
       }
    }
    
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, TranslatorActivity.class);
        intent.putExtra("Romano", frase_romano);
        intent.putExtra("Morse", frase_morse);
        startActivity(intent);
        finish();
 }
        }