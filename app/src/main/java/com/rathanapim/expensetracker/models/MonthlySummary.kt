package com.rathanapim.expensetracker.models

import java.util.Calendar

data class MonthlySummary(
    val month: Month,
    val year: Int,
    val totalAmount: Double,
    val expenseCount: Int,
    val expensesByCategory: Map<Category, Double>,
    val currency: Currency
)
