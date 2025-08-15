package org.example.br.com.alura.alugames.main

import com.google.gson.Gson
import org.example.br.com.alura.alugames.model.Gamer
import org.example.br.com.alura.alugames.model.InfoJogo
import org.example.br.com.alura.alugames.model.Jogo
import org.example.br.com.alura.alugames.model.Periodo
import org.example.br.com.alura.alugames.services.ConsumoApi
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.LocalDate
import java.util.Scanner

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val consumoApi = ConsumoApi()
    val listaGamers = consumoApi.buscaGamers()
    val listaJogos = consumoApi.buscaJogos()

    val gamerCaroline = listaGamers.get(3)
    val residentEvilVillage = listaJogos.get(10)
//    println(residentEvilVillage)
//    println(gamerCaroline)

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7) )

    println(gamerCaroline.alugaJogo(residentEvilVillage, periodo))
}