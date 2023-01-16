package com.example.buttomnavigationbar

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.buttomnavigationbar.databinding.ActivityCalenderBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class CalenderActivity : AppCompatActivity() {

    lateinit var idFuser:EditText
    lateinit var addFAB: FloatingActionButton
    lateinit var delFAB : FloatingActionButton
    lateinit var updFAB: FloatingActionButton
    var fabVisible = false
    lateinit var space1:Space
    lateinit var space2:Space




    private lateinit var binding: ActivityCalenderBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)
        binding = ActivityCalenderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val msg="you are here friend :)"


        idFuser = findViewById(R.id.idfromuser)
        addFAB = findViewById(R.id.idFABAdd)
        delFAB=findViewById(R.id.delete)
        updFAB=findViewById(R.id.update)
        space1=findViewById(R.id.firstnull)
        space2=findViewById(R.id.secondnull)
        fabVisible=false



        binding.bottomNavigationView.setSelectedItemId(R.id.calender);
        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.badge -> {
                    val intent= Intent(this,BadgesActivity::class.java)
                    startActivity(intent)
                }
                R.id.calender -> {
                    Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
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
        addFAB.setOnClickListener {
            // on below line we are checking
            // fab visible variable.
            if (!fabVisible) {

                // if its false we are displaying home fab
                // and settings fab by changing their
                // visibility to visible.
                delFAB.show()
                updFAB.show()

                //textfromuser2FAB.show()

                // on below line we are setting
                // their visibility to visible.
                delFAB.visibility = View.VISIBLE
                updFAB.visibility = View.VISIBLE
                idFuser.visibility=View.VISIBLE

                // on below line we are checking image icon of add fab
                addFAB.setImageDrawable(getDrawable(R.drawable.ic_baseline_close_24))

                // on below line we are changing
                // fab visible to true
                fabVisible = true
            } else {

                space1.visibility= View.VISIBLE
                space2.visibility= View.VISIBLE
                // if the condition is true then we
                // are hiding home and settings fab
                delFAB.hide()
                updFAB.hide()
                //textfromuser2FAB.hide()

                // on below line we are changing the
                // visibility of home and settings fab
                delFAB.visibility = View.GONE
                updFAB.visibility = View.GONE
                idFuser.visibility=View.GONE

                // on below line we are changing image source for add fab
                addFAB.setImageDrawable(getDrawable(R.drawable.ic_baseline_menu_24))

                // on below line we are changing
                // fab visible to false.
                fabVisible = false
            }
        }

    }
}