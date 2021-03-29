package ru.mitapp.umai.helper

import android.text.Editable
import android.text.TextWatcher

open class BaseTextChangeListener: TextWatcher {
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun afterTextChanged(p1: Editable?) {

    }
}