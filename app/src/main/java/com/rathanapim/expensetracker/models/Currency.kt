package com.rathanapim.expensetracker.models

sealed class Currency {
    abstract val abbr: String
    abstract val symbol: String

    // Default Currencies
    data object USD : Currency() {
        override val abbr = "USD"
        override val symbol = "$"
    }

    data object EUR : Currency() {
        override val abbr = "EUR"
        override val symbol = "€"
    }

    data object GBP : Currency() {
        override val abbr = "GBP"
        override val symbol = "£"
    }

    data object JPY : Currency() {
        override val abbr = "JPY"
        override val symbol = "¥"
    }

    // Custom Currencies
    data class CustomCurrency(
        val name: String,
        override val abbr: String,
        override val symbol: String
    ) : Currency()
}
