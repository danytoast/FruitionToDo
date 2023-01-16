package com.example.buttomnavigationbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.buttomnavigationbar.databinding.ActivityMainBinding
import android.view.ViewGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.view.View.GONE
import android.view.View.VISIBLE
import android.content.ContentValues

val count:Int = 3
class MainActivity : AppCompatActivity() {
//this the one from her lappy

    ////this is the one hehehhhehe
    lateinit var addFAB: FloatingActionButton
    lateinit var newthingsFAB: FloatingActionButton
    lateinit var textfromuser2FAB: EditText
    var fabVisible = false


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val msg="you are here friend :)"
        //replaceFragment(Todo())//to make the to do fragment the defult start fragment

        addFAB=findViewById(R.id.idFABAdd)
        newthingsFAB=findViewById(R.id.newthings)
        textfromuser2FAB=findViewById(R.id.textfromuser)


        fabVisible=false

        //for the querey it will be dislplayed in it's own activity oncreate
        //to access the data we need corsur var





        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.badge -> {
                    val intent= Intent(this,BadgesActivity::class.java)
                    startActivity(intent)
                }
                R.id.calender -> {
                    val intent= Intent(this,CalenderActivity::class.java)
                    startActivity(intent)
                }
                R.id.todo ->{
                    Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
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

                newthingsFAB.show()
                //textfromuser2FAB.show()

                // on below line we are setting
                // their visibility to visible.
                newthingsFAB.visibility = VISIBLE
                textfromuser2FAB.visibility = VISIBLE

                // on below line we are checking image icon of add fab
                addFAB.setImageDrawable(getDrawable(R.drawable.ic_baseline_close_24))

                // on below line we are changing
                // fab visible to true
                fabVisible = true
            } else {

                // if the condition is true then we
                // are hiding home and settings fab
                newthingsFAB.hide()
                //textfromuser2FAB.hide()

                // on below line we are changing the
                // visibility of home and settings fab
                newthingsFAB.visibility = GONE
                textfromuser2FAB.visibility = GONE

                // on below line we are changing image source for add fab
                addFAB.setImageDrawable(getDrawable(R.drawable.ic_baseline_add_circle_24))

                // on below line we are changing
                // fab visible to false.
                fabVisible = false
            }
        }

        newthingsFAB.setOnClickListener() {
            val textfromuser: EditText = findViewById(R.id.textfromuser)

            Toast.makeText(this, (textfromuser.text.toString()), Toast.LENGTH_SHORT).show()



            addCheckbox(textfromuser.text.toString())
        }
        textfromuser2FAB.setOnClickListener {
            // on below line we are displaying a toast message
            Toast.makeText(this@MainActivity, "Settings clicked..", Toast.LENGTH_LONG).show()
        }


    }
   /* private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }*/
   private fun addCheckbox(textF :String){

       var rs = contentResolver.query(TasksProvider.CONTENT_URI, arrayOf(
           TasksProvider._ID,
           TasksProvider.task_name,
           TasksProvider.has_alarm,
           TasksProvider.is_checked
       ),null,null,null)

       //create the db vales
       /*var cv = ContentValues()
       cv.put(TasksProvider.task_name,"hello")
       cv.put(TasksProvider.has_alarm,0)
       cv.put(TasksProvider.is_checked,0)
       contentResolver.insert(TasksProvider.CONTENT_URI,cv)*/

       // Create CheckBox

           val checkBox = CheckBox(this)
           checkBox.hint = textF
           checkBox.id= count
           checkBox.layoutParams = LinearLayout.LayoutParams(
               ViewGroup.LayoutParams.MATCH_PARENT,
               ViewGroup.LayoutParams.WRAP_CONTENT
           )
           checkBox.setPadding(20, 20, 20, 20)
           checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
               val msg =
                   "You have " + (if (isChecked) "checked" else "unchecked") + checkBox.id+ "Checkbox."
               Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
           }






           // Add CheckBox to LinearLayout
           binding.rootContainer.addView(checkBox)
           count.inc()



       }

}


