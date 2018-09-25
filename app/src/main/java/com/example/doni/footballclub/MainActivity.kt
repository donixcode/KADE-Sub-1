package com.example.doni.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)

        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items) {

            startActivity<DetailActivity>(
                    "club_name" to it.name,
                    "club_image" to it.image,
                    "club_description" to it.description
            )
        }


    }


    //Class For Layout Main Activity

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {


            linearLayout {
                lparams (width = matchParent, height = wrapContent)
                orientation = LinearLayout.VERTICAL
                padding = dip(8)

                recyclerView{
                    lparams (width = matchParent, height = wrapContent)
                    layoutManager = LinearLayoutManager(ctx)
                    id = R.id.club_list
                }

            }

        }
    }



    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val description = resources.getStringArray(R.array.club_description)
        items.clear()

        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0),description[i]))
        }

        //Recycle the typed array
        image.recycle()
    }
}
