package com.example.network.di

import com.example.network.data.repositoryImpl.AuthRepositoryImpl
import com.example.network.data.repositoryImpl.GameRepositoryImpl
import com.example.network.data.repositoryImpl.ProfileRepositoryImpl
import com.example.network.data.repositoryImpl.StatisticsRepositoryImpl
import com.example.network.domain.repository.AuthRepository
import com.example.network.domain.repository.GameRepository
import com.example.network.domain.repository.ProfileRepository
import com.example.network.domain.repository.StatisticsRepository
import com.example.network.domain.usecase.CreateGameUseCase
import com.example.network.domain.usecase.CreateProfileUseCase
import com.example.network.domain.usecase.EditProfileUseCase
import com.example.network.domain.usecase.GetGameInfoUseCase
import com.example.network.domain.usecase.GetGamesUseCase
import com.example.network.domain.usecase.GetLastWeekCreatedGamesUseCase
import com.example.network.domain.usecase.GetProfileUseCase
import com.example.network.domain.usecase.GetUserStatisticsUseCase
import com.example.network.domain.usecase.LogoutUseCase
import com.example.network.domain.usecase.RegistrationUseCase
import com.example.network.domain.usecase.SaveGameResultUseCase
import com.example.network.domain.usecase.SignInUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//24.03.2026
//Алексей
//класс для внедрения зависимостей
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideAuthRepository(): AuthRepository{
        return AuthRepositoryImpl()
    }

    @Provides
    fun provideProfileRepository(): ProfileRepository{
        return ProfileRepositoryImpl()
    }

    @Provides
    fun provideGameRepository(): GameRepository{
        return GameRepositoryImpl()
    }

    @Provides
    fun provideStatisticsRepository(): StatisticsRepository{
        return StatisticsRepositoryImpl()
    }

    @Provides
    fun provideSignInUseCase(authRepository: AuthRepository): SignInUseCase{
        return SignInUseCase(authRepository)
    }

    @Provides
    fun provideRegistrationUseCase(authRepository: AuthRepository): RegistrationUseCase{
        return RegistrationUseCase(authRepository)
    }

    @Provides
    fun provideLogoutUseCase(authRepository: AuthRepository): LogoutUseCase{
        return LogoutUseCase(authRepository)
    }

    @Provides
    fun provideCreateProfileUseCase(profileRepository: ProfileRepository): CreateProfileUseCase{
        return CreateProfileUseCase(profileRepository)
    }

    @Provides
    fun provideEditProfileUseCase(profileRepository: ProfileRepository): EditProfileUseCase{
        return EditProfileUseCase(profileRepository)
    }

    @Provides
    fun provideGetProfileUseCase(profileRepository: ProfileRepository): GetProfileUseCase{
        return GetProfileUseCase(profileRepository)
    }

    @Provides
    fun provideCreateGameUseCase(gameRepository: GameRepository): CreateGameUseCase{
        return CreateGameUseCase(gameRepository)
    }

    @Provides
    fun provideGetGamesUseCase(gameRepository: GameRepository): GetGamesUseCase{
        return GetGamesUseCase(gameRepository)
    }

    @Provides
    fun provideGetGameInfo(gameRepository: GameRepository): GetGameInfoUseCase{
        return GetGameInfoUseCase(gameRepository)
    }

    @Provides
    fun provideSaveGameResultUseCase(statisticsRepository: StatisticsRepository): SaveGameResultUseCase{
        return SaveGameResultUseCase(statisticsRepository)
    }

    @Provides
    fun provideGetUserStatisticsUseCase(statisticsRepository: StatisticsRepository): GetUserStatisticsUseCase{
        return GetUserStatisticsUseCase(statisticsRepository)
    }

    @Provides
    fun provideGetLastWeekCreatedGamesUseCase(gameRepository: GameRepository): GetLastWeekCreatedGamesUseCase{
        return GetLastWeekCreatedGamesUseCase(gameRepository)
    }
}