package strategy

interface FlyBehaviour {
    fun fly()
}

class FlyWithWings : FlyBehaviour {
    override fun fly() {
        println("I'm flying")
    }
}

class FlyNoWay : FlyBehaviour {
    override fun fly() {
        println("I can't fly")
    }
}

class FlyRocketPower : FlyBehaviour {
    override fun fly() {
        println("Rocket-powered flying!")
    }

}

interface QuackBehaviour {
    fun quack()
}

class Quack : QuackBehaviour {
    override fun quack() {
        println("Quack")
    }
}

class MuteQuack : QuackBehaviour {
    override fun quack() {
        println("<< Silence >>")
    }
}

class Squeak : QuackBehaviour {
    override fun quack() {
        println("Squeak")
    }

}
