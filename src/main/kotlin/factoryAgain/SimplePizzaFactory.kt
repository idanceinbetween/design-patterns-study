package factoryAgain

// the only part of the code that refers to concrete pizza classes
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

// Pizza Factory is the one that knows about all sorts of Pizza (the product)
interface Pizza {
    fun prepare()
    fun bake()
    fun cut() {
        println("Cut into slices")
    }
    fun box() {
        println("Put in official PizzaStore box")
    }
}

open class CheesePizza : Pizza {
    override fun prepare() {
        println("Add some cheese")
    }

    override fun bake() {
        println("Put in oven for 15 mins for cheese to melt")
    }
}

open class GreekPizza : Pizza {
    override fun prepare() {
        println("Add some olives")
    }

    override fun bake() {
        println("Put in oven for 10 mins so olives don't burn")
    }
}

open class PepperoniPizza : Pizza {
    override fun prepare() {
        println("Add pepperoni with black pepper")
    }

    override fun bake() {
        println("Put in oven for 30 mins so meat is cooked")
    }
}

open class VeggiePizza : Pizza {
    override fun prepare() {
        println("Add some vege yum")
    }

    override fun bake() {
        println("Put in oven for 20 mins so vege is sightly burnt")
    }
}
