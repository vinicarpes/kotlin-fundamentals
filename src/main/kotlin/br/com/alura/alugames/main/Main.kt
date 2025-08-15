package org.example.br.com.alura.alugames.main

import com.google.gson.Gson
import org.example.br.com.alura.alugames.model.Gamer
import org.example.br.com.alura.alugames.model.InfoJogo
import org.example.br.com.alura.alugames.model.Jogo
import org.example.br.com.alura.alugames.services.ConsumoApi
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.Scanner

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val consumoApi = ConsumoApi()

    val listaGamers = consumoApi.buscaJogos()

    println(listaGamers)
}