package decorator

class Mocha(private var beverage: Beverage) : CondimentDecorator() {

    override var description: String = beverage.description + ", Mocha"

    override fun cost(): Double {
        return beverage.cost() + 0.20
    }
}

class SteamedMilk(private var beverage: Beverage) : CondimentDecorator() {

    override var description: String = beverage.description + ", Steamed milkd"

    override fun cost(): Double {
        return beverage.cost() + 0.10
    }
}

class Soy(private var beverage: Beverage) : CondimentDecorator() {

    override var description: String = beverage.description + ", Soy"

    override fun cost(): Double {
        return beverage.cost() + 0.15
    }
}

class Whip(private var beverage: Beverage) : CondimentDecorator() {

    override var description: String = beverage.description + ", Whip"

    override fun cost(): Double {
        return beverage.cost() + 0.10
    }
}
