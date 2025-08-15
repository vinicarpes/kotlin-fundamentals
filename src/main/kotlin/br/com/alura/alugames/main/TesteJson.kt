package org.example.br.com.alura.alugames.main

import org.example.br.com.alura.alugames.services.ConsumoApi

fun main(){
    val consumoApi = ConsumoApi()

    val listaGamers = consumoApi.buscaGamers()

    println(listaGamers)
}