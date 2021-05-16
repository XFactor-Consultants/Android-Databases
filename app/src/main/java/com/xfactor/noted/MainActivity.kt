package com.xfactor.noted

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.xfactor.noted.databse.AppDatabase
import com.xfactor.noted.databse.migrations.MIGATION_1_2
import com.xfactor.noted.databse.migrations.MIGRATION_2_3


lateinit var appDatabase: AppDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "noted-database").allowMainThreadQueries().addMigrations(
            MIGATION_1_2, MIGRATION_2_3).build()

        // Setting ActionBar logo
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.ic_logo)
        supportActionBar?.setDisplayUseLogoEnabled(true)

        setContentView(R.layout.activity_main)

        // Setup navigation
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_delete, R.id.navigation_listcontainer, R.id.navigation_newlist))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
//        getLists().forEach { list-> list.ListItems.forEachIndexed{index, listItem ->
//            listItem.order_number = index
//            appDatabase.listItemDao().update(listItem)
//        } }
        Log.e("test", appDatabase.listDao().getCompareLists().toString())
    }
}


