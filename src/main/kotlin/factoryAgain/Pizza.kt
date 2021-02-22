package factoryAgain

// Pizza Factory is the one that knows about all sorts of Pizza (the product)
abstract class Pizza {
    lateinit var name: String
    lateinit var dough : Dough
    lateinit var sauce: Sauce
    lateinit var veggies: Veggies
    lateinit var cheese: Cheese
    lateinit var pepperoni: Pepperoni
    lateinit var clam: Clam

    abstract fun prepare()

    fun bake() {
        println("Bake for 25 minutes at 350")
    }
    fun cut() {
        println("Cut into slices")
    }
    fun box() {
        println("Put in official PizzaStore box")
    }
}

open class CheesePizza : Pizza() {
    private lateinit var ingredientFactory: PizzaIngredientFactory

    override fun prepare() {
        println("Preparing $name")
        ingredientFactory.createDough()
        ingredientFactory.createSauce()
        ingredientFactory.createCheese()
    }
}

open class GreekPizza : Pizza() {
    override fun prepare() {
        println("Add some olives")
    }
}

open class PepperoniPizza : Pizza() {
    override fun prepare() {
        println("Add pepperoni with black pepper")
    }
}

open class VeggiePizza : Pizza() {
    override fun prepare() {
        println("Add some vege yum")
    }
}
