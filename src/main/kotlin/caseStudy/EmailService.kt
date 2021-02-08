package caseStudy

// What are the possible ways to refactor this class?
class EmailService() {

    fun createEmail(location: String, customer: Customer): EmailTemplate {
        val emailTemplate = EmailTemplate()

        if (customer.existInDatabase && location == "Market") {
            emailTemplate.url = "Sign in"
            emailTemplate.subject = "Glad to see you again at the market"
            return emailTemplate
        }

        if (!customer.existInDatabase && location == "Market") {
            emailTemplate.url = "Sign up"
            emailTemplate.subject = "Sign up to get updates on your market purchase"
            emailTemplate.trackingCampaign = "Will they sign up?"
            return emailTemplate
        }

        if (customer.existInDatabase && location == "Exhibition") {
            emailTemplate.url = "Sign in"
            emailTemplate.subject = "Glad to see you again at the exhibition"
            return emailTemplate
        }

        if (!customer.existInDatabase && location == "Exhibition") {
            emailTemplate.url = "Sign up"
            emailTemplate.subject = "Sign up to get updates on your exhibition purchase"
            emailTemplate.trackingCampaign = "Will they sign up?"
            return emailTemplate
        }

        emailTemplate.url = "Sign up"
        emailTemplate.subject = "Nice to meet you"
        return emailTemplate
    }
}

class Customer {
    var existInDatabase: Boolean = false
}

class EmailTemplate {
    lateinit var subject: String
    lateinit var url: String
    var trackingCampaign: String? = null
}
