package factory

// this interface is needed by the Animal Factory
interface Animal {
    fun speak()
    fun preferredAction()
}

interface Carnivore {
    // unimplemented method
    fun hunt()
}

interface Bird {
    // implemented method
    fun swims() {
        println("This bird swims")
    }
}

// Tiger implements two interfaces: Animal and Carnivore
class Tiger : Animal, Carnivore {
    override fun speak() {
        println("Tiger growls")
    }

    override fun preferredAction() {
        println("Tiger pounces")
    }

    // overrides the unimplemented method
    override fun hunt() {
        println("Tiger hunts")
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

class Duck : Animal, Bird {
    // can swim because swim() method was implemented by the interface
    override fun speak() {
        println("Duck quacks")
    }

    override fun preferredAction() {
        println("Duck chases each other")
    }
}
