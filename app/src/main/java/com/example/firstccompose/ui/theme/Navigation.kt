package com.example.firstccompose.ui.theme

import androidx.compose.runtime.mutableStateOf
import com.example.firstccompose.Pages

object Navigation {
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote : QuoteData? = null
    fun switch(currentQuoteData: QuoteData?){
        if (currentPage.value == Pages.LISTING) {
            currentQuote = currentQuoteData
            currentPage.value = Pages.DETAIL
        }else
            currentPage.value = Pages.LISTING
    }
}