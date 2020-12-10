package Prototype

import com.google.gson.Gson

// Data class in Kotlin comes with the copy() function.
// When used, an object is copied with its properties unchanged,
// but can also change if we want to!
// Creates a shallow copy
data class Nano(val color: String, val price: Int, var bidders: List<String>)

val nanoOg = Nano("Green", 200, listOf("Bob, Marlene, Astra"))

fun runPrototype() {
    val ripOffNano = createCopy(nanoOg)

    println("Comparing Color [RipOffNano vs NanoOG] : ${ripOffNano.color} VS ${nanoOg.color}")
    println("Comparing Bidders [RipOffNano vs NanoOG] : ${ripOffNano.bidders} VS ${nanoOg.bidders}")

    val slightlyDifferentNano = nanoOg.copy(color = "Red")

    println("Comparing Color [SlightlyDifferentNano vs NanoOG] : ${slightlyDifferentNano.color} VS ${nanoOg.color}")
    println("Comparing Bidders [SlightlyDifferentNano vs NanoOG] : ${slightlyDifferentNano.bidders} VS ${nanoOg.bidders}")
}

fun createCopy(nanoThing: Nano): Nano {
    return nanoThing.copy()
}

fun createDeepCopy(nanoThing: Nano): Nano {
    val JSON = Gson().toJson(nanoThing)
    return Gson().fromJson(JSON, Nano::class.java)
}
