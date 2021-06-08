package decorator

fun runDecorator() {
    val beverage1: Beverage = Espresso()
    println("${beverage1.description} $${beverage1.cost()}")

    /*
     Decorators are typically created by using other patterns
     like Factory and Builder, instead of being so hand-cranked
     */
    var beverage2: Beverage = DarkRoast()
    beverage2 = Mocha(beverage2)
    beverage2 = Mocha(beverage2)
    beverage2 = Whip(beverage2)
    println("${beverage2.description} $${beverage2.cost()}")

    var beverage3: Beverage = HouseBlend()
    beverage3 = Soy(beverage3)
    beverage3 = Mocha(beverage3)
    beverage3 = Whip(beverage3)
    println("${beverage3.description} $${beverage3.cost()}")
}
