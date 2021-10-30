package com.android.core3

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MedalListAdapter(val MedalsDetailList: List<String>, val myContext:Context):RecyclerView.Adapter<MedalListAdapter.MyViewHolder>() {
   inner class MyViewHolder(v: View) : RecyclerView.ViewHolder(v){

        val mainString =  v.findViewById<TextView>(R.id.tvmainString) as TextView
       val subString =  v.findViewById<TextView>(R.id.tvSubString) as TextView
       val timeString =  v.findViewById<TextView>(R.id.timesTitle) as TextView
       val goldString =  v.findViewById<TextView>(R.id.tvGoldString) as TextView
       val bronzeString =  v.findViewById<TextView>(R.id.tvBronzeString) as TextView
       val silverString =  v.findViewById<TextView>(R.id.tvSilverString) as TextView
       val cvMainView =  v.findViewById<CardView>(R.id.cvMainView) as CardView
       val imageMedal =  v.findViewById<ImageView>(R.id.ivMedal) as ImageView
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflatedView = parent.inflate(R.layout.rv_medals_list, false)
        return MyViewHolder(inflatedView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int){
          val row =  MedalsDetailList[position].split(",")
        holder.mainString.text = row[0]
        holder.subString.text = row[1]
        holder.timeString.text = row[2]+" "+"Times"
        holder.goldString.text =  "Gold"+" "+row[3]
        holder.bronzeString.text = "Bronze"+" "+row[5]
        holder.silverString.text = "Silver"+" "+row[4]
        holder.cvMainView.setOnClickListener{
            val list = MedalsDetailList[position]
            Toast.makeText(myContext,"you've clicked", Toast.LENGTH_SHORT).show()
            val prefrence = myContext.getSharedPreferences("myData",MODE_PRIVATE)
            val editor =  prefrence.edit()
            editor.putString("data",list)
            editor.commit()
            val output = prefrence.getString("data",null)
            Log.d("myData",output.toString())

        }

       if (position < 4){
         holder.imageMedal.visibility = View.VISIBLE
        }else{
           holder.imageMedal.visibility = View.GONE
       }


    }


    override fun getItemCount(): Int {
        return  MedalsDetailList.size
    }


}


fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
