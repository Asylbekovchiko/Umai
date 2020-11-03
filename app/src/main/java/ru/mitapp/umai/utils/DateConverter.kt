package ru.mitapp.umai.utils

import com.google.gson.Gson
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateConverter {

    fun converterDateToString(dateFormat : String, date : Date) : String{
        val simpleDateFormat  = SimpleDateFormat(dateFormat)

        return simpleDateFormat.format(date)
    }


    fun converterStringToDate(dateFormat : String, dateStr: String): Date? {
        val format = SimpleDateFormat(dateFormat)
        var date: Date? = null
        try {
            date = format.parse(dateStr)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return date
    }


    fun formatDate(formatIn : String, formatTo : String, dateStr : String) : String? {
        val format = SimpleDateFormat(formatIn)
        var date: Date? = null
        try {
            date = format.parse(dateStr)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val simpleDateFormat  = SimpleDateFormat(formatTo)

        return simpleDateFormat.format(date!!)
    }

    fun converterHourToMinutes(dateFormat : String, time : String) : String?{
        val formatHour = SimpleDateFormat("HH")
        val formatMinute = SimpleDateFormat("mm")
        val format = SimpleDateFormat(dateFormat)
        var date : Date? = null
        try {
            date = format.parse(time)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val minutes = formatMinute.format(date!!).toInt()
        val hour = formatHour.format(date).toInt()


        return ((hour * 60) + minutes).toString()
    }


    fun converterMinutesToTime(dateFormat : String, minutes : Long) : String{
        val formatter = SimpleDateFormat(dateFormat)
        val zone = TimeZone.getTimeZone("Etc/GMT")
        val calendar = Calendar.getInstance(zone)
        calendar.timeInMillis = ((minutes * 60) * 1000)
        return formatter.format(calendar.time)
    }

    fun formatHoursAndMinutes(totalMinutes: Int): String? {
        var minutes = (totalMinutes % 60).toString()
        minutes = if (minutes.length == 1) "0$minutes" else minutes
        return (totalMinutes / 60).toString() + "ч " + minutes + "м"
    }

     fun convertIntegerListToString(list : ArrayList<Int>) : String{
        val json = Gson().toJson(list)
        val service = json
            .replace("[", "")
            .replace("]", "")
            .replace("amp;" , "")

        return service
    }
}