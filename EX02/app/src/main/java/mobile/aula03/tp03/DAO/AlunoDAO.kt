package Mobiel.TP03.ex02.DAO

import Mobiel.TP03.ex02.Model.Aluno

class AlunoDAO {
    companion object {
        var aluno: Aluno? = null

        fun salvar(nome: String, turma: String, matricula: Int) {
            aluno = Aluno(nome, turma, matricula)
        }

        fun buscar(): Aluno? = aluno
    }
}