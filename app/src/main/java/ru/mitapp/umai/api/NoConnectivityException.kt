package ru.mitapp.umai.api

import java.io.IOException

class NoConnectivityException : IOException() {
    override fun getLocalizedMessage(): String? {
        return "No connectivity exception"
    }
}