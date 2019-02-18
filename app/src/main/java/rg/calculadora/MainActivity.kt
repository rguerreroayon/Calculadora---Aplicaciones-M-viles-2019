package rg.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numeros
        tvZero.setOnClickListener{appendOnExpression("0",true)}
        tvOne.setOnClickListener{appendOnExpression("1",true)}
        tvTwo.setOnClickListener{appendOnExpression("2",true)}
        tvThree.setOnClickListener{appendOnExpression("3",true)}
        tvFour.setOnClickListener{appendOnExpression("4",true)}
        tvFive.setOnClickListener{appendOnExpression("5",true)}
        tvSix.setOnClickListener{appendOnExpression("6",true)}
        tvSeven.setOnClickListener{appendOnExpression("7",true)}
        tvEight.setOnClickListener{appendOnExpression("8",true)}
        tvNine.setOnClickListener{appendOnExpression("9",true)}


        //Operadores
        tvPlus.setOnClickListener{appendOnExpression("+",false)}
        tvMinus.setOnClickListener{appendOnExpression("-",false)}
        tvDividir.setOnClickListener{appendOnExpression("/",false)}
        tvMult.setOnClickListener{appendOnExpression("*",false)}
        tvParaAbrir.setOnClickListener{appendOnExpression("(",false)}
        tvParaCerrar.setOnClickListener{appendOnExpression(")",false)}


        //Para limpiar
        tvClear.setOnClickListener{
            tvResultado.text = ""
            tvExpression.text = ""
        }


        //Resultado
        tvEquals.setOnClickListener{
            try{
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble()) {
                    tvResultado.text = longResult.toString()
                }else
                    tvResultado.text = result.toString()



            }catch(E:Exception){
                   Log.d("Excepcion","valiomale")
            }



        }
    }

    fun appendOnExpression(valor:String, sePuede:Boolean){
        if(tvResultado.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if(sePuede){
            tvResultado.text = ""
            tvExpression.append(valor)
        }else{
            tvExpression.append(tvResultado.text)
            tvExpression.append(valor)
            tvResultado.text = ""
        }


    }

}
