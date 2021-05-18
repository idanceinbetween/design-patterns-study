package observer

import java.lang.Thread.sleep
import kotlin.concurrent.thread
import kotlin.properties.Delegates

class Stock {
    // Stock (the subject) knows about the Observer Interface,
    // and it's the only thing it knows about the observer
    private var listOfListeners = mutableListOf<StockListener>()

    /*
    Alternative syntax:
    var value: Double by Delegates.observable(
        initialValue = 0.2,
        onChange = { prop, old, new ->
        listener?.onStockChange(new)
    })
    */
    // Is this meant to be here? Seems like the subject now also knows about the observers' method
    // Also seems quite messy to have the instance variable declared and observed
    private var value: Double by Delegates.observable(0.0) { _, _, newValue ->
        listOfListeners.map { listener -> listener.onStockChange(newValue) }
    }

    fun registerListener(listener: StockListener) {
        listOfListeners.add(listener)
        println("Registered a stock listener $listener as observer")
    }

    fun removeLastListener() {
        listOfListeners.removeLast()
        println("Removed the last added stock listener as observer")
    }

    fun runTwice() {
        thread(start = true) {
            for (i in 1..2) {
                sleep(2000)
                generatePrice()
            }
        }
    }

    fun runForever() {
        thread(start = true) {
            while (true) {
                sleep(2000)
                generatePrice()
            }
        }
    }

    private fun generatePrice() {
        value = Math.random()
        println("[Stock] Latest stock value is $value")
    }
}
