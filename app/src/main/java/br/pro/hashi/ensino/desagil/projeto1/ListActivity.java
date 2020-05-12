package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class ListActivity extends AppCompatActivity implements Frase1.OnFragmentInteractionListener,Frase2.OnFragmentInteractionListener,Frase3.OnFragmentInteractionListener, Frase4.OnFragmentInteractionListener{
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), 4);

        viewPager.setAdapter(adapter);

        ViewPager mPager = (ViewPager) findViewById(R.id.pager);

        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

        /* Botão para o ir para a home*/
        ImageButton buttonHome = findViewById(R.id.button_home);
        buttonHome.setOnClickListener((view) -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });





    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }


}
