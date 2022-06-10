package com.example.weatherapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.api.RetroApiInterface
import com.example.weatherapp.api.WeatherRepository
import com.example.weatherapp.api.WeatherViewModel
import com.example.weatherapp.database.DailyWeather
import com.example.weatherapp.database.WeatherDao
import io.reactivex.rxjava3.core.Flowable.fromArray
import io.reactivex.rxjava3.core.Flowable.fromArray
import io.reactivex.rxjava3.core.Flowable.switchOnNext
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observable.fromArray
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.parallel.ParallelFlowable.fromArray
import junit.framework.TestCase.assertEquals
import okhttp3.internal.notifyAll
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import java.util.*


@RunWith(JUnit4::class)
class WeatherViewModelTest {

     lateinit var vm : WeatherViewModel

    @Mock
    lateinit var repo: WeatherRepository

    @Mock
     lateinit var weatherList: Observer<List<DailyWeather>>

   @Mock
   lateinit var  dao: WeatherDao
    @Mock
   lateinit var inter: RetroApiInterface



    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
      //        MockitoAnnotations.initMocks(this)
      MockitoAnnotations.openMocks(this)
      //repo =
      vm = WeatherViewModel(repo)
      //setUp Observers()
    }
//  private fun setupObservers(){
//    weatherList = mock(Observer::class.java) as Observer<List<DailyWeather>>
//
//  }
  @Test
  fun getDailyWeatherTest(){
    var fakeList : List<DailyWeather> = (listOf<DailyWeather>(
      DailyWeather(123,0,0,0,0,0,0.0,1.5*1,0.0,0.0,0.0,0.0,
      0.0,0,0,0.0,0.0,0,0.0,0,"","","",0,
      0.0,0.0,0.0,0.0)



    )

            )

    var liveList = MutableLiveData<List<DailyWeather>>()
            liveList.postValue(fakeList)

    Mockito.`when`(repo.getDailyWeather())
      .thenReturn(liveList)



  val result = vm.getDailyWeather()

   assertEquals(result?.value,fakeList)
    //assertEquals(1,1)
//
//    result.subscribeBy(
//      onNext = {
//        assertEquals(listOf<DailyWeather>(
//        DailyWeather(123,0,0,0,0,0,0.0,1.5*1,0.0,0.0,0.0,0.0,
//          0.0,0,0,0.0,0.0,0,0.0,0,"","","",0,
//          0.0,0.0,0.0,0.0)
//        ),it)
//      },
//      onError = { println("error :$it")}
//    )

  }
  @Test
  fun `given repository when calling Weatherlist then list is empty and assert its empty`() {

  }






  }