package com.rathanapim.expensetracker.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rathanapim.expensetracker.models.Currency
import com.rathanapim.expensetracker.models.Month
import com.rathanapim.expensetracker.ui.components.MonthlyExpense
import com.rathanapim.expensetracker.ui.theme.ExpenseTrackerTheme
import com.rathanapim.expensetracker.viewmodel.ExpenseViewModel

@Composable
fun MonthlySummaryScreen(
    month: Month,
    year: Int,
    expenseViewModel: ExpenseViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val monthlyExpense = expenseViewModel.getMonthlyExpenseData(month = month, year = year, currency = Currency.USD)
    MonthlyExpense(
        monthlySummary = monthlyExpense.summary,
        expenses = monthlyExpense.expenses,
        modifier = modifier.padding(8.dp)
    )
}

@PreviewLightDark
@Composable
private fun MonthlySummaryScreenPreview() {
    ExpenseTrackerTheme {
        Surface {
            MonthlySummaryScreen(month = Month.AUGUST, year = 2024)
        }
    }
}