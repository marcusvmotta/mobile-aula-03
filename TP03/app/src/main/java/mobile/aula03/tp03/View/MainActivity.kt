package Mobiel.TP03.ex02.View

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import Mobiel.TP03.ex02.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNome = findViewById<TextInputEditText>(R.id.etNome)
        val etTurma = findViewById<TextInputEditText>(R.id.etTurma)
        val btnAvancar = findViewById<MaterialButton>(R.id.btnAvancar)

        btnAvancar.setOnClickListener {
            val nome = etNome.text.toString()
            val turma = etTurma.text.toString()

            val intent = Intent(this, AlunoActivity::class.java)
            intent.putExtra("NOME", nome)
            intent.putExtra("TURMA", turma)
            startActivity(intent)
        }
    }
}