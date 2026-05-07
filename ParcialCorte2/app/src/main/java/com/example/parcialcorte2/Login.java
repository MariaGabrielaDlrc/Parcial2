package com.example.parcialcorte2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    public static final String DATA_USER_CACHE = "SesionUsuario";
    private EditText edtUsuario, edtPassword;
    private Button btnIngresar;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);
        btnIngresar = findViewById(R.id.btnIngresar);

        sharedPreferences = getSharedPreferences(DATA_USER_CACHE, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        validarLogin();

        btnIngresar.setOnClickListener(v -> validarLoginManual());
    }

    private void validarLogin() {
        String user = sharedPreferences.getString("usuario", "0");

        if (!user.equals("0")) {
            irAMain();
        }
    }

    private void validarLoginManual() {
        String usuario = edtUsuario.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (usuario.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Los campos deben estar llenos", Toast.LENGTH_SHORT).show();
        } else {
            editor.putString("usuario", usuario);
            editor.commit();

            Toast.makeText(this, "Bienvenido " + usuario, Toast.LENGTH_SHORT).show();
            irAMain();
        }
    }

    private void irAMain() {
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}