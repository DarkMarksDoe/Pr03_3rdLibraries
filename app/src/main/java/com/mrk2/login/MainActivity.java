package com.mrk2.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

import java.util.ArrayList;

import modelos.Cuentas;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnRegister;
    EditText txtUser, txtPswd;
    public static ArrayList<Cuentas> pepaPig = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //operaciones();
        cargarControls();
        cargarEventos();
    }

    private void cargarEventos() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        if(!txtUser.getText().toString().isEmpty() && !txtPswd.getText().toString().isEmpty()){
            if(pepaPig.size()>0){
                boolean validate = false;
                Cuentas myAccount = new Cuentas();
                String us = txtUser.getText().toString();
                String pw = txtPswd.getText().toString();
                for (int i = 0; i < pepaPig.size(); i++) {
                    if(pepaPig.get(i).user.equalsIgnoreCase(us) && pepaPig.get(i).pwd.equalsIgnoreCase(pw)){
                        validate = true;
                        break;
                    }
                }
                if (validate){
                    mSuperToast("Matando a pepa Pig", Style.TYPE_PROGRESS_BAR);
                    mSuperToast("Inicio Exitoso",Style.TYPE_BUTTON);
                    txtPswd.setText("");
                    txtUser.setText("");
                }else{
                    mSuperToast("Bad Credentials", Style.TYPE_BUTTON);
                }
            }
        }else{
            if(txtUser.getText().toString().isEmpty()){
                Toast.makeText(this, "Empty User", Toast.LENGTH_SHORT).show();
            }else if (txtPswd.getText().toString().isEmpty()){
                Toast.makeText(this, "Empty Password", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void registrar() {
        if(!txtUser.getText().toString().isEmpty() && !txtPswd.getText().toString().isEmpty()){
            Cuentas myAccount = new Cuentas();
            myAccount.user = txtUser.getText().toString();
            myAccount.pwd = txtPswd.getText().toString();
            pepaPig.add(myAccount);
            //Toast.makeText(this, "Success Register " + txtUser.getText().toString(), Toast.LENGTH_SHORT).show();
            mSuperToast("Registrando", Style.TYPE_BUTTON);
            txtPswd.setText("");
            txtUser.setText("");
        }else{
            if(txtUser.getText().toString().isEmpty()){
                Toast.makeText(this, "Empty User", Toast.LENGTH_SHORT).show();
            }else if (txtPswd.getText().toString().isEmpty()){
                Toast.makeText(this, "Empty Password", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void mSuperToast(String texr, int typeButton) {
        SuperActivityToast.create(MainActivity.this, new Style(), typeButton)
                //.setButtonText("Deshacer")
                //.setButtonIconResource(R.mipmap.ic_launcher)
                //.setOnButtonClickListener("Texto" , null, null)
                //.setProgressBarColor(Color.BLUE)
                .setText(texr)
                .setDuration(Style.DURATION_LONG)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_LIGHT_BLUE))
                .setAnimations(Style.ANIMATIONS_POP)
                .show();

    }

    private void cargarControls() {
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegistrar);
        txtUser = findViewById(R.id.txtUser);
        txtPswd = findViewById(R.id.txtPswd);

    }

    private void operaciones() {
        //Este metodo determina el numero mayor de 3 numeros
        int n1 = 5, n2 = 3, n3 = 1;
        if (n1 > n3 && n1 > n2) { //mayor n1

        } else if (n2 > n3 && n2 > n1) { //Mayor n2

        } else if (n3 > n1 && n3 > n2) { //Mayor n3

        }
    }
}