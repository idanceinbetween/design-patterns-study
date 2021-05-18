package observer

class NormalDisplayStockListener : StockListener {
    override fun onStockChange(newValue: Double) {
        println("Normal display is displaying new stock value: [$newValue]")
    }
}

class LEDScreenStockListener : StockListener {
    override fun onStockChange(newValue: Double) {
        println("LED Screen is showing a glowing stock value of [$newValue]")
    }
}

interface StockListener {
    fun onStockChange(newValue: Double)
}
