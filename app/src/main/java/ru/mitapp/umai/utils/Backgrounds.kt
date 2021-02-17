package ru.mitapp.umai.utils

import ru.mitapp.umai.R
import java.util.*
import kotlin.collections.ArrayList

object Backgrounds {

    var lastItem = -1
    private var bagroundList = ArrayList<Int>()

    init {
        fillBackgroundList()
    }

    private fun fillBackgroundList(){
        bagroundList.add(R.drawable.bg_blue_r10)
        bagroundList.add(R.drawable.bg_red_r10)
        bagroundList.add(R.drawable.bg_green_r10)
        bagroundList.add(R.drawable.bg_orange_r10)
        bagroundList.add(R.drawable.bg_primary_r10)
        bagroundList.add(R.drawable.bg_primary_dark_r10)
        bagroundList.add(R.drawable.bg_pag_r10)
    }

    private fun getRandomItemFromList(): Int {

        val randomValue = Random().nextInt(bagroundList.size)

        return if (randomValue != lastItem) {
            lastItem = randomValue
            randomValue
        } else {
            getRandomItemFromList()
        }

    }


    fun getRandomBackground() : Int{
        return bagroundList[getRandomItemFromList()]
    }

}