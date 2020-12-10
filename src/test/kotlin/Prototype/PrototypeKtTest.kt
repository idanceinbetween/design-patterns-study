package Prototype

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrototypeKtTest {

    private val originalBidders = listOf("UK", "US")
    private val originalBiddersMutable = mutableListOf("UK", "US")
    private val newBidders = listOf("UK", "US", "Germany")

    @Test
    fun `createCopy should create a shallow copy, pointing to the same reference object`() {
        val nano = Nano("Red", 2040, originalBiddersMutable)
        val nanoCopy = createCopy(nano)
        assertEquals(originalBiddersMutable, nanoCopy.bidders)

        originalBiddersMutable.add("Germany")

        assertEquals(originalBiddersMutable, nanoCopy.bidders)
    }

    @Test
    fun `createDeepCopy should create a deep copy, also cloning the referenced object of the original`() {
        val nano = Nano("Red", 2040, originalBiddersMutable)
        val nanoCopy = createDeepCopy(nano)
        assertEquals(originalBiddersMutable, nanoCopy.bidders)

        originalBiddersMutable.add("Germany")
        assertEquals(newBidders, originalBiddersMutable)
        assertEquals(originalBidders, nanoCopy.bidders)
    }

    @Test
    fun `createCopy should create a shallow copy`() {
        val nano = Nano("Red", 2040, originalBidders)
        val nanoCopy = createCopy(nano)
        assertEquals(originalBidders, nanoCopy.bidders)

        nano.bidders = newBidders

        assertEquals(originalBidders, nanoCopy.bidders)
    }
}
