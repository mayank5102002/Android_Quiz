package com.example.androidquiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.androidquiz.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)

        //NavHostFragment and NavController for navigation among the fragments
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        //Setting the action bar with the NavController to get the back functionality
        NavigationUI.setupActionBarWithNavController(this,navController)

        val view = binding.root
        setContentView(view)
    }

    //Adding what to do when back button pressed for any fragment
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.popBackStack()
    }
}