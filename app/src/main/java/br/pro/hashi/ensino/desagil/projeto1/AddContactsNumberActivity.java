package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddContactsNumberActivity extends AppCompatActivity {


    // MOSTRAR BOLHA NO TEXTO! SERVE PARA COLOCAR AVISO!!!!!
    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();

    }
    public String nome;
    public Contatos contatos;
    public ListaContatos listaContatos = new ListaContatos();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts_number);
        /* DEFININDO OS TEXTOS ROMANOS E MORSE */
        TextView numeroRomano = findViewById(R.id.texto_romano);
        TextView numeroMorse = findViewById(R.id.texto_morse);
        /* DEFININDO OS BOTÕES/IMAGEBUTTON QUE SERÃO USADOS */
        Button buttonMorse = findViewById(R.id.button_morse);
        Button buttonApagar = findViewById(R.id.button_delete);
        Button buttonLetra = findViewById(R.id.button_next);
        ImageButton buttonDict = findViewById(R.id.button_dict);
        Button buttonConfirmar = findViewById(R.id.button_confirm);

        /* Frase para comparar se ja foi escrito ou não */
        String frase_morse = numeroMorse.getText().toString();
        String frase_romano = numeroRomano.getText().toString();

        /* objeto tradutor */
        Translator tradutor = new Translator();

        nome = getIntent().getExtras().getString("Nome");

        /* Botão para o ir para a home*/
        ImageButton buttonHome = findViewById(R.id.button_home);
        buttonHome.setOnClickListener((view) -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        buttonMorse.setOnClickListener((view) -> {
            String content = ".";
            if (numeroMorse.getText() != frase_morse){
                numeroMorse.setText(numeroMorse.getText() + content);
            }
            else{
                numeroMorse.setText(content);
            }
        });

        buttonMorse.setOnLongClickListener((view) -> {
            String content = "-";
            if (numeroMorse.getText() != frase_morse){
                numeroMorse.setText(numeroMorse.getText() + content);
            }
            else{
                numeroMorse.setText(content);
            }
            return true;
        });


        buttonApagar.setOnClickListener((view) -> {
            boolean checkaTamanho = false;
            String sem_ultima_palavra = "";
            String palavra = numeroRomano.getText().toString();
            if (palavra.length() > 0) {
                sem_ultima_palavra = palavra.substring(0, palavra.length() - 1);
                checkaTamanho = true;
            }
            if (checkaTamanho) {
                if (numeroRomano.getText().toString() != "" && numeroMorse.getText().toString() == "") {
                    numeroRomano.setText(sem_ultima_palavra);
                }
            }
            if (numeroMorse.getText().toString() !=""){
                numeroMorse.setText("");
            }
        });

        buttonApagar.setOnLongClickListener((view) -> {
            if (numeroMorse.getText() != ""){
                numeroMorse.setText("");
            }
            else{
                numeroRomano.setText("");
            }
            return true;
        });


        buttonLetra.setOnClickListener((view) -> {

            /* Deve chamar o Translator para transformar o morse em letra */
            char letra = tradutor.morseToChar(numeroMorse.getText().toString());
            boolean numeric = true;

            if (letra == 'Z') {
                numeroMorse.setText("");
            }



            else{

                try {
                    Double numero = Double.parseDouble(letra + "");
                } catch (NumberFormatException e) {
                    numeric = false;
                }

                if (numeric){
                    if (numeroRomano.getText() != frase_romano){
                        numeroRomano.setText(numeroRomano.getText().toString()+letra);
                    }

                    else{
                        numeroRomano.setText(letra + "");
                    }

                }
                else{
                    numeroRomano.setText(numeroRomano.getText().toString());
                    showToast("Digite um número!");
                }


                numeroMorse.setText("");
            }
            numeroMorse.setText("");
        });

        /* Botão para o dicionário*/
        buttonDict.setOnClickListener((view) -> {
            Intent intent = new Intent(this, DictionaryActivity.class);
            startActivity(intent);
        });

        /* Botão para o dicionário 2*/
        ImageButton buttonDict2 = findViewById(R.id.button_dict2);
        buttonDict2.setOnClickListener((view) -> {
            Intent intent = new Intent(this, MorseToCharActivity.class);
            startActivity(intent);
        });

        buttonConfirmar.setOnClickListener((view) -> {
            String numero = numeroRomano.getText().toString();
            if (!PhoneNumberUtils.isGlobalPhoneNumber(numero)) {
                showToast("Número inválida!");
                return;
            }
//            else if (!PhoneNumberUtils.isGlobalPhoneNumber(numero)) {
//                showToast("Número inválido!");
//            }
            contatos = new Contatos(numero,nome);
            listaContatos.addContatos(contatos);
            ArrayList<String> listaNomes = new ArrayList<String>(listaContatos.getNames());
            ArrayList<String> listaNumeros = new ArrayList<String>(listaContatos.getNumbers());

            Intent intent = new Intent(this, ContatosActivity.class);
            intent.putExtra("NomesContatos", listaNomes);
            intent.putExtra("NumerosContatos", listaNumeros);
            startActivity(intent);


        });

    }
}