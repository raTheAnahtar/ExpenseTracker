package com.rathanapim.expensetracker.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rathanapim.expensetracker.R
import com.rathanapim.expensetracker.models.Expense
import com.rathanapim.expensetracker.models.getIconRes
import com.rathanapim.expensetracker.ui.theme.ExpenseTrackerTheme
import com.rathanapim.expensetracker.utils.PreviewDataUtil
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ExpenseItem(
    expense: Expense,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = expense.category.getIconRes()),
            contentDescription = stringResource(id = R.string.expense_icon),
            tint = Color.Unspecified,
            modifier = Modifier
                .width(60.dp)
                .fillMaxHeight()
        )
        Column(
            modifier = Modifier
                .weight(1F)
                .padding(start = 16.dp)
        ) {
            Text(
                text = expense.paidTo,
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = expense.description,
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.bodySmall
            )
        }
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .width(100.dp)
                .padding(end = 10.dp)
        ) {
            Text(
                text = "${expense.currency.symbol}${String.format("%.2f", expense.amount)}", // Format the amount
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.End
            )
            Text(
                text = formatDate(expense.date),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.End
            )
        }
    }
}

@Preview
@Composable
private fun ExpenseItemPreview() {
    ExpenseTrackerTheme {
        Surface(color = MaterialTheme.colorScheme.surfaceVariant) {
            ExpenseItem(expense = PreviewDataUtil.getExpense())
        }
    }
}

private fun formatDate(date: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(date))
}