package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DictionaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        TextView textoDict = findViewById(R.id.texto_dict);
        TextView textoIncRom = findViewById(R.id.texto_inc_rom);
        TextView textoIncMorse = findViewById(R.id.texto_inc_morse);
        TextView scrollDict = findViewById(R.id.scroll_dict);
        scrollDict.setMovementMethod(new ScrollingMovementMethod());
    }
}
