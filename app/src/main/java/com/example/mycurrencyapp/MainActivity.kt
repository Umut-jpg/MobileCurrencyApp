package com.example.mycurrencyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.example.mycurrencyapp.Pages.Calculate
import com.example.mycurrencyapp.Pages.MyList
import com.example.mycurrencyapp.Pages.Gold
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(1000)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        loadFragment(MyList())


        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.itemIconTintList = null
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.CalculatorLayout -> {
                    loadFragment(Calculate())
                    true
                }
                R.id.GoldLayout -> {
                    loadFragment(Gold())
                    true
                }
                R.id.ListLayout -> {
                    val myListFragment = MyList()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, myListFragment)
                        .commit()
                    true
                }else -> false
            }
        }

    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }


}


