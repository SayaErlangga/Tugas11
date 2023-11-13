package com.example.tugas11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.tugas11.databinding.ActivityMainBinding
import com.example.tugas11.model.DataMaps
import com.example.tugas11.model.Maps
import com.example.tugas11.network.ApiClient
import retrofit2.Call
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val client = ApiClient.getInstance()
        val maps = client.getAllMaps()

        maps.enqueue(object : retrofit2.Callback<Maps>{
            override fun onResponse(call: Call<Maps>, response: Response<Maps>) {
                val dataMapsList = ArrayList<String>()
                for (i in response.body()!!.data){
                    if (i.description != null){
                        val dataMaps = DataMaps(i.displayName, i.description)
                        dataMapsList.add("""
                        ${dataMaps.displayName}
                        ${dataMaps.description}
                    """.trimIndent()
                        )
                    }
                }
                val listAdapter = ArrayAdapter(
                    this@MainActivity2,
                    android.R.layout.simple_list_item_1,
                    dataMapsList
                )
                binding.lsView.adapter = listAdapter            }

            override fun onFailure(call: Call<Maps>, t: Throwable) {

            }

        })


    }
}