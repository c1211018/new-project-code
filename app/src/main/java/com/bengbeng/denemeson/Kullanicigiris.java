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


public class Kullanicigiris extends Fragment {
    View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        rootview=inflater.inflate(R.layout.kullanicigiris,container,false);
        Button button3 = (Button) rootview.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Aractakip llf1 = new Aractakip();
                ft.replace(R.id.content_frame, llf1);
                ft.commit();
            }
        });
        return rootview;
    }

}