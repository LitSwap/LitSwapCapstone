package com.bangkit.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.bangkit.caps.R

class cv_signup_pass: AppCompatEditText {
    private lateinit var ikon: Drawable
    private lateinit var bg: Drawable

    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ){
        init()
    }

    private fun init(){
        bg = ContextCompat.getDrawable(context, R.drawable.ic_blank) as Drawable
        ikon = ContextCompat.getDrawable(context, R.drawable.icons_key) as Drawable

        showLogo()
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val stringPassword = s.toString()
                if(stringPassword.isNotEmpty() && stringPassword.length < 8) {
                    error = "Password Minimum Length is 8"
                } else {
                    error = null
                }

            }

            override fun afterTextChanged(s: Editable) {

            }
        })
    }

    private fun showLogo() {
        setButtonDrawables(startOfTheText = ikon)
    }

    private fun setButtonDrawables(
        startOfTheText: Drawable? = null,
        topOfTheText: Drawable? = null,
        endOfTheText: Drawable? = null,
        bottomOfTheText: Drawable? = null
    ) {
        setCompoundDrawablesWithIntrinsicBounds(
            startOfTheText,
            topOfTheText,
            endOfTheText,
            bottomOfTheText
        )
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        background = bg
        hint = "Password"
        textSize = 14f
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }
}