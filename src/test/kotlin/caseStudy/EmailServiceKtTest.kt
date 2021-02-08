package caseStudy

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import org.junit.jupiter.api.Test

class EmailServiceKtTest {
    private val emailService = EmailService()

    @Test
    fun `creates an email for repeat customer at market`() {
        val location = "Market"
        val customer = Customer()
        customer.existInDatabase = true

        val emailCreated = emailService.createEmail(location, customer)

        assertThat(emailCreated.url).isEqualTo("Sign in")
        assertThat(emailCreated.subject).isEqualTo("Glad to see you again at the market")
    }

    @Test
    fun `creates an email for new customer met at market with tracking parameters`() {
        val location = "Market"
        val customer = Customer()

        val emailCreated = emailService.createEmail(location, customer)

        assertThat(emailCreated.url).isEqualTo("Sign up")
        assertThat(emailCreated.subject).isEqualTo("Sign up to get updates on your market purchase")
        assertThat(emailCreated.trackingCampaign).isEqualTo("Will they sign up?")
    }

    @Test
    fun `creates an email for repeat customer at exhibition`() {
        val location = "Exhibition"
        val customer = Customer()
        customer.existInDatabase = true

        val emailCreated = emailService.createEmail(location, customer)

        assertThat(emailCreated.url).isEqualTo("Sign in")
        assertThat(emailCreated.subject).isEqualTo("Glad to see you again at the exhibition")
    }

    @Test
    fun `creates an email for new customer at exhibition with tracking parameters`() {
        val location = "Exhibition"
        val customer = Customer()

        val emailCreated = emailService.createEmail(location, customer)

        assertThat(emailCreated.url).isEqualTo("Sign up")
        assertThat(emailCreated.subject).isEqualTo("Sign up to get updates on your exhibition purchase")
        assertThat(emailCreated.trackingCampaign).isEqualTo("Will they sign up?")
    }

    @Test
    fun `creates an email for general customer met elsewhere with no tracking parameters`() {
        val location = ""
        val customer = Customer()

        val emailCreated = emailService.createEmail(location, customer)

        assertThat(emailCreated.url).isEqualTo("Sign up")
        assertThat(emailCreated.subject).isEqualTo("Nice to meet you")
        assertThat(emailCreated.trackingCampaign).isNull()
    }
}
