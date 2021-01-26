package factoryAgain

// the only part of the code that refers to concrete pizza classes before the PizzaStore went franchising!
class SimplePizzaFactory {
    fun createPizza(type: String): Pizza {
        lateinit var pizza: Pizza
        // new-ing things up during runtime.
        // if we need other pizzas we have to change this section of code
        // even though the rest of the code stays the same
        // i.e. code is not closed for modification
        when (type) {
            "cheese" -> pizza = CheesePizza()
            "greek" -> pizza = GreekPizza()
            "pepperoni" -> pizza = PepperoniPizza()
            "veggie" -> pizza = VeggiePizza()
        }
        return pizza
    }
}

