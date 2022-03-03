package com.example.taskdesign

import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class Myapplication:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       val desBtn: Button =findViewById(R.id.buttonDesc)
        val ascBtn: Button=findViewById(R.id.buttonAsc)

        val c= Calendar.getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)

//        fun onClick(v: View) {
//
//
//            if (v.id == R.id.buttonDesc) {
//                desBtn.setBackgroundColor(Color.GRAY)
//
//            } else if (v.id == R.id.buttonAsc) {
//                ascBtn.setBackgroundColor(Color.GRAY)
//            }
//        }



            desBtn.setOnClickListener {
                if ( !desBtn.isSelected) {
                    desBtn.setBackgroundColor(Color.GRAY)
                    ascBtn.setBackgroundColor(Color.WHITE)

                } else {

                    desBtn.setBackgroundColor(Color.WHITE)
                }

            }
        ascBtn.setOnClickListener {
            if (!ascBtn.isSelected) {
                ascBtn.setBackgroundColor(Color.GRAY)

                desBtn.setBackgroundColor(Color.WHITE)

            } else {
                ascBtn.setBackgroundColor(Color.WHITE)
            }

        }

        startDate.showSoftInputOnFocus = false
        endDate.showSoftInputOnFocus=false

        startDate.setOnClickListener{
            val dpd=
                DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { _, mYear, mMonth, mDay ->

                        startDate.text = Editable.Factory.getInstance().newEditable(" $mDay/$mMonth/$mYear")


                    },
                    year,
                    month,
                    day
                )
            dpd.show()

        }

        endDate.setOnClickListener{
            val dpd=
                DatePickerDialog(
                    this,
                    DatePickerDialog.OnDateSetListener { _, mYear, mMonth, mDay ->

                        endDate.text = Editable.Factory.getInstance().newEditable(" $mDay/$mMonth/$mYear")


                    },
                    year,
                    month,
                    day
                )
            dpd.show()

        }

//       else
//        {
//
//            ascBtn.setOnClickListener {
////                ascBtn.isSelected != ascBtn.isSelected
//
//                ascBtn.setBackgroundColor(Color.GRAY)
//
//            }
//        }


    }
}