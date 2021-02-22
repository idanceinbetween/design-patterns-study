package strategy

fun runStrategy() {
    val mallard = MallardDuck()
    mallard.display()
    mallard.performQuack()
    mallard.performFly()

    val rubber = RubberDuck()
    rubber.display()
    rubber.performFly()
    rubber.setFly(FlyWithWings())
    rubber.performFly()
}
