package android.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Atribui uma variável ao botão
        val rollButton: Button = findViewById(R.id.bottom)

        //configura o ButtonView para informar o lado do dado sorteado
        rollButton.setOnClickListener { rollDice() }
        // Mostra um valor inicial ao iniciar o aplicativo
        rollDice()
    }

    //  função privada para rolar o dado
    private fun rollDice() {
        //Cria uma instância de um dado de seis lados
        val dice = Dice(6)
        //Atribui a variável, o valor resultado do rotina random
        val diceRoll = dice.roll()
        //Atribui a imagemView escolhida no sistema
        val diceImage: ImageView = findViewById(R.id.image)

        //Rotina para determinar qual será a image exibida
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        //atualizar a figura do dado sorteado
        //diceImage.setImageResource(DrawableResorce)
        // atualiza o conteudo de acessibilidade do jogo
        diceImage.contentDescription = diceRoll.toString()

    }
}

//Classe para criação do objeto "dado""
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}



