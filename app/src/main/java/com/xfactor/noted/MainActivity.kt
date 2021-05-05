package com.xfactor.noted

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

data class ListItem(
    val id: Long,
    var title: String,
    val elements: MutableList<String>
)

val Lists = mutableListOf(
    ListItem(0, "List 1", elements = mutableListOf("Element 1", "Element 2")),
    ListItem(1, "List 2", elements = mutableListOf("Element 1", "Element 2")),
    ListItem(2, "List 3", elements = mutableListOf("Element 1", "Element 2"))
)

val ListsToCompare = mutableListOf<ListItem>()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.ic_logo)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_delete, R.id.navigation_listcontainer, R.id.navigation_newlist))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }
}


