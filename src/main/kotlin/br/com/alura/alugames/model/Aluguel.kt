package org.example.br.com.alura.alugames.model

import java.time.LocalDate
import java.time.Period

data class Aluguel(val gamer: Gamer,
                   val jogo: Jogo,
                   val periodo: Periodo){

    val valorDoAluguel = periodo.emDias * jogo.preco

    override fun toString(): String {
        return "Aluguel do jogo ${jogo.titulo} por ${gamer.nome}. Valor do aluguel: R$${valorDoAluguel} "
    }
}
