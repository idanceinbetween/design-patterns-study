package factory

fun runFactory() {
    // val makeAnimal: Animal = AnimalFactory().makeAnimal() //cannot create an instance of an abstract class
    DogFactory().makeAnimal() // makeAnimal is a function in AnimalFactory, not DogFactory
    TigerFactory().makeAnimal()
}

abstract class AnimalFactory {
    fun makeAnimal(): Animal {
        println("Creating an animal in an Animal Factory")
        val animal = createAnimal() // deferring instantiation to a subclass
        println("Animal Factory asking created animal to speak and act")
        animal.speak()
        animal.preferredAction()
        return animal
    }

    abstract fun createAnimal(): Animal
}

class DogFactory : AnimalFactory() {
    override fun createAnimal(): Dog {
        println("subclass DogFactory instantiating")
        return Dog()
    }
}

class TigerFactory : AnimalFactory() {
    override fun createAnimal(): Tiger {
        println("subclass TigerFactory instantiating")
        return Tiger()
    }
}
