package com.diki.idn.calculatorapp

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private var result: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        one.setOnClickListener {
            evaluateExpression("1", true)
        }

        two.setOnClickListener {
            evaluateExpression("2", true)
        }

        three.setOnClickListener {
            evaluateExpression("3", true)
        }
        four.setOnClickListener {
            evaluateExpression("4", true)
        }

        five.setOnClickListener {
            evaluateExpression("5", true)
        }

        six.setOnClickListener {
            evaluateExpression("6", true)
        }

        seven.setOnClickListener {
            evaluateExpression("7", true)
        }

        eight.setOnClickListener {
            evaluateExpression("8", true)
        }

        nine.setOnClickListener {
            evaluateExpression("9", true)
        }

        zero.setOnClickListener {
            evaluateExpression("0", true)
        }
        plus.setOnClickListener {
            evaluateExpression("+", true)
        }

        minus.setOnClickListener {
            evaluateExpression("-", true)
        }

        multiply.setOnClickListener {
            evaluateExpression("*", true)
        }

        divide.setOnClickListener {
            evaluateExpression("/", true)
        }

        dot.setOnClickListener {
            evaluateExpression(".", true)
        }

        equals.setOnClickListener {
            try {

                val calculate = ExpressionBuilder(calculate.text.toString()).build()
                val result = calculate.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    tv_result.text = longResult.toString()
                else
                    tv_result.text = result.toString()

            } catch (e: Exception) {
                Log.d("Exception", " message : " + e.message)
            }
        }

        delete.setOnClickListener {
            val string = calculate.text.toString()
            if (string.isNotEmpty()) {
                calculate.text = string.substring(0, string.length - 1)
            }

            tv_result.setText(result.toString())
        }
    }

    fun evaluateExpression(string: String, clear: Boolean) {

        if (tv_result.text.isNotEmpty()) {
            calculate.text = ""
        }
        if (clear) {
            tv_result.text = ""
            calculate.append(string)
        } else {
            calculate.append(tv_result.text)
            calculate.append(string)
            tv_result.text = ""
        }
    }
}