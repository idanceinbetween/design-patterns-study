package factory

// this interface is needed by the Animal Factory
interface Animal {
    fun speak()
    fun preferredAction()
}

class Tiger : Animal {
    override fun speak() {
        println("Tiger growls")
    }

    override fun preferredAction() {
        println("Tiger pounces")
    }
}

class Dog : Animal {
    override fun speak() {
        println("Dog barks")
    }

    override fun preferredAction() {
        println("Dog cuddles")
    }
}
