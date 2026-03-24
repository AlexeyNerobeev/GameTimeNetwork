package com.example.network

import android.util.Log
import com.example.network.data.repositoryImpl.AuthRepositoryImpl
import com.example.network.data.repositoryImpl.GameRepositoryImpl
import com.example.network.data.repositoryImpl.ProfileRepositoryImpl
import com.example.network.data.repositoryImpl.StatisticsRepositoryImpl
import com.example.network.domain.model.Game
import com.example.network.domain.model.Statistics
import com.example.network.domain.model.User
import com.example.network.domain.usecase.CreateGameUseCase
import com.example.network.domain.usecase.CreateProfileUseCase
import com.example.network.domain.usecase.EditProfileUseCase
import com.example.network.domain.usecase.GetGameInfoUseCase
import com.example.network.domain.usecase.GetGamesUseCase
import com.example.network.domain.usecase.GetLastWeekCreatedGamesUseCase
import com.example.network.domain.usecase.GetProfileUseCase
import com.example.network.domain.usecase.GetUserStatisticsUseCase
import com.example.network.domain.usecase.RegistrationUseCase
import com.example.network.domain.usecase.SaveGameResultUseCase
import com.example.network.domain.usecase.SignInUseCase
import org.junit.Test
import kotlinx.coroutines.test.runTest

//24.03.2026
//Алексей
//класс для тестирования запросов к серверу
class Tests {
    //repository
    private val authRepository = AuthRepositoryImpl()
    private val profileRepository = ProfileRepositoryImpl()
    private val gameRepository = GameRepositoryImpl()
    private val statisticsRepository = StatisticsRepositoryImpl()

    //usecase
    private val signInUseCase = SignInUseCase(authRepository)
    private val registrationUseCase = RegistrationUseCase(authRepository)
    private val createProfileUseCase = CreateProfileUseCase(profileRepository)
    private val editCreateProfileUseCase = EditProfileUseCase(profileRepository)
    private val getProfileUseCase = GetProfileUseCase(profileRepository)
    private val createGameUseCase = CreateGameUseCase(gameRepository)
    private val getGamesUseCase = GetGamesUseCase(gameRepository)
    private val getGameInfoUseCase = GetGameInfoUseCase(gameRepository)
    private val saveGameResultUseCase = SaveGameResultUseCase(statisticsRepository)
    private val getUserStatisticsUseCase = GetUserStatisticsUseCase(statisticsRepository)
    private val getLastWeekCreatedGamesUseCase = GetLastWeekCreatedGamesUseCase(gameRepository)

    @Test
    fun signInTest() = runTest {
        val request = signInUseCase.invoke("qwe@mail.ru", "Password 123$")
    }

    @Test
    fun registrationTest() = runTest {
        val request = registrationUseCase.invoke("qwe@mail.ru", "Password 123$")
    }

    @Test
    fun createProfileTest() = runTest {
        createProfileUseCase.invoke(
            User(
                fullName = "qwe",
                userName = "qwe",
                phone = "947548968952390",
                email = "qwe@mail.ru",
                userId = "6f00e874-0fa2-4f11-ab78-8412c6384140"
            )
        )
    }

    @Test
    fun editProfileTest() = runTest {
        editCreateProfileUseCase.invoke(
            User(
                fullName = "qwe",
                userName = "qwerty",
                phone = "947548968952390",
                email = "qwe@mail.ru",
                userId = "6f00e874-0fa2-4f11-ab78-8412c6384140"
            )
        )
    }

    @Test
    fun getProfileTest() = runTest {
        getProfileUseCase.invoke("6f00e874-0fa2-4f11-ab78-8412c6384140")
    }

    @Test
    fun createGameTest() = runTest {
        createGameUseCase.invoke(
            Game(
                name = "game",
                category = "category",
                winingPrice = 5000,
                dateStart = "",
                dateEnd = "",
                description = "description",
                userId = "6f00e874-0fa2-4f11-ab78-8412c6384140",
                status = "active"
            )
        )
    }

    @Test
    fun getGamesTest() = runTest {
        getGamesUseCase.invoke()
    }

    @Test
    fun getGameInfoTest() = runTest {
        getGameInfoUseCase.invoke(1)
    }

    @Test
    fun saveGameResultTest() = runTest {
        saveGameResultUseCase.invoke(
            Statistics(
                gameId = 1,
                result = "win",
                userId = "6f00e874-0fa2-4f11-ab78-8412c6384140",
                totalWinning = 3000
            )
        )
    }

    @Test
    fun getUserStatisticsTest() = runTest {
        getUserStatisticsUseCase.invoke("6f00e874-0fa2-4f11-ab78-8412c6384140")
    }

    @Test
    fun getLastWeekCreatedGamesTest() = runTest {
        getLastWeekCreatedGamesUseCase.invoke("6f00e874-0fa2-4f11-ab78-8412c6384140")
    }
}