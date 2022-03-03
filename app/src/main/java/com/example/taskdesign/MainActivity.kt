package com.example.taskdesign

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.profile.*
import java.time.LocalDate
import java.time.Period
import java.util.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)



        val c=Calendar.getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)

//        val dob_textEdit= findViewById<EditText>(R.id.dob_textEdit)

//        dob_textEdit.inputType = InputType.TYPE_NULL;
        dob_textEdit.showSoftInputOnFocus = false



       dob_textEdit.setOnClickListener{
           val dpd=
               DatePickerDialog(
                   this,
                   { _, mYear, mMonth, mDay ->

                       dob_textEdit.text =Editable.Factory.getInstance().newEditable(" $mDay/$mMonth/$mYear")
                       var age=getAge(mYear, mMonth, mDay)
                       ageText.text=("$age Years Old").toString()

                   },
                   year,
                   month,
                   day
               )
           dpd.show()

        }



   val editor=object:TextWatcher{

       override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


       }

       override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

       }

       override fun afterTextChanged(s: Editable?) {
//

            if (heightEdit.text.isNotEmpty() && weightEdit.text.isNotEmpty()) {
                val h = (heightEdit.text).toString().toDouble()
                val w = (weightEdit.text).toString().toDouble()
                val result = 703 * w / (h * h)
                val f: String = "%.2f".format(result)

                display_txt.text = "Body Mass Index (BMI)   $f Kgs/m2"

            }
        }



   }

        weightEdit.addTextChangedListener(editor)
        heightEdit.addTextChangedListener(editor)

    }



    private fun getAge(year: Int, month: Int, day: Int): Int {

        return Period.between(
            LocalDate.of(year,month,day),
            LocalDate.now()
        ).years

    }

}



