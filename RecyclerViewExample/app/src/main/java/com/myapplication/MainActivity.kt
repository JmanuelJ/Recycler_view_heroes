
package com.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.adapter.SuperHeroAdapter
import com.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val manager = LinearLayoutManager(this)
        //val decoration = DividerItemDecoration(this,manager.orientation)
        binding.recyclerSuperHero.layoutManager = manager
        binding.recyclerSuperHero.adapter =
            SuperHeroAdapter(SuperHeroProvider.superHeroList){superhero ->
            onItemSelected(
                superhero
            )
        }
        //binding.recyclerSuperHero.addItemDecoration(decoration)
    }

    fun onItemSelected(superHero: SuperHero){
        Toast.makeText(this,superHero.superhero,Toast.LENGTH_SHORT).show()
    }
}