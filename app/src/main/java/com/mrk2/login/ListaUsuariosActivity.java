package com.mrk2.login;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

import java.util.ArrayList;

import modelos.Cuentas;

public class ListaUsuariosActivity extends MainActivity {
    ListView lvUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        //Relationate java control with xml file
        lvUsuarios = findViewById(R.id.lua_list_users);
        //Sending data to a class, send data from Act2 to Act1
        Bundle bundle = getIntent().getExtras();
        String variable = bundle.getString("valor");
        super.mSuperToast(variable,Style.TYPE_BUTTON);
        cargamePapu();

    }

    private void cargamePapu() {
        // Create an arraylist typed String
        ArrayList<String> arrayUs = new ArrayList<>();
        for (int i = 0; i < pepaPig.size(); i++) {
            arrayUs.add(pepaPig.get(i).toString());
        }

        //Create a list of the array on the listView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayUs);
        lvUsuarios.setAdapter(adapter);
        //Create an event on the list
        lvUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myToast(position);
            }
        });
    }
    void myToast(final int pos) {
        String dato = pepaPig.get(pos).user + " (" + pepaPig.get(pos).pwd+")";
        SuperActivityToast.create(this, Style.TYPE_BUTTON)
                .setButtonText("Borrar")
                .setButtonIconResource(R.mipmap.ic_launcher_round)
                .setOnButtonClickListener("Eliminar", null, new SuperActivityToast.OnButtonClickListener() {
                    @Override
                    public void onClick(View view, Parcelable token) {
                    deleteData(pos);
                    }
                })
                .setProgressBarColor(Color.BLUE)
                .setText(dato)
                .setDuration(Style.DURATION_LONG)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_INDIGO))
                .setAnimations(Style.ANIMATIONS_FLY)
                .show();

    }

    private void deleteData(int pos) {
        pepaPig.remove(pos);
        //Toast.makeText(this, "Registro eliminado" , Toast.LENGTH_SHORT);
        super.mSuperToast("Registro Eliminado", Style.TYPE_BUTTON);
        cargamePapu();
    }
}
