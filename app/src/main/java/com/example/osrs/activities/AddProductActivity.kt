package com.example.osrs.activities

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.Toolbar
import android.text.InputType
import android.widget.DatePicker
import android.widget.Toast
import com.example.osrs.Prefs
import com.example.osrs.R
import com.example.osrs.services.ServiceVolley
import kotlinx.android.synthetic.main.activity_add_product.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*


class AddProductActivity : AppCompatActivity() {
    var picker: DatePickerDialog? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        val Prefs = Prefs(this)

        var mToolbar: Toolbar = findViewById(R.id.too)
        setSupportActionBar(mToolbar)
        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Add Product"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)











        addProductBtn.setOnClickListener {
            var CarInfo = hashMapOf<String,Any>()
//            CarInfo["asdmkm"] = carBrandSpinner.selectedItem.toString()
//            CarInfo["name"] = carModelSpinner.selectedItem.toString()






            if(fieldsValidation()==true){
                ServiceVolley().addProduct(carBrandEt.text.toString(),carModelEt.text.toString()
                    ,yearOfMakeEt.text.toString(),engineCylindersSpinner.selectedItem.toString(),
                    transmissionSpinner.selectedItem.toString(),carPrice.text.toString().toDouble(),
                    carMileage.text.toString().toDouble(),extColor.text.toString(),intColor.text.toString(),
                    productDescriptionEt.text.toString(),
                    productTypeSp.selectedItemId,Prefs.userId.toInt(),this)
            }else{
                Toast.makeText(
                    this, " Fill the fields please ",Toast.LENGTH_LONG
                ).show()
            }


        } // end addProductBtn.setOnClickListener




// } // end yearOfMake.setOnClickListener
    } // end onCreate

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    } // end onSupportNavigateUp








    private fun fieldsValidation():Boolean{




        if(carBrandEt.text.toString()==""){
            return false
        }
        if(carModelEt.text.toString()==""){
            return false
        }

        if(yearOfMakeEt.text.toString()==""){
            return false
        }

        if(engineCylindersSpinner.selectedItem.toString() == "" || engineCylindersSpinner.selectedItem.toString().equals("Type of Engine")){
            return false
        }
        if(transmissionSpinner.selectedItem.toString() == "" || transmissionSpinner.selectedItem.toString().equals("Type of Transmission")){
            return false
        }

        if(carPrice.text.toString()==""){
            return false
        }
        if(carMileage.text.toString()=="" ){
            return false
        }
        if(extColor.text.toString()=="" ){
            return false
        }
        if(intColor.text.toString()=="" ){
            return false
        }
        if(productDescriptionEt.text.toString() ==""){
            return false
        }
        return true
    } // end checkNull

} // end AddProductActivity
