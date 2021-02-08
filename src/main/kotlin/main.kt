import strategy.FlyWithWings
import strategy.MallardDuck
import strategy.RubberDuck

fun main() {
//    runSingleton()
//    runPrototype()
//    runFactory("dog")
//    orderPizzaFromAPizzaStoreFranchise("cheese", "Italy")
//    orderPizzaFromAPizzaStoreFranchise("pepperoni", "New York")

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
