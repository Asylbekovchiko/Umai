package ru.mitapp.umai.localstorage

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

private const val IS_FIRST_START = "is_first_start"
private const val IS_CITIZEN = "is_citizen"
private const val IS_DARK_THEM = "is_dark_theme"
private const val UMAI_PREFERENCE = "UmaiPrefs"
private const val THEME_PREFERENCE = "ThemePrefs"
private const val TOKEN = "token"
private const val LANGUAGE = "lan"


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

    var token: String?
        get() {
            return pref.getString(TOKEN, null)
        }
        set(value) {
            pref.edit {
                putString(TOKEN, value)
            }
        }

    var language: String?
        get() {
            return pref.getString(LANGUAGE, "ru")
        }
        set(value){
            pref.edit{
                putString(LANGUAGE, value)
            }
        }

    var theme : String?
    get() {
        return pref.getString(THEME_PREFERENCE, "light")
    }

    set(value) = pref.edit {
        putString(THEME_PREFERENCE, value)
    }

    var isCitizen : Boolean
    get() {
        return pref.getBoolean(IS_CITIZEN, true)
    }

    set(value) {
        pref.edit{
            putBoolean(IS_CITIZEN, value)
        }
    }



    var isDarkThem : Boolean
        get() {
            return pref.getBoolean(IS_DARK_THEM, false)
        }

        set(value) {
            pref.edit{
                putBoolean(IS_DARK_THEM, value)
            }
        }



}