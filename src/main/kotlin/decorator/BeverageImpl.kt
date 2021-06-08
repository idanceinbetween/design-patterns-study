package decorator

//Concrete components implementing Abstract Component class
class Espresso : Beverage() {
    override var description: String = "Espresso"

    override fun cost(): Double {
        return 1.99
    }
}

class HouseBlend : Beverage() {
    override var description: String = "House Blend"

    override fun cost(): Double {
        return 0.89
    }
}

class Decaf : Beverage() {
    override var description: String = "Decaf"

    override fun cost(): Double {
        return 1.05
    }
}

class DarkRoast : Beverage() {
    override var description: String = "Dark Roast"

    override fun cost(): Double {
        return 0.99
    }
}
