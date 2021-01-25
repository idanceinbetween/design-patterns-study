package factoryAgain

// the client of the factory
class PizzaStore(private val simplePizzaFactory: SimplePizzaFactory) {
    fun orderPizza(type: String): Pizza {

        // Use a factory to replace the instantiation of concrete classes
        val pizza = simplePizzaFactory.createPizza(type)

        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()

        return pizza
    }
}

// The Pizza Store no longer needs to know the ins and outs of Pizza types
