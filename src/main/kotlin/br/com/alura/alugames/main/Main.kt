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

    do {
        val leitura = Scanner(System.`in`)

        val buscaApi = ConsumoApi()

        println("Digite o codigo do jogo a ser buscado:")
        val busca = leitura.nextInt()

        val meuInfoJogo = buscaApi.buscaJogo(busca)

        var meuJogo: Jogo? = null

        val resultado = runCatching {
            meuJogo = Jogo(
                meuInfoJogo.info.title,
                meuInfoJogo.info.thumb
            )
        }

        resultado.onFailure {
            println("Jogo não existente!")
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")
            val opcao = leitura.next()

            if (opcao.equals("S", true)) {
                leitura.nextLine()
                println("Insira a descrição: ")
                val descricao = leitura.nextLine()
                meuJogo?.descricao = descricao
            } else {
                meuJogo?.descricao = meuJogo.titulo
            }
            println(meuJogo)
        }
        println("Deseja buscar um novo jogo?")
        val resposta = leitura.next()
    } while (resposta.equals("s", true))

    val gamer = Gamer(
        nome = "vinicius",
        email = "vinicdf000@gmail.com"
    )

    gamer.let {
        it.usuario = "vinicarpes"
        it.dataNascimento = "02/02/2004"
    }.also {
        println(gamer)
    }
}