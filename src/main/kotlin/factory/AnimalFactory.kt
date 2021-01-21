package factory

fun runFactory(option: String) {
    println("Client code asked for a [$option] to be created")
    println("Try and change this to Tiger or Duck and see the differences")
    // val makeAnimal: Animal = AnimalFactory().makeAnimal() //cannot create an instance of an abstract class
    when (option) {
        "dog" -> {
            println("Calling Dog Factory")
            val dogFactory = DogFactory()
            dogFactory.orchestrateCreation() // orchestrateCreation is a function in abstract class AnimalFactory, not DogFactory
            dogFactory.saleOn() // DogFactory extends abstract class AnimalFactory and implements Shop
        }
        "tiger" -> {
            TigerFactory().orchestrateCreation()
            // TigerFactory().saleOn() // TigerFactory did not implement Shop!
        }
        "duck" -> DuckFactory().orchestrateCreation()
        else -> throw RuntimeException("Pick a dog, tiger or duck!")
    }
}

// here the AnimalFactory is an abstract class
// however it does not have to be strictly the case.
// There could be a default factory method if the
// creator has no subclasses, in which case it cannot be
// an abstract class.
abstract class AnimalFactory {
    fun orchestrateCreation(): Animal { // Animal is an interface
        println("Orchestrating creation in Animal Factory following a client request received by a subclass Factory")
        val animal = createAnimal() // deferring instantiation to a subclass
        println("Animal Factory asking created animal (the 'product') to speak and act")
        animal.speak() // this method is overridden by the class that extends Animal
        animal.preferredAction()
        // hunt() doesn't work because it is a method of an interface that only the Tiger
        // (an extension of the Animal abstract class) implements. Dog, even though extends an Animal,
        // does not implement this interface.
//         animal.hunt()
        return animal
    }

    abstract fun createAnimal(): Animal // an unimplemented method that MUST be overridden by the class extended AnimalFactory
}

interface Shop {
    fun saleOn() {
        println("By the way, this subclass Factory implemented a Shop interface, and there's a sale!")
    }
}

// DogFactory extends abstract class AnimalFactory and implements Shop
class DogFactory : AnimalFactory(), Shop {
    override fun createAnimal(): Dog {
        println("subclass DogFactory instantiated and created a Dog with createAnimal")
        return Dog()
    }
}

class TigerFactory : AnimalFactory() {
    override fun createAnimal(): Tiger {
        println("subclass TigerFactory instantiated and created a Tiger with createAnimal")
        return Tiger()
    }
}

class DuckFactory : AnimalFactory() {
    override fun createAnimal(): Duck {
        println("subclass DuckFactory instantiated and created a Duck with createAnimal")
        val duck = Duck()
        println("By the way the Duck is also a Bird")
        duck.swims() // this is an implemented method in the interface Bird that Duck implements
        return duck
    }
}
