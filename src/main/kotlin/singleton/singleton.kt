package singleton

// Kotlin has made creating Singletons easy
// Object declaration's initialization is thread-safe and done at first access
// Objects can’t have a constructor
object Captain {
    fun getName(): String {
        return "Hey Ho I'm the only Captain"
    }
}

// This is a standard Kotlin class
class CaptainClass(val name: String)

// This is a Kotlin class specially made with a private constructor
class SecretCaptain private constructor(val name: String) {
    companion object {
        fun secretConstructor(name: String): SecretCaptain {
            return SecretCaptain(name)
        }
    }
}

fun runSingleton() {

    // An object that doesn't need initialisation because Kotlin made it easy
    val firstCaptain = Captain

    // Normal class
    val secondCaptain = CaptainClass("Barbara")
    val thirdCaptain = CaptainClass("Charlie")

    // Doesn't compile as constructor is private
    // val fourthCaptain = SecretCaptain("Harriet")

    // Can be constructed multiple times if you know the secret constructor
    val fifthCaptain = SecretCaptain.secretConstructor("secret Sarah")
    val sixthCaptain = SecretCaptain.secretConstructor("secret Susan")

    checkType(firstCaptain)
    checkType(secondCaptain)
    checkType(thirdCaptain)
//    checkType(fourthCaptain)
    checkType(fifthCaptain)
    checkType(sixthCaptain)
}

fun checkType(obj: Any) {
    when (obj) {
        is Captain -> println("It is the only Captain and getMyName: ${obj.getName()}")
        is CaptainClass -> println("It is one of the Captains and here's my .name ${obj.name}")
        is SecretCaptain -> println("I'm a secret captain and my name is ${obj.name}")
        else -> println("I don't know which captain you are :( Please show me: $obj")
    }
}
