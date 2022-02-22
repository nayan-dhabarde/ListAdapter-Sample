package com.example.listadaptertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadaptertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val pizzas = mutableListOf<Pizza>(
        Pizza(0, "Al fungi", "Mozerella", true),
        Pizza(1, "Spicy chicken", "Cheddar", false),
        Pizza(2, "Spicy Veg", "Parmesan", true)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            val adapter = PizzaAdapter(PizzaDiffUtil())
            pizzaRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            pizzaRecyclerView.adapter = adapter
            adapter.submitAndUpdateList(pizzas)

            btnChange.setOnClickListener {
                val newPizza = pizzas[1].copy(cheese = "Mozerella")
                pizzas[1] = newPizza
                adapter.submitAndUpdateList(pizzas)
            }

            btnRemove.setOnClickListener {
                if(pizzas.size == 3) {
                    pizzas.removeAt(2)
                    adapter.submitAndUpdateList(pizzas)
                }
            }

            btnAdd.setOnClickListener {
                pizzas.add(Pizza(2, "Spicy Veg", "Parmesan", true))
                adapter.submitAndUpdateList(pizzas)
            }
        }
    }
}