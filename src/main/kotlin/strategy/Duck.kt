package strategy

abstract class Duck() {
    // add two instance variables to the Duck class called flyBehavior and quackBehavior
    // Each duck object will set these variables polymorphically to reference the specific
    // behavior type it would like at runtime (FlyWithWings, Squeak, etc.).
    abstract var flyBehaviour: FlyBehaviour
    abstract var quackBehaviour: QuackBehaviour

    abstract fun display()
    fun performFly() {
        // delegated to behaviour class
        flyBehaviour.fly()
    }

    fun performQuack() {
        // delegated to behaviour class
        quackBehaviour.quack()
    }

    fun setFly(flyBehaviour: FlyBehaviour){
        this.flyBehaviour = flyBehaviour
    }

}

class MallardDuck : Duck() {
    override var flyBehaviour: FlyBehaviour = FlyRocketPower()
    override var quackBehaviour: QuackBehaviour = Quack()

    override fun display() {
        println("I'm a mallard duck")
    }
}

class RubberDuck : Duck() {
    override var flyBehaviour: FlyBehaviour = FlyNoWay()
    override var quackBehaviour: QuackBehaviour = MuteQuack()

    override fun display() {
        println("I'm a rubber duck")
    }

}
