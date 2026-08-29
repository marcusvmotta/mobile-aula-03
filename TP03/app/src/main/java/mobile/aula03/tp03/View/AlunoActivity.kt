package Mobiel.TP03.ex02.View

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import Mobiel.TP03.ex02.R
import Mobiel.TP03.ex02.DAO.AlunoDAO
import com.google.android.material.button.MaterialButton
import kotlin.random.Random

class AlunoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aluno)

        val tvNomeAluno = findViewById<TextView>(R.id.tvNomeAluno)
        val btnGerarMatricula = findViewById<MaterialButton>(R.id.btnGerarMatricula)
        val cardResultado = findViewById<CardView>(R.id.cardResultado)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        val nome = intent.getStringExtra("NOME") ?: ""
        val turma = intent.getStringExtra("TURMA") ?: ""
        tvNomeAluno.text = nome

        btnGerarMatricula.setOnClickListener {
            val matricula = Random.nextInt(100000, 999999)

            AlunoDAO.salvar(nome, turma, matricula)

            val alunoSalvo = AlunoDAO.buscar()
            tvResultado.text = "Matrícula: ${alunoSalvo?.matricula}\n" +
                    "Aluno: ${alunoSalvo?.nomeAluno}\n" +
                    "Turma: ${alunoSalvo?.turma}"
            cardResultado.visibility = android.view.View.VISIBLE
        }
    }
}