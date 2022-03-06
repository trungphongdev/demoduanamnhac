package com.example.kotlinrecyclerview

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.content.AsyncTaskLoader
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter1: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list: List<DataModel> = listOf()
        adapter1 = CustomAdapter(list, this@MainActivity)
        setContentView(R.layout.activity_main)
        val myRecyclerView = findViewById<RecyclerView>(R.id.myRecyclerview).apply {
            layoutManager = LinearLayoutManager(this@MainActivity, VERTICAL, false)
            adapter = adapter1
            //layoutManager = GridLayoutManager(this,2)

        }

        adapter1.setlistener(object : CustomAdapter.eventlistener{
            override fun position(i: Int) {
                Toast.makeText(this@MainActivity,"${i.toString()}",Toast.LENGTH_SHORT).show()
            }

        })




        //  adapter1.onClickItem1 = {Toast.makeText(this,"$it",Toast.LENGTH_SHORT).show()
    }

}

    private fun getItemsList(): List<DataModel> {
        val list = ArrayList<DataModel>()
        list.add(DataModel("Item new type 1", CustomAdapter.VIEW_TYPE_ONE))
        list.add(DataModel("Item new type 1", CustomAdapter.VIEW_TYPE_ONE))
        list.add(DataModel("Item new type 2", CustomAdapter.VIEW_TYPE_TWO))
        list.add(DataModel("Item new type 2", CustomAdapter.VIEW_TYPE_TWO))
        list.add(DataModel("Item new type 1", CustomAdapter.VIEW_TYPE_ONE))
        list.add(DataModel("Item new type 2", CustomAdapter.VIEW_TYPE_TWO))
        list.add(DataModel("Item new type 1", CustomAdapter.VIEW_TYPE_ONE))
        list.add(DataModel("Item new type 2", CustomAdapter.VIEW_TYPE_TWO))
        list.add(DataModel("Item new type 2", CustomAdapter.VIEW_TYPE_TWO))
        return list
    }





