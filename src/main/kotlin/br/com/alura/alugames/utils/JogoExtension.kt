package org.example.br.com.alura.alugames.utils

import org.example.br.com.alura.alugames.model.Gamer
import org.example.br.com.alura.alugames.model.InfoGamerJson
import org.example.br.com.alura.alugames.model.InfoJogoJson
import org.example.br.com.alura.alugames.model.Jogo

fun InfoJogoJson.criaJogo() : Jogo{
    return Jogo(this.titulo, this.capa, this.descricao, this.preco)
}