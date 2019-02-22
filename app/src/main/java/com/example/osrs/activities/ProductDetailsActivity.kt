package com.example.osrs.activities

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.Gravity
import com.example.osrs.R
import kotlinx.android.synthetic.main.activity_product_details.*
import android.view.LayoutInflater
import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.transition.Slide
import android.widget.*






class ProductDetailsActivity : AppCompatActivity() {

    private val actors = arrayOf("Zaid","Batool","Amal","Amal2","Amal3")

    private val reviews = arrayOf(
        "Bad Product But Good ",
        "I Like It thank you guys hahah",
        "I Like It thank you guys hahah",
        "I Like It thank you guys hahah",
        "Hey Guys i recommend this product"
    )



    @RequiresApi(Build.VERSION_CODES.KITKAT)
    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val myListAdapter = RatingCustomListAdapter(applicationContext,reviews,actors)
        list_reviews.adapter = myListAdapter

        subImage1.setOnClickListener{

            val inflater:LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            // Inflate a custom view using layout inflater
            val view = inflater.inflate(R.layout.product_image_popup,null)

            // Initialize a new instance of popup window
            val popupWindow = PopupWindow(
                view, // Custom view to show in popup window
                LinearLayout.LayoutParams.WRAP_CONTENT, // Width of popup window
                LinearLayout.LayoutParams.WRAP_CONTENT // Window height
            )
            popupWindow.setOutsideTouchable(true);
            popupWindow.setFocusable(true);


            // Set an elevation for the popup window
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                popupWindow.elevation = 10.0F
            }


            // If API level 23 or higher then execute the code
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                // Create a new slide animation for popup window enter transition
                val slideIn = Slide()
                slideIn.slideEdge = Gravity.TOP
                popupWindow.enterTransition = slideIn

                // Slide animation for popup window exit transition
                val slideOut = Slide()
                slideOut.slideEdge = Gravity.END
                popupWindow.exitTransition = slideOut

            }



            // Set a dismiss listener for popup window
            popupWindow.setOnDismissListener {
                Toast.makeText(applicationContext,"Fuck You",Toast.LENGTH_SHORT).show()
            }


            // Finally, show the popup window on app
            TransitionManager.beginDelayedTransition(test)
            popupWindow.showAtLocation(
                test, // Location to display popup window
                Gravity.CENTER, // Exact position of layout to display popup
                0, // X offset
                0 // Y offset
            )
        }

    } // end onCreate
} // end ProductDetailsActivity
