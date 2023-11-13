package com.example.tugas11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.tugas11.databinding.ActivityMainBinding
import com.example.tugas11.model.Data
import com.example.tugas11.model.Users
import com.example.tugas11.network.ApiClient
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val client = ApiClient.getInstance()
        val agent = client.getAllAgent()

        agent.enqueue(object : retrofit2.Callback<Users>{
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                val dataAgentList = ArrayList<String>()
                for (i in response.body()!!.data){
                    val dataAgent = Data(i.displayName, i.description)
                    dataAgentList.add("""
                        ${dataAgent.displayName}
                        ${dataAgent.description}
                    """.trimIndent()
                    )
                }
                val listAdapter = ArrayAdapter(
                    this@MainActivity,
                    android.R.layout.simple_list_item_1,
                    dataAgentList
                )
                binding.lsView.adapter = listAdapter
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {

            }

        })


    }
}