package factoryAgain

// Cookie cutter of the pizza store, awaiting for subclasses
abstract class PizzaStore {

    // defined in the abstract PizzaStore,
    // so the method doesn't know which
    // subclass is actually calling it
    fun orderPizza(type: String): Pizza {

        // calling createPizza method, but
        // it doesn't know what product type
        // is being created - this is decided
        // by the concrete PizzaStore.
        // It doesn't care anyway as long as it gets
        // a pizza to prepare, bake, cut and box.
        val pizza: Pizza = createPizza(type)

        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()

        return pizza
    }

    // Factory method is now abstract in Pizza Store
    // no need to implement this now
    abstract fun createPizza(type: String): Pizza
}

fun orderPizzaFromAPizzaStoreFranchise(pizzaType: String, location: String): Pizza {
    println("Received order for a [$pizzaType] pizza from Pizza Store franchise located in [$location]")

    val pizzaStore = when (location) {
        "Italy" -> ItalianStylePizzaStore()
        "New York" -> NYStylePizzaStore()
        else -> throw RuntimeException("We're not open there yet!")
    }

    return pizzaStore.orderPizza(pizzaType)

}
