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
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AracKaydi extends Fragment {
    View rootview;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        rootview=inflater.inflate(R.layout.arackaydi,container,false);
        Button button7 = (Button) rootview.findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                BarcodeScan llf7 = new BarcodeScan();
                ft.replace(R.id.content_frame, llf7);
                ft.commit();
            }
        });


        Button Kayit = (Button)rootview.findViewById(R.id.button6);

        final EditText kisiAd = (EditText)rootview.findViewById(R.id.editText7);
        final EditText kisiSoyad = (EditText) rootview.findViewById(R.id.editText8);
        final EditText kisiEmail =(EditText)rootview.findViewById(R.id.editText6);
        final EditText kisiTel= (EditText)rootview.findViewById(R.id.editText9);
        final EditText kisiSifre = (EditText)rootview.findViewById(R.id.editText10);
        final EditText aracPlaka = (EditText)rootview.findViewById(R.id.editText11);
        final EditText aracTanimi = (EditText)rootview.findViewById(R.id.editText12);

       final Kisiler kisi = new Kisiler();


        Kayit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseDatabase db;
                db = FirebaseDatabase.getInstance();
                DatabaseReference dbref = db.getReference("KisiBilgileri");
                String Key = dbref.push().getKey();
                DatabaseReference dbrefYeni = db.getReference("KisiBilgileri/"+Key);


                kisi.Ad = kisiAd.getText().toString();
                kisi.Soyad = kisiSoyad.getText().toString();
                kisi.Email = kisiEmail.getText().toString();
                kisi.Tel = kisiTel.getText().toString();
                kisi.Sifre = kisiSifre.getText().toString();
                kisi.Plaka = aracPlaka.getText().toString();
                kisi.HasarTanim = aracTanimi.getText().toString();
                dbrefYeni.setValue(kisi);

            }
        });





        return rootview;
    }
}