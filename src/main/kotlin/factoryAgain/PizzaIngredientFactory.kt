package factoryAgain

interface PizzaIngredientFactory {
    fun createDough(): Dough
    fun createSauce(): Sauce
    fun createCheese(): Cheese
    fun createVeggies(): Array<Veggies>
    fun createPepperoni(): Pepperoni
    fun createClam(): Clam
}

interface Dough
interface Sauce
interface Cheese
interface Veggies
interface Pepperoni
interface Clam

class ThinCrustDough : Dough
class MarinaraSauce : Sauce
class ReggianoCheese : Cheese
class Garlic : Veggies
class Mushroom : Veggies
class SlicedPepperoni : Pepperoni
class FreshClam : Clam

class SourdoughDough : Dough
class ArrabbiataSauce : Sauce
class MozzarellaCheese : Cheese
class Olives : Veggies
class Aubergine : Veggies
class FrozenClam : Clam

class NYIngredientFactory : PizzaIngredientFactory {
    override fun createDough(): Dough {
        return ThinCrustDough()
    }

    override fun createSauce(): Sauce {
        return MarinaraSauce()
    }

    override fun createCheese(): Cheese {
        return ReggianoCheese()
    }

    override fun createVeggies(): Array<Veggies> {
        return arrayOf(Mushroom(), Garlic())
    }

    override fun createPepperoni(): Pepperoni {
        return SlicedPepperoni()
    }

    override fun createClam(): Clam {
        return FreshClam()
    }

}

class ItalianIngredientFactory: PizzaIngredientFactory {
    override fun createDough(): Dough {
        return SourdoughDough()
    }

    override fun createSauce(): Sauce {
        return ArrabbiataSauce()
    }

    override fun createCheese(): Cheese {
        return MozzarellaCheese()
    }

    override fun createVeggies(): Array<Veggies> {
        return arrayOf(Olives(), Aubergine())
    }

    override fun createPepperoni(): Pepperoni {
        return SlicedPepperoni()
    }

    override fun createClam(): Clam {
        return FrozenClam()
    }

}
