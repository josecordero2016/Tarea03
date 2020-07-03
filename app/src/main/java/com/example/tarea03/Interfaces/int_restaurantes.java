package com.example.tarea03.Interfaces;

import com.example.tarea03.Modelos.Restaurantes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface int_restaurantes {
    @Headers({
            "secret-key: $2b$10$XMPGhDI648HghIgRqs8jGeh6kJr9zUMz6AXhUuGaSZtuI9WqqaBw2"
    })

    @GET("b/5efe7a287f16b71d48aa3b09")
    Call<Restaurantes> getRestaurantes();
}
