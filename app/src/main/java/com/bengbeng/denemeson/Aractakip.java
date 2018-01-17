package com.bengbeng.denemeson;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Aractakip extends Fragment {
    View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootview = inflater.inflate(R.layout.aractakip,
                container, false);
        Button button = (Button) rootview.findViewById(R.id.button);
        Button button2 = (Button) rootview.findViewById(R.id.button2);

        FirebaseDatabase db = FirebaseDatabase.getInstance();



        button.setOnClickListener(new View.OnClickListener() {
            TextView textViewDeneme = (TextView)rootview.findViewById(R.id.textView4);
                                      public void onClick(View v) {
                                          FirebaseDatabase db = FirebaseDatabase.getInstance();
                                          DatabaseReference dbGelenler = db.getReference("KisiBilgileri");
                                          dbGelenler.addListenerForSingleValueEvent(new ValueEventListener() {
                                              @Override
                                              public void onDataChange(DataSnapshot dataSnapshot) {
                                                  ArrayList<Kisiler> kisiler = new ArrayList<Kisiler>();

                                                  Iterable<DataSnapshot> keys=dataSnapshot.getChildren();
                                                  for (DataSnapshot key: keys) {
                                                      kisiler.add(key.getValue(Kisiler.class));
                                                  }
                                              }

                                              @Override
                                              public void onCancelled(DatabaseError databaseError) {

                                              }
                                          });

                                          FragmentManager fm = getFragmentManager();
                                          FragmentTransaction ft = fm.beginTransaction();
                                          Kullanicigiris llf1 = new Kullanicigiris();
                                          ft.replace(R.id.content_frame, llf1);
                                          ft.commit();
                                      }

                                  });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent intent = new Intent(getContext(), KullaniciSayfa.class);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Kurumsalgiris llf = new Kurumsalgiris();
                ft.replace(R.id.content_frame, llf);
                ft.commit();
            }
        });
        return rootview;
    }

}