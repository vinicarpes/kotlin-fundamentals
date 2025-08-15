package org.example.br.com.alura.alugames.services

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.br.com.alura.alugames.model.Gamer
import org.example.br.com.alura.alugames.model.InfoGamerJson
import org.example.br.com.alura.alugames.model.InfoJogo
import org.example.br.com.alura.alugames.model.InfoJogoJson
import org.example.br.com.alura.alugames.model.Jogo
import org.example.br.com.alura.alugames.utils.criaGamer
import org.example.br.com.alura.alugames.utils.criaJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    fun buscaJogos () :  List<Jogo>{
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()


        val gson = Gson()
        val meuJogoTipo = object : TypeToken<List<InfoJogoJson>>() {}.type
        val listaJogos : List<InfoJogoJson> = gson.fromJson(json, meuJogoTipo)

        val listaJogoConvertida = listaJogos.map { infoJogoJson ->
            infoJogoJson.criaJogo()
        }

        return listaJogoConvertida
    }

    fun buscaGamers() : List<Gamer>{
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()


        val gson = Gson()
        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>> () {}.type
        val listaGamers : List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listaGamers.map { infoGamerJson ->
            infoGamerJson.criaGamer()
        }

        return listaGamerConvertida
    }

}