package com.rahdeva.rmlegend

import RMLegend
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rahdeva.rmlegend.alphabet.AlphabetFragment
import com.rahdeva.rmlegend.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        if (savedInstanceState == null) {
            val listRMLegend = initializeRMLegendList()
            val alphabetFragment = AlphabetFragment.newInstance(listRMLegend)

            supportFragmentManager.beginTransaction()
                .add(R.id.alphabet_container, alphabetFragment)
                .commit()
        }
    }

    private fun initializeRMLegendList(): ArrayList<RMLegend> {
        return arrayListOf(
            RMLegend(
                letter = "A", legends = arrayOf(
                "Alfredo Di Stéfano",
                "Ángel Di María",
                "Ángel Pérez García",
                "Antonio Cassano",
                "Amancio Amaro"
            )),
            RMLegend(letter = "C", legends = arrayOf(
                "Clarence Seedorf",
                "Cristiano Ronaldo"
            )),
            RMLegend(letter = "D", legends = arrayOf(
                "Daniel Carvajal"
            )),
            RMLegend(letter = "F", legends = arrayOf(
                "Ferenc Puskás",
                "Fernando Hierro",
                "Fernando Redondo",
                "Fabio Cannavaro"
            )),
            RMLegend(letter = "G", legends = arrayOf(
                "Gareth Bale",
                "Gonzalo Higuaín",
                "Guti"
            )),
            RMLegend(letter = "H", legends = arrayOf(
                "Héctor Rial",
                "Hugo Sánchez"
            )),
            RMLegend(letter = "I", legends = arrayOf(
                "Iván Zamorano",
                "Iker Casillas"
            )),
            RMLegend(letter = "J", legends = arrayOf(
                "José Antonio Camacho",
                "Juanito"
            )),
            RMLegend(letter = "K", legends = arrayOf(
                "Karim Benzema",
                "Kaká"
            )),
            RMLegend(letter = "L", legends = arrayOf(
                "Luis Figo"
            )),
            RMLegend(letter = "M", legends = arrayOf(
                "Michel",
                "Marcelo Vieira da Silva",
                "Michel Salgado"
            )),
            RMLegend(letter = "P", legends = arrayOf(
                "Predrag Mijatović"
            )),
            RMLegend(letter = "R", legends = arrayOf(
                "Raúl González Blanco",
                "Roberto Carlos",
                "Raphaël Varane"
            )),
            RMLegend(letter = "S", legends = arrayOf(
                "Sergio Ramos",
                "Steve McManaman",
                "Sergio Reguilón"
            )),
            RMLegend(letter = "T", legends = arrayOf(
                "Toni Kroos"
            ))
        )
    }
}