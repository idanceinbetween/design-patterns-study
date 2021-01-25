package factoryAgain

class PizzaStore {
    fun orderPizza(type: String): Pizza {
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

        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()

        return pizza
    }
}

interface Pizza {
    fun prepare()
    fun bake()
    fun cut()
    fun box()
}

class CheesePizza : Pizza {
    override fun prepare() {
        TODO("Not yet implemented")
    }

    override fun bake() {
        TODO("Not yet implemented")
    }

    override fun cut() {
        TODO("Not yet implemented")
    }

    override fun box() {
        TODO("Not yet implemented")
    }
}

class GreekPizza : Pizza {
    override fun prepare() {
        TODO("Not yet implemented")
    }

    override fun bake() {
        TODO("Not yet implemented")
    }

    override fun cut() {
        TODO("Not yet implemented")
    }

    override fun box() {
        TODO("Not yet implemented")
    }
}

class PepperoniPizza : Pizza {
    override fun prepare() {
        TODO("Not yet implemented")
    }

    override fun bake() {
        TODO("Not yet implemented")
    }

    override fun cut() {
        TODO("Not yet implemented")
    }

    override fun box() {
        TODO("Not yet implemented")
    }
}

class VeggiePizza : Pizza {
    override fun prepare() {
        TODO("Not yet implemented")
    }

    override fun bake() {
        TODO("Not yet implemented")
    }

    override fun cut() {
        TODO("Not yet implemented")
    }

    override fun box() {
        TODO("Not yet implemented")
    }
}
