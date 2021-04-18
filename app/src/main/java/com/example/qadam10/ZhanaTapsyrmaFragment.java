package com.example.qadam10;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class ZhanaTapsyrmaFragment extends Fragment{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_zhana_tapsyrma, container, false);
        ImageButton backHome = (ImageButton) rootView.findViewById(R.id.imageBack);

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) rootView.getContext();
                Fragment nextFrag= new Fragment();

                activity.getFragmentManager().beginTransaction()
                        .replace(R.id.homeFragment,nextFrag).addToBackStack(null).commit();

            }
        });
        return rootView;


    }


}