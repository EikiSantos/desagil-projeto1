package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
    public class TranslatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);
        TextView textoRomano = findViewById(R.id.texto_romano);
        TextView textoMorse = findViewById(R.id.texto_morse);
        Button buttonMorse = findViewById(R.id.button_morse);
        Button buttonPalavra = findViewById(R.id.button_palavra);
        Button buttonApagar = findViewById(R.id.button_apagar);
        Button buttonLetra = findViewById(R.id.button_letra);
        Button buttonDict = findViewById(R.id.button_dict);

        /* Frase para comparar se ja foi escrito ou não */
        String frase_morse = textoMorse.getText().toString();
        String frase_romano = textoRomano.getText().toString();

        /* objeto tradutor */
        Translator tradutor = new Translator();
        /* METODO DE ponto */
        buttonMorse.setOnClickListener((view) -> {
            String content = ".";
            if (textoMorse.getText() != frase_morse){
                textoMorse.setText( textoMorse.getText() + content);
            }
            else{
                textoMorse.setText(content);
            }
        });

//          METODO DE TRAÇO
        buttonMorse.setOnLongClickListener((view) -> {
            String content = "-";
            if (textoMorse.getText() != frase_morse){
                textoMorse.setText( textoMorse.getText() + content);
            }
            else{
                textoMorse.setText(content);
            }
            return true;
        });

        /* METODO Apagar */
        buttonApagar.setOnClickListener((view) -> {
            boolean checkaTamanho = false;
            String sem_ultima_palavra = "";
            String palavra = textoRomano.getText().toString();
            if (palavra.length() > 0) {
                sem_ultima_palavra = palavra.substring(0, palavra.length() - 1);
                checkaTamanho = true;
            }
            if (checkaTamanho) {
                if (textoRomano.getText().toString() != "" && textoMorse.getText().toString() == "") {
                    textoRomano.setText(sem_ultima_palavra);
                }
            }
            if (textoMorse.getText().toString() !=""){
                textoMorse.setText("");
            }
        });

//        METODO APAGAR ON HOLD (APAGAR MAIS RAPIDO)
        buttonApagar.setOnLongClickListener((view) -> {
            if (textoMorse.getText() != ""){
                textoMorse.setText("");
            }
            else{
                textoRomano.setText("");
            }
            return true;
        });

        /* METODO DE proxima letra */
        buttonLetra.setOnClickListener((view) -> {
            /* Deve chamar o Translator para transformar o morse em letra */
            char letra = tradutor.morseToChar(textoMorse.getText().toString());
            if (letra == 'Z') {
                textoMorse.setText("");
            }
            else{
                    if (textoRomano.getText() != frase_romano) {
                        textoRomano.setText(textoRomano.getText().toString() + letra);
                    } else {
                        textoRomano.setText(letra + "");
                    }
                    textoMorse.setText("");
                }
            textoMorse.setText("");
        });

        /* Metodo de proxima palavra */
        buttonPalavra.setOnClickListener((view) ->{
            /* Ira zerar a palavra feita anteriormente e dar um espaço no alfabeto */
            if (textoRomano.getText() != frase_romano){
                textoRomano.setText(textoRomano.getText().toString() + " ");
            }
        });

//        /* Botão para o dicionário*/
//        buttonDict.setOnClickListener((view) -> {
//            Intent intent = new Intent(this, DictionaryActivity.class);
//            intent.putExtra("Romano", textoRomano.getText());
//            intent.putExtra("Morse", textoMorse.getText());
//            startActivity(intent);
//            finish();
//        });

        /*Botão para o popup*/
        buttonDict.setOnClickListener((view) -> {
            // inflate the layout of the popup window
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.activity_dictionary_pop_up, null);

            // create the popup window
            int width = LinearLayout.LayoutParams.MATCH_PARENT;
            int height = LinearLayout.LayoutParams.MATCH_PARENT;
            boolean focusable = true; // lets taps outside the popup also dismiss it
            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

            // show the popup window
            // which view you pass in doesn't matter, it is only used for the window tolken
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

            // dismiss the popup window when touched
            popupView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow.dismiss();
                    return true;
                }
            });
        });

    }
}
