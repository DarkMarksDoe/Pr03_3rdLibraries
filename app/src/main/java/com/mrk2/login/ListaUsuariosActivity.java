package com.mrk2.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaUsuariosActivity extends MainActivity {
    ListView lvUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        cargamePapu();

    }

    private void cargamePapu() {
        //Relationate java control with xml file
        lvUsuarios = findViewById(R.id.lua_list_users);

        // Create the list of the arrat on the listView
        ArrayAdapter arrad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,pepaPig);
        lvUsuarios.setAdapter(arrad);

        //Create clic event on the list
        lvUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
