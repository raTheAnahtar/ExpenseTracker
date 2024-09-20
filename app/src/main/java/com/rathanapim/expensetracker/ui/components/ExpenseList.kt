package com.rathanapim.expensetracker.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rathanapim.expensetracker.models.Expense
import com.rathanapim.expensetracker.ui.theme.ExpenseTrackerTheme
import com.rathanapim.expensetracker.utils.PreviewDataUtil

@Composable
fun ExpenseList(
    expenses: List<Expense>,
    modifier: Modifier = Modifier
) {
    LazyColumn (
        modifier = modifier
    ) {
        items(expenses) { expense ->
            ExpenseItem(expense = expense)
        }
    }
}

@Preview
@Composable
private fun ExpenseListPreview() {
    ExpenseTrackerTheme {
        Surface {
            ExpenseList(expenses = PreviewDataUtil.getExpenses())
        }
    }
}
