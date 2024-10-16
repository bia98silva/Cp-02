package com.challenge.cp_02


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val calculatorButton: Button = findViewById(R.id.calculatorButton)
        val phoneBillButton: Button = findViewById(R.id.phoneBillButton)
        val studentButton: Button = findViewById(R.id.studentButton)

        calculatorButton.setOnClickListener {
            val intent = Intent(this, CalculadoraActivity::class.java)
            startActivity(intent)
        }

        phoneBillButton.setOnClickListener {
            val intent = Intent(this, ContaTelefonicaActivity::class.java)
            startActivity(intent)
        }

        studentButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Desenvolvido por")
            builder.setMessage(
                "Beatriz Silva\nRM: 552600\n\n" +
                        "Pedro Henrique Soares Araujo\nRM: 55380"
            )
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }
}
