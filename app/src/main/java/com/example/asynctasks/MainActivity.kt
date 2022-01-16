package com.example.asynctasks

import java.util.concurrent.TimeUnit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.os.AsyncTask
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private var text_view: TextView? = null
    private var start_btn: Button? = null
    private var end_btn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_view = findViewById(R.id.text_view)
        start_btn = findViewById(R.id.button_start)
        end_btn = findViewById(R.id.button_end)
    }

    fun onClick(view: View?) {
        val fakeload = FakeLoading()
        fakeload.execute()
    }

    internal inner class FakeLoading : AsyncTask<Void?, Void?, Void?>() {
        override fun onPreExecute() {
            super.onPreExecute()
            start_btn!!.visibility = View.GONE
            end_btn!!.visibility = View.GONE
            text_view!!.text = "Загружаемся ..."
        }

        protected override fun doInBackground(vararg voids: Void?): Void? {
            try {
               TimeUnit.SECONDS.sleep(5)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return null
        }

        override fun onPostExecute(aVoid: Void?) {
            super.onPostExecute(aVoid)
            start_btn!!.visibility = View.GONE
            end_btn!!.visibility = View.VISIBLE
            text_view!!.text = "Загрузились :)"
        }
    }
}
