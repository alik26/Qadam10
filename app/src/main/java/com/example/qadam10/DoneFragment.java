package com.example.qadam10;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


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
                FragmentManager f = getActivity().getSupportFragmentManager();
                DialogFragment dialog = new DialogFragment();
                dialog.show(f, "fwefwefwefjowefjwefiwejfwieiwenfiwenfwenfwefiowenfweonweinwenweonfioweniowf");
            }
        });

        return rootView;
    }


}