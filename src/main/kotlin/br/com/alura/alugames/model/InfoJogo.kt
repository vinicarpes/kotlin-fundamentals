package org.example.br.com.alura.alugames.model

data class InfoJogo(val info: InfoJogoJson) {
    override fun toString(): String {
        return info.toString()
    }
}