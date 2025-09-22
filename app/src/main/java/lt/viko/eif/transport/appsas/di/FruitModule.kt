package lt.viko.eif.transport.appsas.di

import androidx.lifecycle.viewmodel.compose.viewModel
import lt.viko.eif.transport.appsas.data.FruitRepository
import lt.viko.eif.transport.appsas.data.FruitRepositoryImpl
import lt.viko.eif.transport.appsas.view.FruitViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val fruitModule = module {

    single<FruitRepository> {
        FruitRepositoryImpl()
    }

    viewModelOf(::FruitViewModel)

}