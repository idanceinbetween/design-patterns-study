package observer

fun runObserver() {
    // create the subject (observable)
    val stock = Stock()

    with(stock) {
        // we register observer(s) with subject
        registerListener(NormalDisplayStockListener())
        registerListener(LEDScreenStockListener())

        // the subject goes about its day
        runTwice()

        // We remove observer(s) as we wish during runtime
        // (but couldn't demo as it's on a different thread!)
        // removeLastListener()

        // the subject goes about its day
        runForever()
    }
}
