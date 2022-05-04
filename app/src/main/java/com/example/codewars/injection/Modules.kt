package com.example.codewars.injection

import androidx.navigation.NavController
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import com.example.codewars.BuildConfig
import com.example.codewars.data.api.CodeWarsApi
import com.example.codewars.data.model.Challenges
import com.example.codewars.data.repository.ChallengesByUserRepositoryImp
import com.example.codewars.data.source.ChallengesByUserPagingSource
import com.example.codewars.domain.mapper.ChallengesByUserMapperImp
import com.example.codewars.domain.mapper.abs.ChallengesByUserMapper
import com.example.codewars.domain.repository.ChallengesByUserRepository
import com.example.codewars.domain.usercase.ChallengesByUserUseCaseImp
import com.example.codewars.domain.usercase.abs.ChallengesByUserUseCase
import com.example.codewars.domain.viewmodel.ChallengesByUserViewModel
import com.example.codewars.router.ChallengesListRouterImp
import com.example.codewars.router.abs.ChallengesListRouter
import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.Rfc3339DateJsonAdapter
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


object Modules {
    private val network = module {

        single {
            Moshi.Builder()
                .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
                .build()
        }

        single {
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(OkHttpProfilerInterceptor())
                        .build()
                )
                .build()
        }
    }

    private val api = module {
        single {
            val retrofit: Retrofit = get()
            retrofit.create(CodeWarsApi::class.java)
        }
    }
    private val paging = module {
        single<PagingSource<Int, Challenges>> { ChallengesByUserPagingSource(api = get()) }
        single { PagingConfig(ChallengesByUserRepositoryImp.DEFAULT_LIST_SIZE) }
        single { Pager(get()) { get<PagingSource<Int, Challenges>>() } }
    }

    private val repository = module {
        single<ChallengesByUserRepository> {
            ChallengesByUserRepositoryImp(
                pager = get()
            )
        }
    }

    private val mapper = module {
        single<ChallengesByUserMapper> {
            ChallengesByUserMapperImp()
        }
    }

    private val useCase = module {
        single<ChallengesByUserUseCase> {
            ChallengesByUserUseCaseImp(
                mapper = get(),
                challengesByUserRepository = get()
            )
        }
    }

    private val viewModel = module {
        viewModel {
            ChallengesByUserViewModel(
                useUseCase = get()
            )
        }

    }

    private val database = module {
        //TODO
    }

    private val dao = module {
        //TODO
    }


    private val router = module {
        factory<ChallengesListRouter> { (navController: NavController) ->
            ChallengesListRouterImp(navController = navController)
        }
    }

    var all = listOf(
        network,
        api,
        paging,
        repository,
        mapper,
        useCase,
        viewModel,
        router

    )
}

