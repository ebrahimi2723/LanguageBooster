package com.example.languagebooster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.languagebooster.adapter.RecyclerAdapter
import com.example.languagebooster.data.MockData
import model.Words
import soup.neumorphism.NeumorphFloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var mainList: RecyclerView
    private lateinit var fab: NeumorphFloatingActionButton
    private lateinit var recyclerAdapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }

    private fun init() {
        bindViews()
        recyclerAdapter = RecyclerAdapter(MockData.getListWord())
        mainList.adapter = recyclerAdapter
        val layoutManager = LinearLayoutManager(this)
        mainList.layoutManager = layoutManager
        prepareWord()
    }

    private fun prepareWord() {
        MockData.getListWord().clear()
        MockData.addToList(Words("Hello", "سلام", true))
        MockData.addToList(Words("Apple", "سیب", true))
        MockData.addToList(Words("Bus", "اتوبوس", true))
        MockData.addToList(Words("Car", "ماشین", true))
        MockData.addToList(Words("Love", "عشق", true))
        MockData.addToList(Words("Implement", "پیاده سازی", true))
        recyclerAdapter.notifyDataSetChanged()
    }

    private fun bindViews() {
        mainList = findViewById(R.id.mainList)
        fab = findViewById(R.id.fab)
    }
}