package com.example.tarea03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tarea03.Adaptadores.adt_datos;
import com.example.tarea03.Interfaces.int_restaurantes;
import com.example.tarea03.Modelos.Restaurantes;
import com.example.tarea03.Modelos.Restaurantes.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rclVista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Implementación de retrofit
        Retrofit rf = new Retrofit.Builder()
                .baseUrl("https://api.jsonbin.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        int_restaurantes int_restaurantes = rf.create(int_restaurantes.class);
        Call<Restaurantes> call = int_restaurantes.getRestaurantes();
        call.enqueue(new Callback<Restaurantes>() {
            @Override
            public void onResponse(Call<Restaurantes> call, Response<Restaurantes> response) {
                //Codigo de respuesta a la petición realizada
                String cod_respuesta = "Código " + response.code();
                //Definiendo donde se guardaran los valores obtenidos
                String valores = "";
                //Objeto de la tabla restaurantes
                Restaurantes restaurantes = response.body();
                //Creando array con datos de los restaurantes
                Restaurante[] restaurant_arr = restaurantes.getRestaurantes();
                //De cada objeto restaurante en el array se realiza una acción
                rclVista = (RecyclerView) findViewById(R.id.rclVista);
                rclVista.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
                adt_datos adaptador = new adt_datos(restaurant_arr);
                rclVista.setAdapter(adaptador);
            }

            @Override
            public void onFailure(Call<Restaurantes> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error," +t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}