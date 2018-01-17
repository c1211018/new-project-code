package com.bengbeng.denemeson;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Kurumsalgiris extends Fragment {
    View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        rootview=inflater.inflate(R.layout.kurumsalgiris,container,false);
        Button button4 = (Button) rootview.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                AracKaydi llf2 = new AracKaydi();
                ft.replace(R.id.content_frame, llf2);
                ft.commit();
            }
        });

        Button button5 = (Button) rootview.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                KayitliArac llf2 = new KayitliArac();
                ft.replace(R.id.content_frame, llf2);
                ft.commit();
            }
        });
        return rootview;
    }

}