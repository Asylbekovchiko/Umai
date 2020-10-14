package ru.mitapp.umai.localstorage

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

private const val IS_FIRST_START = "is_first_start"
private const val UMAI_PREFERENCE = "UmaiPrefs"
private const val THEME_PREFERENCE = "ThemePrefs"


class SharedPreference(context: Context){

    private var pref: SharedPreferences =
        context.getSharedPreferences(UMAI_PREFERENCE, Context.MODE_PRIVATE)

    var clear: SharedPreferences.Editor = pref.edit().clear()

    var isFirstStart: Boolean
        get() {
            return pref.getBoolean(IS_FIRST_START, true)
        }
        set(value) {
            pref.edit {
                putBoolean(IS_FIRST_START, value)
            }
        }

    var theme : String?
    get() {
        return pref.getString(THEME_PREFERENCE, "light")
    }

    set(value) = pref.edit {
        putString(THEME_PREFERENCE, value)
    }

}