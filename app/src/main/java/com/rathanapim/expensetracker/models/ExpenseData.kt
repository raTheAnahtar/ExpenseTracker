package com.rathanapim.expensetracker.models

data class MonthlyExpenseData(
    val summary: MonthlySummary,
    val expenses: List<Expense>
)