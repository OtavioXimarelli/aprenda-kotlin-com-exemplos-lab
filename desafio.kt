fun main() {
    val user1 = Usuario("Paulo", "paulo@gmail.com", 35)
    val user2 = Usuario("Cleber", "ckb@gmail.com", 21)

    val contet1 = ConteudoEducacional("Introdução ao Kotlin", 90, "Conceitos básicos de Kotlin", "Professor A")
    val contet2 = ConteudoEducacional("Introdução ao Java", 90, "Conceitos básicos de Kotlin", "Professor asaw")

    val formacaoJava = Formacao("Formação Java", Nivel.INTERMEDIARIO)
    formacaoJava.addConteudo(strings)
    formacaoJava.addConteudo(arrays)

    formacaoJava.matricular(user1)
    formacaoJava.matricular(user2)

    formacaoJava.details()


}

enum class Nivel { INICIANTE, INTERMEDIARIO, AVANÇADO }

data class Usuario (
    val name: String,
    val email: String,
    val idade: Int
)

data class ConteudoEducacional(
    val nome: String,
    val duracao: Int = 60
    val autor: String
)


class Formacao(
    val nome: String,
    val nivel: Int,
    var conteudos: MutableList<ConteudoEducacional> = mutableListOf()
) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuario ${usuario.name} matriculado na formação $name")

    }

    fun addConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteudo ${conteudo.nome} adicionado a formação $nome")
    }

    fun removeContent(conteudo: ConteudoEducacional) {
        conteudos.remove(conteudo)
        println("Conteudo ${conteudo.nome} removido...")
    }

    fun details() {
        println("Formação: $nome")
        println("Nivel: $nivel")
        println("Conteudos: ")

        for (conteudo in conteudos) {
            println(" - ${conteudo.nome} (${conteudo.duracao} minutos) - (por ${conteudo.autor})")
        }

        for (inscrito in inscritos) {
            println("- ${ïnscrito.nome}  (${inscrito.email})")
        }

    }


}


