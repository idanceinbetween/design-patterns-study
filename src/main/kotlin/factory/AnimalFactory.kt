package factory

fun runFactory(option: String) {
    // val makeAnimal: Animal = AnimalFactory().makeAnimal() //cannot create an instance of an abstract class [1]
    when (option) {
        "dog" -> {
            val dogFactoryOutput = DogFactory()
            dogFactoryOutput.oozeCuteness()
            dogFactoryOutput.makeAnimal() // makeAnimal is a function in abstractClass AnimalFactory, not DogFactory
        }
        "tiger" -> {
            TigerFactory().makeAnimal()
            // TigerFactory().oozeCuteness() // TigerFactory did not implement BabyAnimals!
        }
        "duck" -> DuckFactory().makeAnimal()
        else -> throw RuntimeException("Pick a dog or tiger!")
    }
}

abstract class AnimalFactory {
    fun makeAnimal(): Animal { // Animal is an interface
        println("Creating an animal in an Animal Factory")
        val animal = createAnimal() // deferring instantiation to a subclass
        println("Animal Factory asking created animal - the 'product' - to speak and act")
        animal.speak() // this method is overridden by the class that extends Animal
        animal.preferredAction()
        // hunt() doesn't work because it is a method of an interface that only the Tiger
        // (an extension of the Animal abstract class) implements. Dog, even though extends an Animal,
        // does not implement this interface.
        // animal.hunt()
        return animal
    }

    abstract fun createAnimal(): Animal // an unimplemented method that MUST be overridden by the class extended AnimalFactory
}

interface BabyAnimals {
    fun oozeCuteness() {
        println("baby animals are cute")
    }
}

// DogFactory extends abstract class AnimalFactory and implements BabyAnimals
class DogFactory : AnimalFactory(), BabyAnimals {
    override fun createAnimal(): Dog {
        println("subclass DuckFactory instantiating")
        return Dog()
    }
}

class TigerFactory : AnimalFactory() {
    override fun createAnimal(): Tiger {
        println("subclass TigerFactory instantiating")
        return Tiger()
    }
}

class DuckFactory : AnimalFactory() {
    override fun createAnimal(): Duck {
        println("subclass DuckFactory instantiating")
        val duck = Duck()
        duck.swims() // this is an implemented method
        return duck
    }
}
