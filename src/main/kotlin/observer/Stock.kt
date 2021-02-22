package observer

import java.lang.Math.random
import java.lang.Thread.sleep
import kotlin.concurrent.thread

class Stock {
    // this is terrible as if we want to add other displays,
    // they have to be added to the stock class,
    // violating the open closed principle
    private var normalDisplay: NormalDisplay? = null
    fun setNormalDisplay(givenDisplay: NormalDisplay){
        normalDisplay = givenDisplay
    }

    private fun generatePrice() {
        while (true) {
            sleep(1000)
            normalDisplay?.display(random())
        }
    }

    fun start() {
        thread(start = true) {
            generatePrice()
        }
    }
}
