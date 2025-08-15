package org.example.br.com.alura.alugames.main

import com.google.gson.Gson
import org.example.br.com.alura.alugames.model.Gamer
import org.example.br.com.alura.alugames.model.InfoJogo
import org.example.br.com.alura.alugames.model.Jogo
import org.example.br.com.alura.alugames.model.Periodo
import org.example.br.com.alura.alugames.model.PlanoAssinatura
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
    val jogoSpider = listaJogos.get(13)
    val theLast = listaJogos.get(2)
//    println(residentEvilVillage)
//    println(gamerCaroline)

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7) )
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3) )
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10) )

    gamerCaroline.alugaJogo(residentEvilVillage, periodo1)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(theLast, periodo3)
//    println(gamerCaroline.jogosAlugados)

    val gamerCamila = listaGamers.get(2)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3)

    gamerCamila.alugaJogo(residentEvilVillage, periodo1)
    gamerCamila.alugaJogo(jogoSpider, periodo2)
    gamerCamila.alugaJogo(theLast, periodo3)
    gamerCamila.alugaJogo(theLast, periodo2)
    println(gamerCamila.jogosAlugados)
}