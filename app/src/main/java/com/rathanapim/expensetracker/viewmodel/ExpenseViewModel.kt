package com.rathanapim.expensetracker.viewmodel

import androidx.lifecycle.ViewModel
import com.rathanapim.expensetracker.models.Currency
import com.rathanapim.expensetracker.models.Expense
import com.rathanapim.expensetracker.models.Month
import com.rathanapim.expensetracker.models.MonthlyExpenseData
import com.rathanapim.expensetracker.models.MonthlySummary
import com.rathanapim.expensetracker.utils.PreviewDataUtil
import java.util.Calendar

class ExpenseViewModel: ViewModel() {

    private val expenses: MutableList<Expense> = mutableListOf()
    private val customCurrency: MutableList<Currency> = mutableListOf()
    private val defaultCurrent = listOf(
        Currency.USD,
        Currency.EUR,
        Currency.GBP,
        Currency.JPY
    )

    init {
        //Populate fake data
        expenses.addAll(PreviewDataUtil.getExpenses())
    }

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }

    fun getExpenses(): List<Expense> {
        return expenses
    }

    fun addCustomCurrency(currency: Currency.CustomCurrency) {
        customCurrency.add(currency)
    }

    fun getAllCurrencies(): List<Currency> {
        return defaultCurrent + customCurrency
    }

    fun getMonthlyExpenseData(month: Month, year: Int, currency: Currency): MonthlyExpenseData {
       val filteredExpenses = expenses.filter { expense ->
           val calendar = Calendar.getInstance().apply { timeInMillis = expense.date }
           val expenseMonth = Month.values()[calendar.get(Calendar.MONTH)]
           val expenseYear = calendar.get(Calendar.YEAR)
           month == expenseMonth && year == expenseYear
       }

        return MonthlyExpenseData(
            summary = calculateMonthlySummary(month, year, currency, filteredExpenses),
            expenses = filteredExpenses
        )
    }

    private fun calculateMonthlySummary(month: Month, year: Int, currency: Currency, expenses: List<Expense>): MonthlySummary {
        val total = expenses.sumOf { it.amount }
        val count = expenses.size
        val expensesByCategory = expenses
            .groupBy { it.category  }
            .mapValues { entry -> entry.value.sumOf { it.amount } }

        return MonthlySummary(
            month = month,
            year = year,
            currency = currency,
            totalAmount = total,
            expenseCount = count,
            expensesByCategory = expensesByCategory)
    }

}