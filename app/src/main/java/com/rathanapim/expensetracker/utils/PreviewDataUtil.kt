package com.rathanapim.expensetracker.utils

import com.rathanapim.expensetracker.models.Card
import com.rathanapim.expensetracker.models.Category
import com.rathanapim.expensetracker.models.Currency
import com.rathanapim.expensetracker.models.Expense
import com.rathanapim.expensetracker.models.Month
import com.rathanapim.expensetracker.models.MonthlySummary
import com.rathanapim.expensetracker.models.PaymentType
import kotlin.random.Random

object PreviewDataUtil {
    fun getExpense(): Expense {
        return Expense(
            date = System.currentTimeMillis(),
            paymentType = PaymentType.CARD,
            cardUsed = Card(name = "", last4digits = ""),
            paidTo = "Haidilao",
            description = "hot pot with friends",
            amount = 25.9901,
            currency = Currency.USD,
            category = Category.FOOD
        )
    }


    fun getExpenses(): List<Expense> {
        val list: MutableList<Expense> = mutableListOf()
        repeat(20) { i ->
            list.add(
                Expense(
                    date = randomDate(),  // Random date
                    paymentType = PaymentType.CARD,
                    cardUsed = Card(
                        name = "Visa",
                        last4digits = Random.nextInt(1000, 9999).toString()  // Random last 4 digits
                    ),
                    paidTo = "Expense $i",
                    description = "this is expense #$i",
                    amount = String.format("%.2f", randomAmount()).toDouble(),  // Rounded to 2 decimals
                    currency = Currency.USD,
                    category = Category.values().random()
                )
            )
        }
        return list
    }

    fun getMonthlySummary(): MonthlySummary {
        return MonthlySummary(
            month = Month.AUGUST,
            year = 2024,
            totalAmount = 2400.65,
            expenseCount = 43,
            expensesByCategory = mapOf(
                Category.FOOD to 700.15,
                Category.ENTERTAINMENT to 600.20,
                Category.TRANSPORTATION to 100.10,
                Category.HEALTH to 800.10,
                Category.OTHER to 200.20
            ),
            currency = Currency.USD
        )
    }

    // Generates a random date within the past 30 days
    private fun randomDate(): Long {
        val currentDate = System.currentTimeMillis()
        val thirtyDaysInMillis = 30L * 24 * 60 * 60 * 1000
        return Random.nextLong(currentDate - thirtyDaysInMillis, currentDate)
    }

    // Generates a random amount between 15.00 and 50.00
    private fun randomAmount(): Double {
        return Random.nextDouble(15.00, 50.00)
    }

}
