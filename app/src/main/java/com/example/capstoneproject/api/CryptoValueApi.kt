package com.example.capstoneproject.api

import android.content.ContentValues
import android.net.Uri
import java.io.IOException
import java.net.URISyntaxException


class CryptoValueApi {

    private val apiKey = "5e247100-80e1-4e74-99f9-3641950b61cb"

    fun makeCall() {
        val uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";
        val parameters = ContentValues()
        parameters.put("start","1");
        parameters.put("limit","5000");
        parameters.put("convert","USD");

        try {
            val result = MakeApiCall(uri, parameters)
            System.out.println(result)
        }  catch (e: IOException) {
            System.out.println("Error: cannont access content - " + e.toString());
        } catch (e: URISyntaxException) {
            System.out.println("Error: Invalid URL " + e.toString());
        }
    }

    private fun MakeApiCall(uri: String, parameters: ContentValues): Any {
        val response_content = ""

        val builder = Uri.Builder()
        builder.scheme("https").authority(uri).appendQueryParameter("start","1").appendQueryParameter("limit","5000").appendQueryParameter("convert","USD")
        val myUrl = builder.build().toString()

        return "test"
    }

}