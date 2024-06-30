package br.com.alura.challenge.model;


import com.google.gson.annotations.SerializedName;

public record Dados(
        @SerializedName("conversion_rate")
        double conversao) {
        }

