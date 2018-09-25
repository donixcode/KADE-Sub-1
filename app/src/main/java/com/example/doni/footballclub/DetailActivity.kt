package com.example.doni.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var clubName : String = ""
    private var clubDescription : String = ""
    private var clubImage : Int = 0

    private lateinit var imageView : ImageView
    private lateinit var name : TextView
    private lateinit var description : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_detail)

        val i = intent
        clubName = i.getStringExtra("club_name")
        clubImage = i.getIntExtra("club_image",1)
        clubDescription = i.getStringExtra("club_description")


        linearLayout {
            lparams (width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            padding = dip(16)

            //Club Image

            imageView = imageView{}.lparams{
                width = dip(100)
                gravity = Gravity.CENTER
                height = dip(100)}

            //Club Team
            name = textView{}.lparams {
                gravity = Gravity.CENTER
                topPadding = dip (16)
            }

            //Club Description
            description = textView{}.lparams{
                width = matchParent
                height = wrapContent
                gravity = Gravity.CENTER
                topPadding = dip (16)
            }

        }

        // Set Image
       // Picasso.get().load(i.getIntExtra("club_image",1)).into(imageView)

        imageView?.let { Picasso.get().load(i.getIntExtra("club_image", 1)).into(imageView) }

        //Set Club Name
        name.text = clubName

        //Set Club Description
        description.text = clubDescription


    }
}
