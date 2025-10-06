package lt.viko.eif.transport.appsas.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import lt.viko.eif.transport.appsas.data.F1Api
import lt.viko.eif.transport.appsas.data.F1DriversRepository
import lt.viko.eif.transport.appsas.data.F1DriversRepositoryImpl
import lt.viko.eif.transport.appsas.data.FruitRepository
import lt.viko.eif.transport.appsas.data.FruitRepositoryImpl
import lt.viko.eif.transport.appsas.view.FruitViewModel
import lt.viko.eif.transport.appsas.view.drivers.DriversViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

val networkModule = module {



    single<Moshi> {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }


    // Base Retrofit instance - used across all features
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://api.openf1.org/")
            .addConverterFactory(MoshiConverterFactory.create(get<Moshi>()))
            .build()
    }



    single<F1Api> {
        get<Retrofit>().create(F1Api::class.java)
    }

    single<F1DriversRepository> {
        F1DriversRepositoryImpl(api = get())
    }

    viewModelOf(::DriversViewModel)

}