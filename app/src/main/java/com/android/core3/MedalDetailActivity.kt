package com.android.core3
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MedalDetailActivity: AppCompatActivity(){
    lateinit var pref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medals_detail)
        pref  = getSharedPreferences("myData", Context.MODE_PRIVATE)
        val output = pref.getString("data",null).toString()
        val row = output.split(",")
    val detailmainString = findViewById<TextView>(R.id.detailmainString)
    val detailSubString = findViewById<TextView>(R.id.detailSubString)
    val detailTimeString = findViewById<TextView>(R.id.detailTimeString)
    val detailGoldString = findViewById<TextView>(R.id.detailGoldString)
    val detailBronzeString = findViewById<TextView>(R.id.detailBronzeString)
    val detailSilverString = findViewById<TextView>(R.id.detailSilverString)

        detailmainString.text = row[0]
        detailSubString.text = row[1]
        detailTimeString.text = row[2]+" "+"Times"
        detailGoldString.text = "Gold"+" "+row[3]
        detailBronzeString.text = "Silver"+" "+row[4]
        detailSilverString.text = "Bronze"+" "+row[5]


    }




}