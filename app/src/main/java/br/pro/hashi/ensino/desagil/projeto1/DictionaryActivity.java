package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DictionaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        String frase_morse = getIntent().getExtras().getString('Morse');
        String frase_romano = getIntent().getExtras().getString('Romano');
        TextView textoRomano = findViewById(R.id.texto_inc_rom);
        TextView textoMorse = findViewById(R.id.texto_inc_morse);










        
        // Intent resultIntent = new Intent();
        // resultIntent.putExtra(PUBLIC_STATIC_STRING_IDENTIFIER, enteredTextValue);
        // setResult(Activity.RESULT_OK, resultIntent);
        // finish();
    }
}