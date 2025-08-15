package org.example.br.com.alura.alugames.model

import java.lang.invoke.StringConcatFactory
import java.time.LocalDate
import java.util.Scanner
import kotlin.random.Random

class Gamer (var nome: String,
             var email: String){
    var dataNascimento: String? =  null
    var usuario: String? = null
        set(value){
            field = value
            if(idInterno.isNullOrBlank()){
                criarIdInterno()
            }
        }
    var idInterno: String? = null
       private set

    val jogosBuscados = mutableListOf<Jogo>()
    val jogosAlugados = mutableListOf<Aluguel>()
    var plano : Plano = PlanoAvulso("BRONZE")

    init {
        if (nome.isBlank()){
            throw IllegalArgumentException("Nome esta em branco")
        }
        this.email=validarEmail()
    }

    constructor(nome: String, email: String, dataNascimento: String, usuario: String):
        this(nome, email){
            this.usuario = usuario
            this.dataNascimento = dataNascimento
            criarIdInterno()
        }

    override fun toString(): String {
        return "\n\nGamer: \nNome = '$nome', \nEmail = '$email', \nData Nascimento = $dataNascimento, \nUsuario = $usuario, \nidInterno = $idInterno"
    }

    fun criarIdInterno(){
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if(regex.matches(email)){
            return email
        }else{
            throw IllegalArgumentException("Email invalido")
        }
    }

    fun alugaJogo(jogo: Jogo, periodo: Periodo) : Aluguel{
        val aluguel = Aluguel(this, jogo, periodo)
        jogosAlugados.add(aluguel)
        return aluguel
    }

    companion object {
        fun criarGamer(leitura : Scanner) : Gamer{
            println("Email: ")
            val email = leitura.nextLine()
            println("Nome:")
            val nome = leitura.nextLine()
            return Gamer(nome, email)
        }
    }
}