package kg.nurik.molbulakapp.di

import kg.nurik.molbulakapp.data.interactors.Interactors
import kg.nurik.molbulakapp.data.interactors.InteractorsImpl
import kg.nurik.molbulakapp.data.remote.MolbulakService
import kg.nurik.molbulakapp.data.remote.RetrofitBuilder
import kg.nurik.molbulakapp.data.repository.Repository
import kg.nurik.molbulakapp.data.repository.RepositoryImpl
import kg.nurik.molbulakapp.ui.authorization.AuthorizationViewModel
import kg.nurik.molbulakapp.ui.registration.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { AuthorizationViewModel(get()) }
    viewModel { RegistrationViewModel(get()) }
}

val repositoryModule: Module = module {
    single<Repository> { RepositoryImpl() }
}

val apiModule: Module = module {
    single<MolbulakService> { RetrofitBuilder.buildRetrofit() }
    single<Interactors> { InteractorsImpl(get()) }
}

val appModules =
    listOf(viewModelModule, apiModule, repositoryModule)