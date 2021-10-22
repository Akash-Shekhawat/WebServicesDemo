package com.example.webservicesdemo

import android.annotation.SuppressLint
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response





class MainActivity : AppCompatActivity() {

    lateinit var progressProgressDialog:ProgressDialog
    var dataList=ArrayList<MyDataItem>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recyclerviewlist)
        //Adapter

        recyclerView.adapter = MyAdapter(dataList)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        progressProgressDialog= ProgressDialog(this)
        progressProgressDialog.setTitle("Loading")
        progressProgressDialog.setCancelable(false)
        progressProgressDialog.show()

        getMyFunction()

    }

    private fun getMyFunction() {
        val call: Call<List<MyDataItem>> = ApiClient.getClient.getData()

        call.enqueue(object : Callback<List<MyDataItem>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                progressProgressDialog.dismiss()
                dataList.addAll(response.body()!!)

                recyclerView.adapter?.notifyDataSetChanged()
                }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                progressProgressDialog.dismiss()
            }


        })

    }
}