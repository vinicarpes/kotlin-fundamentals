package org.example.br.com.alura.alugames.model

class PlanoAssinatura(
    tipo: String,
    val mensalidade : Double,
    val jogosIncluidos : Int) : Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): Double {
        val gamesAlugados = aluguel.gamer.jogosAlugados.size+1

        if (gamesAlugados <= jogosIncluidos){
            return 0.0
        }else{
            val valorOriginal = super.obterValor(aluguel)
            return valorOriginal
        }
    }
}