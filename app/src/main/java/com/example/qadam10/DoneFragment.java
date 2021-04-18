package com.example.qadam10;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import android.app.Fragment;

import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import java.security.AccessController;


public class DoneFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_done, container, false);
        Button tolygyrak = (Button) rootView.findViewById(R.id.Tolygyrak);



        tolygyrak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) rootView.getContext();
                DialogFragment dialogFragment = new DialogFragment();
                dialogFragment.show(activity.getSupportFragmentManager(), "fwefwefwefjowefjwefiwejfwieiwenfiwenfwenfwefiowenfweonweinwenweonfioweniowf");
            }
        });

        return rootView;
    }


}