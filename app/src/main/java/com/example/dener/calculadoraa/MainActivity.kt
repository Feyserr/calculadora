package com.example.dener.calculadoraa

import android.content.DialogInterface
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.view.Gravity
import android.widget.Switch
import android.widget.TextView
import com.example.dener.calculadoraa.R.id.result
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btigual.setOnClickListener(){
            result.setTextColor(Color.parseColor("#000000"))
            result.text = handleOperator(result.text.toString())

            }
        bt1.setOnClickListener {
            result.text = result.text.toString()+"1"
        }
        bt2.setOnClickListener {
            result.text = result.text.toString()+"2"
        }
        bt3.setOnClickListener {
            result.text = result.text.toString()+"3"
        }
        bt4.setOnClickListener {
            result.text = result.text.toString()+"4"
        }
        bt5.setOnClickListener {
            result.text = result.text.toString()+"5"
        }
        bt6.setOnClickListener {
            result.text = result.text.toString()+"6"
        }
        bt7.setOnClickListener {
            result.text = result.text.toString()+"7"
        }
        bt8.setOnClickListener {
            result.text = result.text.toString()+"8"
        }
        bt9.setOnClickListener {
            result.text = result.text.toString()+"9"
        }
        bt0.setOnClickListener {
            result.text = result.text.toString()+"0"
        }
        btsoma.setOnClickListener {
            result.text = result.text.toString()+"+"
        }
        btsub.setOnClickListener {
            result.text = result.text.toString()+"-"
        }
        btmult.setOnClickListener {
            result.text = result.text.toString()+"x"
        }
        btdiv.setOnClickListener {
            result.text = result.text.toString()+"%"
        }
        btcle.setOnClickListener {
            result.text = ""
        }
        btponto.setOnClickListener(){
            result.text = result.text.toString()+"."
        }
    }

        fun handleOperator(entrada: String): String {
            var valor1: String = ""
            var valor2: String = ""
            var operador: String = ""
            var saida: String = ""

            if (entrada[0].toString().toFloatOrNull() === null) {
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setTitle("Operação Inválida")
                builder.setMessage("Por Favor, digite uma operação válida.")
                builder.setPositiveButton("Ok"){ dialogInterface: DialogInterface, i: Int -> }
                val dialog: AlertDialog = builder.create()
                dialog.show()

                return ""
            }
            for (i in entrada) {
                if ((valor1 + i.toString()).toFloatOrNull() !== null && operador === "") {
                    valor1 = valor1 + i
                } else if (operador === "") {
                    operador = i.toString()
                } else {
                    valor2 = valor2 + i
                }
            }

            if(valor2[0].toString().toFloatOrNull() !== null && valor2.toFloatOrNull() !== null) {

                    when (operador) {
                        "+" -> saida = soma(valor1.toFloat(), valor2.toFloat()).toString()
                        "-" -> saida = sub(valor1.toFloat(), valor2.toFloat()).toString()
                        "x" -> saida = mult(valor1.toFloat(), valor2.toFloat()).toString()
                        "%" -> saida = div(valor1.toFloat(), valor2.toFloat()).toString()
                        "." -> saida = ponto(valor1.toFloat(), valor2.toFloat()).toString()
                        else -> saida = "Operação Inválida"
                    }
                } else {
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setTitle("Operação Inválida ")
                builder.setMessage("Por Favor, digite uma operação válida.")
                builder.setPositiveButton("Ok"){ dialogInterface: DialogInterface, i: Int -> }
                val dialog: AlertDialog = builder.create()
                dialog.show()
                return ""
                }

                return saida
            }
        }
    fun soma(value1:Float, value2: Float): Float {
        return value1 + value2
    }

    fun sub(value1: Float, value2: Float): Float{
        return value1 - value2
}

    fun mult(value1: Float, value2: Float): Float{
        return value1 * value2
    }

    fun div(value1: Float, value2: Float): Float{
        return value1 / value2
    }

    fun ponto(value1: Float, value2: Float): Float{
        return value1;value2
    }






















