package com.challenge.cp_02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ContaTelefonicaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conta_telefonica)

        val valorEditText: EditText = findViewById(R.id.editText_valor)
        val localEditText: EditText = findViewById(R.id.editText_local)
        val celularEditText: EditText = findViewById(R.id.editText_celular)
        val calcularButton: Button = findViewById(R.id.button_calcular)
        val buttonBack: Button = findViewById(R.id.buttonBack)

        calcularButton.setOnClickListener {
            val valorAssinatura = valorEditText.text.toString().toDouble()
            val minutosLocal = localEditText.text.toString().toDouble()
            val minutosCelular = celularEditText.text.toString().toDouble()

            val valorLocal = minutosLocal * 0.04
            val valorCelular = minutosCelular * 0.20
            val total = valorAssinatura + valorLocal + valorCelular

            val intent = Intent(this, ResultadoActivity::class.java).apply {
                putExtra("VALOR_ASSINATURA", valorAssinatura)
                putExtra("VALOR_LOCAL", valorLocal)
                putExtra("VALOR_CELULAR", valorCelular)
                putExtra("TOTAL", total)
            }

            startActivity(intent)
        }

        buttonBack.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Confirmar")
                .setMessage("Você realmente deseja voltar?")
                .setPositiveButton("Sim") { dialog, which ->
                    finish()
                }
                .setNegativeButton("Não", null)
                .show()
        }
    }
}
