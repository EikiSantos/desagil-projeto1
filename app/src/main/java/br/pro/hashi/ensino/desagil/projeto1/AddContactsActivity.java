package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class AddContactsActivity extends AppCompatActivity {
    // MOSTRAR BOLHA NO TEXTO! SERVE PARA COLOCAR AVISO!!!!!
    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();

    }
    public String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);
        /* DEFININDO OS TEXTOS ROMANOS E MORSE */
        TextView textoRomano = findViewById(R.id.texto_romano);
        TextView textoMorse = findViewById(R.id.texto_morse);
        /* DEFININDO OS BOTÕES/IMAGEBUTTON QUE SERÃO USADOS */
        Button buttonMorse = findViewById(R.id.button_morse);
        Button buttonPalavra = findViewById(R.id.button_palavra);
        Button buttonApagar = findViewById(R.id.button_apagar);
        Button buttonLetra = findViewById(R.id.button_letra);
        ImageButton buttonDict = findViewById(R.id.button_dict);
        Button buttonName = findViewById(R.id.button_nome);

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

        /* Botão para o dicionário*/
        buttonDict.setOnClickListener((view) -> {
            Intent intent = new Intent(this, DictionaryActivity.class);
            startActivity(intent);
        });
        /* Botão para o confirmar*/
        buttonName.setOnClickListener((view) -> {

            nome = textoRomano.getText().toString();
            Intent intent = new Intent(this, AddContactsNumberActivity.class);
            intent.putExtra("Nome",nome);
            startActivity(intent);
        });

    }
}

