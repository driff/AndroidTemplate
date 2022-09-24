package com.driff.android.module_template.presentation.utils

fun String.isBalanced(): Boolean {
    return takeIf { isNotEmpty() }?.let {
        val openBracketsCount = it.count { currentChar -> currentChar == '[' }
        val closeBracketsCount = it.count { currentChar -> currentChar == ']' }
        if (first() == ']')
            return false
        if (last() == '[')
            return false
        return openBracketsCount == closeBracketsCount
    }?: false
}