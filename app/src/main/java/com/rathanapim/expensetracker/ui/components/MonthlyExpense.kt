package com.rathanapim.expensetracker.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.rathanapim.expensetracker.models.Expense
import com.rathanapim.expensetracker.models.MonthlySummary
import com.rathanapim.expensetracker.models.getStringRes
import com.rathanapim.expensetracker.ui.theme.ExpenseTrackerTheme
import com.rathanapim.expensetracker.utils.PreviewDataUtil

@Composable
fun MonthlyExpense(
    monthlySummary: MonthlySummary,
    expenses: List<Expense>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "${stringResource(id = monthlySummary.month.getStringRes())} ${monthlySummary.year}",
            style = MaterialTheme.typography.titleLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        ExpenseSummary(monthlySummary = monthlySummary)
        Spacer(modifier = Modifier.height(16.dp))
        Divider(
            color = MaterialTheme.colorScheme.onBackground,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        ExpenseList(expenses = expenses)
    }
}

@PreviewLightDark
@Composable
private fun MonthlySpendingPreview() {
    ExpenseTrackerTheme {
        Surface {
            MonthlyExpense(monthlySummary = PreviewDataUtil.getMonthlySummary(), expenses = PreviewDataUtil.getExpenses())
        }
    }
}