package com.challenge.cp_02

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CalculadoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val valor1EditText: EditText = findViewById(R.id.valor1)
        val valor2EditText: EditText = findViewById(R.id.valor2)
        val operacoesRadioGroup: RadioGroup = findViewById(R.id.operacoes)
        val calcularButton: Button = findViewById(R.id.calcular)
        val buttonBack: Button = findViewById(R.id.buttonBack)

        calcularButton.setOnClickListener {
            val valor1String = valor1EditText.text.toString()
            val valor2String = valor2EditText.text.toString()

            if (valor1String.isEmpty() || valor2String.isEmpty()) {
                Toast.makeText(this, "Insira os dois valores!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val valor1 = valor1String.toDouble()
            val valor2 = valor2String.toDouble()

            val selectedOperationId = operacoesRadioGroup.checkedRadioButtonId
            if (selectedOperationId == -1) {
                Toast.makeText(this, "Selecione uma operação!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val resultado: Double = when (selectedOperationId) {
                R.id.soma -> valor1 + valor2
                R.id.subtracao -> valor1 - valor2
                R.id.multiplicacao -> valor1 * valor2
                R.id.divisao -> {
                    if (valor2 != 0.0) {
                        valor1 / valor2
                    } else {
                        Toast.makeText(this, "Divisão por zero não é permitida!", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }
                else -> 0.0
            }

            Toast.makeText(this, "Resultado: $resultado", Toast.LENGTH_LONG).show()
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }
}