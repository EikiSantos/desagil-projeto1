package br.pro.hashi.ensino.desagil.projeto1;

import android.graphics.Color;
import android.os.Bundle;

import android.net.Uri;

import android.content.Context;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frase3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frase4 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    int clickcount=0;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Frase1.OnFragmentInteractionListener mListener;

    public Frase4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frase3.
     */
    // TODO: Rename and change types and number of parameters
    public static Frase4 newInstance(String param1, String param2) {
        Frase4 fragment = new Frase4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frase4, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Frase1.OnFragmentInteractionListener) {
            mListener = (Frase1.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        Button buttonDor = view.findViewById(R.id.button_dor);
        buttonDor.setOnClickListener((view2) -> {
            clickcount +=1;
            if (clickcount ==1) {
                buttonDor.setBackgroundColor(Color.parseColor("#f55b38"));
            }
            if (clickcount > 1){
                buttonDor.setBackgroundColor(Color.parseColor("#9459cf"));
                clickcount = 0;
            }
        });
    }
}
