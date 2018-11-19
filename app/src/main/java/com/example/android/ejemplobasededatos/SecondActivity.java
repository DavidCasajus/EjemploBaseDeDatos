package com.example.android.ejemplobasededatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        AndroidHelper admin = new AndroidHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM usuario", null);

        List<String> nombres = new ArrayList<String>();
        final List<User> usuarios = new ArrayList<User>();

        if (c.moveToFirst()) {

            do {
                String dni = c.getString(0);
                String nombre = c.getString(1);
                String ciudad = c.getString(2);
                String numero = c.getString(3);
                nombres.add(nombre);

                User user = new User(dni, nombre, ciudad, numero);
                usuarios.add(user);
            } while (c.moveToNext());

            ListView lv = (ListView) findViewById(R.id.lv_Usuarios);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_users, nombres);
            lv.setAdapter(adapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    setContentView(R.layout.datos_usuarios);
                    TextView tvDni = (TextView) findViewById(R.id.tvDni);
                    TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
                    TextView tvCiudad = (TextView) findViewById(R.id.tvCiudad);
                    TextView tvNumero = (TextView) findViewById(R.id.tvNumero);

                    tvDni.setText(usuarios.get(position).getDni());
                    tvNombre.setText(usuarios.get(position).getNombre());
                    tvCiudad.setText(usuarios.get(position).getCiudad());
                    tvNumero.setText(usuarios.get(position).getNumero());
                }
            });
        }

    }
}





