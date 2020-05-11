package br.pro.hashi.ensino.desagil.projeto1;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicReference;

public class NumberActivity extends AppCompatActivity {

    boolean numeric = true;

    private void showToast(String text) {

        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        TextView numeroRomano = findViewById(R.id.numero_romano);
        TextView numeroMorse = findViewById(R.id.numero_morse);

        Button buttonMorse = findViewById(R.id.button_morse);
        Button buttonNext = findViewById(R.id.button_next);
        Button buttonConfirm = findViewById(R.id.button_confirm);
        Button buttonDelete = findViewById(R.id.button_delete);

        String frase_morse = numeroMorse.getText().toString();;
        String frase_romano = numeroRomano.getText().toString();

        Translator tradutor = new Translator();

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


        buttonDelete.setOnClickListener((view) -> {
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

        buttonDelete.setOnLongClickListener((view) -> {
            if (numeroMorse.getText() != ""){
                numeroMorse.setText("");
            }
            else{
                numeroRomano.setText("");
            }
            return true;
        });


        buttonNext.setOnClickListener((view) -> {

            /* Deve chamar o Translator para transformar o morse em letra */
            char letra = tradutor.morseToChar(numeroMorse.getText().toString());
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

        buttonConfirm.setOnClickListener((view) -> {
            String message = numeroRomano.getText().toString();
            if (message.isEmpty()) {
                showToast("Mensagem inválida!");
                return;
            }

            SmsManager manager = SmsManager.getDefault();
            numeroRomano.setText("");
        });


    }
}