package org.example.br.com.alura.alugames.model

class Jogo(
    val titulo: String,
    val capa: String,
    val descricao: String,
    val preco: Double
) {
    override fun toString(): String {
        return "\n\nJogo: \nTitulo='$titulo', \nCapa='$capa', \nDescricao='$descricao', \nPre'ç'o=$preco)"
    }
}