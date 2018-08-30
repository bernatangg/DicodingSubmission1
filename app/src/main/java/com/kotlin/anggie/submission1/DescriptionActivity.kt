package com.kotlin.anggie.submission1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DescriptionActivity : AppCompatActivity() {
    companion object {
        const val Title = "title"
        const val Image = "image"
        const val Description = "description"
    }

    private var title: String = ""
    private var logo : Int = 0
    private var description: String = ""

    lateinit var mTitle: TextView
    lateinit var mLogo : ImageView
    lateinit var mDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(16)

            mLogo = imageView().lparams(width = dip(100),
                    height = wrapContent) {
                gravity = Gravity.CENTER
            }

            mTitle = textView().lparams(width = wrapContent) {
                gravity = Gravity.CENTER
                topMargin  = dip(10)
            }

            mDescription = textView().lparams(width = wrapContent) {
                topMargin = dip(20)
                leftMargin = dip(20)
                rightMargin = dip(20)
            }

        }

        logo = intent.getIntExtra(Image, 0)
        title = intent.getStringExtra(Title)
        description = intent.getStringExtra(Description)

        Glide.with(mLogo).load(logo).into(mLogo)
        mTitle.text = title
        mDescription.text = description

    }
}