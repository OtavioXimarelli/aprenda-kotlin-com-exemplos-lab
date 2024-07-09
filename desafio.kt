enum class Nivel { INICIANTE, INTERMEDIARIO, AVANÇADO }

data class Usuario(
    val nome: String,
    val email: String,
    val idade: Int
)

data class ConteudoEducacional(
    val nome: String,
    val duracao: Int = 60, // Duração padrão de 60 minutos
    val autor: String
)

class Formacao(
    val nome: String,
    val nivel: Nivel, // Usando o enum Nivel para representar o nível
    var conteudos: MutableList<ConteudoEducacional> = mutableListOf()
) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome")
    }

    fun addConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo ${conteudo.nome} adicionado à formação $nome")
    }

    fun removeConteudo(conteudo: ConteudoEducacional) {
        if (conteudos.remove(conteudo)) {
            println("Conteúdo ${conteudo.nome} removido da formação $nome")
        } else {
            println("Conteúdo ${conteudo.nome} não encontrado na formação $nome")
        }
    }

    fun details() {
        println("Formação: $nome")
        println("Nível: $nivel") // Imprime o nome do nível (ex: "INTERMEDIARIO")
        println("Conteúdos:")
        if (conteudos.isEmpty()) {
            println("   Nenhum conteúdo adicionado ainda.")
        } else {
            for (conteudo in conteudos) {
                println(" - ${conteudo.nome} (${conteudo.duracao} minutos) - (por ${conteudo.autor})")
            }
        }

        println("Inscritos:")
        if (inscritos.isEmpty()) {
            println("   Nenhum inscrito ainda.")
        } else {
            for (inscrito in inscritos) {
                println(" - ${inscrito.nome} (${inscrito.email})")
            }
        }
    }
}

fun main() {
    val user1 = Usuario("Paulo", "paulo@gmail.com", 35)
    val user2 = Usuario("Cleber", "ckb@gmail.com", 21)

    val contet1 = ConteudoEducacional("Introdução ao Kotlin", 90, "Professor A")
    val contet2 = ConteudoEducacional("Introdução ao Java", 120, "Professor B") // Duração alterada para 120 minutos

    val formacaoJava = Formacao("Formação Java", Nivel.INTERMEDIARIO)
    formacaoJava.addConteudo(contet1) // Adicionando os conteúdos corretos
    formacaoJava.addConteudo(contet2)

    formacaoJava.matricular(user1)
    formacaoJava.matricular(user2)

    formacaoJava.details()
}
