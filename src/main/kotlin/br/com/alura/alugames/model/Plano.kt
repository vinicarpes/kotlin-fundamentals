package org.example.br.com.alura.alugames.model

sealed class Plano(tipo : String) {
    open fun obterValor(aluguel: Aluguel): Double{
        return aluguel.periodo.emDias * aluguel.jogo.preco
    }
}