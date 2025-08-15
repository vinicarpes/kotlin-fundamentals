package org.example.br.com.alura.alugames.model

class Jogo(val titulo: String,
           val capa: String) {
    var descricao: String? = null

    override fun toString(): String {
        return "Jogo: \ntitulo = '$titulo', \ncapa =' $capa', \ndescricao =' $descricao')"
    }
}