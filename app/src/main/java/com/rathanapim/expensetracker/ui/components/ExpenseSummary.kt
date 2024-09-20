package com.rathanapim.expensetracker.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rathanapim.expensetracker.R
import com.rathanapim.expensetracker.models.Category
import com.rathanapim.expensetracker.models.Currency
import com.rathanapim.expensetracker.models.MonthlySummary
import com.rathanapim.expensetracker.models.getStringRes
import com.rathanapim.expensetracker.ui.theme.ExpenseTrackerTheme
import com.rathanapim.expensetracker.utils.PreviewDataUtil

@Composable
fun ExpenseSummary(
    monthlySummary: MonthlySummary,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        SummaryItem(
            label = stringResource(id = R.string.total_amount),
            value = "${monthlySummary.currency.symbol}${String.format("%.2f", monthlySummary.totalAmount)}",
            modifier = Modifier.padding(bottom = 8.dp)

        )
        SummaryItem(
            label = stringResource(id = R.string.expense_count),
            value = "${monthlySummary.expenseCount}",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        SummaryItem(
            label = "${stringResource(id = R.string.category_expenses)}:",
            value = ""
        )
        monthlySummary.expensesByCategory.forEach { (category, amount) ->
            SummaryItem(
                label = stringResource(id = category.getStringRes()),
                value = "${monthlySummary.currency.symbol}${String.format("%.2f", amount)}",
                modifier = Modifier.padding(start = 24.dp)
            )
        }
    }
}
@Composable
fun SummaryItem(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.surfaceTint
        )
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview
@Composable
private fun SummaryItemPreview() {
    ExpenseTrackerTheme {
        Surface {
            SummaryItem(label = "Total cost", value = "$135.99")
        }
    }
}


@Preview
@Composable
private fun ExpenseSummaryPreview() {
    ExpenseTrackerTheme {
        Surface {
            ExpenseSummary(
                monthlySummary = PreviewDataUtil.getMonthlySummary()
            )
        }
    }
}