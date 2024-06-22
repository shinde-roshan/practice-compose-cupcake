package com.example.cupcake.ui

import androidx.lifecycle.ViewModel
import com.example.cupcake.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

const val PRICE_PER_CAKE = 300
const val SAME_DAY_DELIVERY_EXTRA_CHARGE = 150

class OrderViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(OrderUiState(pickupOptions = pickupOptions()))
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    fun resetOrder() {
        _uiState.value = OrderUiState(pickupOptions = pickupOptions())
    }

    fun setQuantity(qnt: Int) {
        _uiState.update {
            it.copy(
                quantity = qnt,
                price = calculatePrice(quantity = qnt)
            )
        }
    }

    fun setFlavor(flavor: String) {
        _uiState.update {
            it.copy(flavor = flavor)
        }
    }

    fun setPickupDate(pickupDate: String) {
        _uiState.update {
            it.copy(
                date = pickupDate,
                price = calculatePrice(pickupDate = pickupDate)
            )
        }
    }

    private fun pickupOptions(): List<String> {
        val dateOptions = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4) {
            dateOptions.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return dateOptions
    }

    private fun calculatePrice(
        quantity: Int = _uiState.value.quantity,
        pickupDate: String = _uiState.value.date
    ): String {
        var price = quantity * PRICE_PER_CAKE
        if (pickupDate == pickupOptions()[0]) {
            price += SAME_DAY_DELIVERY_EXTRA_CHARGE
        }
        return NumberFormat.getCurrencyInstance().format(price)
    }
}