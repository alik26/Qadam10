package com.example.qadam10;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class HomeFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ImageButton zhanatapsyrma = (ImageButton) rootView.findViewById(R.id.imageButton3);

        zhanatapsyrma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) rootView.getContext();
                Fragment nextFrag= new Fragment();

                activity.getFragmentManager().beginTransaction()
                        .replace(R.id.zhanaTapsyrmaFragment,nextFrag).addToBackStack(null).commit();
            }
        });
        return rootView;
    }
}