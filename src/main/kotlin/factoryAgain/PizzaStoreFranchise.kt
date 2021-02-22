package factoryAgain

class NYStylePizzaStore : PizzaStore() {
    private lateinit var pizza: Pizza

    override fun createPizza(type: String): Pizza {
        when (type) {
            "cheese" -> {
                pizza = NYCheesePizza()
                pizza.name = "New York Cheese Pizza"
            }
            "greek" -> {
                pizza = NYGreekPizza()
                pizza.name = "New York Greek Pizza"
            }
            "pepperoni" -> {
                pizza = NYPepperoniPizza()
                pizza.name = "New York Pepperoni Pizza"
            }
            "veggie" -> {
                pizza = NYVeggiePizza()
                pizza.name = "New York Veggie Pizza"
            }
            else -> throw RuntimeException("specified pizza [$type] is unavailable")
        }
        return pizza
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

