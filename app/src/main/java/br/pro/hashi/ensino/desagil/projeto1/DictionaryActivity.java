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

import java.util.Collections;
import java.util.LinkedList;

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
        LinkedList<String> ordem = new LinkedList<>();
        LinkedList<String> alfabeto = new LinkedList<>();

       Translator tradutor = new Translator();
        ordem = tradutor.getCodes();

        for (String letra: ordem) {
            alfabeto.add("" + tradutor.morseToChar(letra));
        }

        Collections.sort(alfabeto);

       for (String letra: alfabeto) {
        dicio.setText(dicio.getText() + letra +":       " + tradutor.charToMorse(letra.charAt(0)) + "\n");
       }
    }
    
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, TranslatorActivity.class);
        startActivity(intent);
        finish();
    }
}