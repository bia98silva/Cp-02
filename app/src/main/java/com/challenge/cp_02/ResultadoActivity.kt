package com.challenge.cp_02

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val assinatura = intent.getDoubleExtra("VALOR_ASSINATURA", 0.0)
        val chamadaLocal = intent.getDoubleExtra("VALOR_LOCAL", 0.0)
        val chamadaCelular = intent.getDoubleExtra("VALOR_CELULAR", 0.0)
        val total = intent.getDoubleExtra("TOTAL", 0.0)

        val resultadoTextView: TextView = findViewById(R.id.resultadoTextView)
        val buttonBack: Button = findViewById(R.id.buttonBack) // Adicionando o botão de voltar

        val resultadoTexto = """
            Assinatura       : R$ ${"%.2f".format(assinatura)}
            Chamada Local    : R$ ${"%.2f".format(chamadaLocal)}
            Chamada Celular  : R$ ${"%.2f".format(chamadaCelular)}
            
            Total            : R$ ${"%.2f".format(total)}
        """.trimIndent()

        resultadoTextView.text = resultadoTexto

        buttonBack.setOnClickListener {
            showExitConfirmation()
        }
    }

    private fun showExitConfirmation() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmar")
        builder.setMessage("Você realmente deseja voltar?")
        builder.setPositiveButton("Sim") { _, _ -> finish() }
        builder.setNegativeButton("Não", null)
        builder.show()
    }
}
