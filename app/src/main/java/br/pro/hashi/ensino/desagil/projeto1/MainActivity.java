package br.pro.hashi.ensino.desagil.projeto1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Esta constante é um código que identifica o pedido de "mandar sms".
    private static final int REQUEST_SEND_SMS = 0;
    // Método de conveniência para iniciar a SMSActivity.
    private void startSMSActivity() {

        // Constrói uma Intent que corresponde ao pedido de "iniciar Activity".
        Intent mensagem = new Intent(this, MensagemActivity.class);

        // Inicia a Activity especificada na Intent.
        startActivity(mensagem);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonTranslator = findViewById(R.id.button_translator);
        Button buttonLista = findViewById(R.id.button_list);
        Button buttonMensagem = findViewById(R.id.button_mensagem);

        buttonTranslator.setOnClickListener((view) -> {
            Intent intent = new Intent(this, TranslatorActivity.class);
            startActivity(intent);
        });

        buttonLista.setOnClickListener((view) -> {
            Intent intent = new Intent(this, ListActivity.class);
            startActivity(intent);
        });

        buttonMensagem.setOnClickListener((view) -> {
            Intent intent = new Intent(this, MensagemActivity.class);
            startActivity(intent);
        });
    }

//        buttonMensagem.setOnClickListener((view) -> {
//
//            // Verifica se o aplicativo tem a permissão desejada.
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
//
//                startSMSActivity();
//            } else {
//
//                // Senão, precisamos pedir essa permissão.
//
//                // Cria um vetor de permissões a pedir. Como queremos
//                // uma só, parece um pouco feio, mas é bem conveniente
//                // quando queremos pedir várias permissões de uma vez.
//                String[] permissions = new String[]{
//                        Manifest.permission.SEND_SMS,
//                };
//
//                ActivityCompat.requestPermissions(this, permissions, REQUEST_SEND_SMS);
//            }
//        });
//
//
//    }
//
//    // Como consequência da chamada de requestPermissions acima, este
//    // método é chamado quando o usuário responde o pedido de permissão.
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//
//        // Verifica se de fato é uma resposta ao pedido acima e se a
//        // resposta foi positiva. As respostas estão armazenadas no
//        // vetor grantResults, que pode estar vazio se o usuário
//        // escolheu simplesmente ignorar o pedido e não responder nada.
//        if (requestCode == REQUEST_SEND_SMS && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//            startSMSActivity();
//        }
//    }

}
