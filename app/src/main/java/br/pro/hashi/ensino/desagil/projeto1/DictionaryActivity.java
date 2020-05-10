package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.TextView;

public class DictionaryActivity extends AppCompatActivity {

    public void onStart() {
        super.onStart();

        Window dialogWindow = getWindow();
        dialogWindow.getAttributes().width = ListPopupWindow.MATCH_PARENT;
        dialogWindow.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        dialogWindow.setBackgroundDrawable(new ColorDrawable(0xe6a9a9a9));
        dialogWindow.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        TextView dicio = findViewById(R.id.scroll_dict);
        dicio.setMovementMethod(new ScrollingMovementMethod());

       Translator tradutor = new Translator();

       for (String letra: tradutor.getCodes()) {
        dicio.setText(dicio.getText() + String.valueOf(tradutor.morseToChar(letra)) + ":       " + letra + "\n");
       }
    }
    
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, TranslatorActivity.class);
        startActivity(intent);
        finish();
 }
        }