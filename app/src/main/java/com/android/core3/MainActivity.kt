package com.android.core3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.core3.R
import kotlinx.android.synthetic.main.activity_medals_detail.*
import kotlinx.android.synthetic.main.rv_medals_list.*
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity(){

    lateinit var sortedMedalsList:List<String>
    val medalsFileData:ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //Reading Data From csv file From Resoucre raw folder
        val mininput = InputStreamReader(resources.openRawResource(R.raw.medallists))
        val reader = BufferedReader(mininput)
        var line : String?
        while (reader.readLine().also { line = it } != null){
            val row : List<String> = line!!.split("@")
            medalsFileData.add(row[0])
        }
        sortedMedalList(medalsFileData)

    }



    //on base of number of medals  data set
    private fun sortedMedalList(list:ArrayList<String>){
         sortedMedalsList =  list.sortedByDescending { it.split(",")[3].toInt()}
        val medalAdapter = MedalListAdapter(sortedMedalsList,this)
        val medalRecylerView = findViewById<RecyclerView>(R.id.rvMedalList)
        medalRecylerView.adapter = medalAdapter
        Log.d("SortedData",sortedMedalsList.toString())

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if(item.itemId == R.id.miLastClick){
           val intent = Intent(this, MedalDetailActivity::class.java)
           startActivity(intent)
       }
        return true

    }


}