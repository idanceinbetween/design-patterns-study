package decorator

// Abstract Component class is implemented by Concrete Component and Decorator
abstract class Beverage {

    open var description: String = ""

    abstract fun cost(): Double
}
