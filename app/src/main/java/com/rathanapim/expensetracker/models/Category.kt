package com.rathanapim.expensetracker.models

import com.rathanapim.expensetracker.R

enum class Category {
    FOOD,
    ENTERTAINMENT,
    TRANSPORTATION,
    HEALTH,
    OTHER
}

// Extension function to get the icon for each category
fun Category.getIconRes(): Int {
    return when (this) {
        Category.FOOD -> R.drawable.category_food
        Category.ENTERTAINMENT -> R.drawable.category_entertainment
        Category.TRANSPORTATION -> R.drawable.category_transportation
        Category.HEALTH -> R.drawable.category_health
        Category.OTHER -> R.drawable.category_other
    }
}

// Extension function to get the string resoruce for each category
fun Category.getStringRes(): Int {
    return when (this) {
        Category.FOOD -> R.string.category_food
        Category.ENTERTAINMENT -> R.string.category_entertainment
        Category.TRANSPORTATION -> R.string.category_transportation
        Category.HEALTH -> R.string.category_health
        Category.OTHER -> R.string.category_other
    }
}