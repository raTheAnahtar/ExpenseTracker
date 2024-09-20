package com.rathanapim.expensetracker.models

data class Expense(
    val date: Long = System.currentTimeMillis(),
    val paymentType: PaymentType,
    val cardUsed: Card,
    val paidTo: String,
    val description: String = "",
    val amount: Double,
    val currency: Currency,
    val category: Category,
)