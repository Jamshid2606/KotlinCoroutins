package com.jama.kotlincoroutins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jama.kotlincoroutins.databinding.ActivityMainBinding
import com.jama.kotlincoroutins.models.UserData
import com.jama.kotlincoroutins.networking.ApiClient
import com.jama.kotlincoroutins.networking.ApiService
import com.jama.kotlincoroutins.vm.UserViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(){//, CoroutineScope {

    lateinit var binding:ActivityMainBinding
//    lateinit var apiService: ApiService
//    lateinit var job: Job
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewmodel = ViewModelProvider(this)[UserViewModel::class.java]
        viewmodel.getUsersLiveData().observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            showUsers(it)
        })
//        job=Job()
//        apiService = ApiClient.getRetrofit().create(ApiService::class.java)
        //Scope
//        GlobalScope.launch {x
//            val userList = apiService.getUsers()
//            withContext(Dispatchers.Main) {
//                showUsers(userList)
//            }
//        }
//        launch{
//            val users = apiService.getUsers()
//            showUsers(users)
//            Log.d(TAG, "onCreate: $users")
//        }
    }
//    suspend fun getUsers2(){
//        apiService.getUsers()
//    }

    private fun showUsers(userList: List<UserData>) {
        binding.tv.text = userList.toString()
    }

//    override val coroutineContext: CoroutineContext
//        get() = Dispatchers.Main+job+coroutineExceptionHandler
//    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
//        println("Handle $exception in CoroutineExceptionHandler")
//    }
//    override fun onPause() {
//        job.cancel()
//        Log.d(TAG, "onPause: Cancel job")
//        super.onPause()
//    }
//    override fun onDestroy() {
//        job.cancel()
//        Log.d(TAG, "onDestroy: Cancel job")
//        super.onDestroy()
//    }
}