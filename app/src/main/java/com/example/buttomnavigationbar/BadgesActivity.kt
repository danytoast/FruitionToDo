package com.example.buttomnavigationbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.buttomnavigationbar.databinding.ActivityBadgesBinding
import android.widget.*


class BadgesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBadgesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBadgesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val msg="you are here friend :)"
        binding.bottomNavigationView.setSelectedItemId(R.id.badge);
        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.badge -> {
                    Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
                }
                R.id.calender -> {
                    val intent= Intent(this,CalenderActivity::class.java)
                    startActivity(intent)
                }
                R.id.todo ->{
                    val intent= Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                else-> {

                }
            }
            true
        }

        val task3:Button= findViewById(R.id.badge3)
        val task5:Button= findViewById(R.id.badge4)
        val night:Button= findViewById(R.id.badge1)

        task3.setOnClickListener(){
            Toast.makeText(this,"finish three tasks in one day!",Toast.LENGTH_LONG).show()
        }
        task5.setOnClickListener(){
            Toast.makeText(this,"finish five tasks in one day!",Toast.LENGTH_LONG).show()
        }
        night.setOnClickListener(){
            Toast.makeText(this,"finish 10 tasks after 10pm!",Toast.LENGTH_LONG).show()
        }

    }
}