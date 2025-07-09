package com.example.mycaffeine.di

import com.example.mycaffeine.presentation.screens.customizeCoffeeScreen.CustomizeCoffeeViewModel
import com.example.mycaffeine.presentation.screens.goodByeScreen.GoodByeViewModel
import com.example.mycaffeine.presentation.screens.preparingOrderScreen.PreparingOrderViewModel
import com.example.mycaffeine.presentation.screens.readyOrderScreen.ReadyOrderViewModel
import com.example.mycaffeine.presentation.screens.selectCoffeeScreen.SelectCoffeeViewModel
import com.example.mycaffeine.presentation.screens.snacksScreen.SnacksViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SelectCoffeeViewModel() }
    viewModel { CustomizeCoffeeViewModel(get()) }
    viewModel { PreparingOrderViewModel(get()) }
    viewModel { ReadyOrderViewModel(get()) }
    viewModel { SnacksViewModel() }
    viewModel { GoodByeViewModel(get()) }
}