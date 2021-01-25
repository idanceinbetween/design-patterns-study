package factoryAgain

class NYStylePizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza {
        return when (type) {
            "cheese" -> NYCheesePizza()
            "greek" -> NYGreekPizza()
            "pepperoni" -> NYPepperoniPizza()
            "veggie" -> NYVeggiePizza()
            else -> throw RuntimeException("specified pizza [$type] is unavailable")
        }
    }

    class NYCheesePizza : CheesePizza()
    class NYGreekPizza : GreekPizza()
    class NYPepperoniPizza : PepperoniPizza()
    class NYVeggiePizza : VeggiePizza()
}

class ItalianStylePizzaStore : PizzaStore() {
    override fun createPizza(type: String): Pizza {
        return when (type) {
            "cheese" -> ItalianCheesePizza()
            "greek" -> throw RuntimeException("Non capisco!")
            "pepperoni" -> ItalianPepperoniPizza()
            "veggie" -> ItalianVeggiePizza()
            else -> throw RuntimeException("sold out")
        }
    }

    class ItalianCheesePizza : CheesePizza() {
        override fun prepare() {
            println("Add some special Italian Mozzarella cheese")
        }
    }

    class ItalianPepperoniPizza : PepperoniPizza() {
        override fun prepare() {
            println("Add some special pepperoni")
        }
    }

    class ItalianVeggiePizza : VeggiePizza()
}

