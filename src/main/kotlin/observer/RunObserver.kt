package observer

fun runObserver() {
    val stock = Stock()
    stock.start()

    val display = NormalDisplay()
    stock.setNormalDisplay(display)
}
