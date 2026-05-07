package com.example.parcialcorte2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SettingsFragment extends Fragment {

    public static final String DATA_USER_CACHE = "SesionUsuario";
    private static final int MODO_PRIVATE = Context.MODE_PRIVATE;

    private TextView tvUsuarioLogueado;
    private Button btnCerrarSesion;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        tvUsuarioLogueado = view.findViewById(R.id.tvUsuarioLogueado);
        btnCerrarSesion = view.findViewById(R.id.btnCerrarSesion);

        sharedPreferences = requireActivity().getSharedPreferences(DATA_USER_CACHE, MODO_PRIVATE);
        editor = sharedPreferences.edit();

        mostrarUsuario();

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarSesion();
            }
        });

        return view;
    }

    private void mostrarUsuario() {
        String usuario = sharedPreferences.getString("usuario", "Usuario no encontrado");
        tvUsuarioLogueado.setText(usuario);
    }

    private void cerrarSesion() {
        editor.clear();
        editor.commit();

        Intent intent = new Intent(getActivity(), Login.class);
        startActivity(intent);
        requireActivity().finish();
    }
}