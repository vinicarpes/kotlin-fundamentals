package org.example.br.com.alura.alugames.utils

import org.example.br.com.alura.alugames.model.Gamer
import org.example.br.com.alura.alugames.model.InfoGamerJson

fun InfoGamerJson.criaGamer() : Gamer{
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}