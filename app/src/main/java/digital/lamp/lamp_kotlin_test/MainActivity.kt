package digital.lamp.lamp_kotlin_test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import digital.lamp.lamp_kotlin.lamp_core.apis.ActivityAPI
import digital.lamp.lamp_kotlin.lamp_core.models.ActivityResponse
import digital.lamp.lamp_kotlin.sensor_core.Lamp
import digital.lamp.lamp_kotlin.sensor_core.TelephonySensor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        invokeSensorSpecData()
        Lamp.startTelephony(this)

        TelephonySensor.setSensorObserver(object :TelephonySensor.TelephonyListener{
            override fun onIncomingCallEnded(callDuration: Double?) {
                Log.e("MainActivity", "Incoming callDuration $callDuration")
            }

            override fun onOutgoingCallEnded(callDuration: Double?) {
                Log.e("MainActivity", "Incoming callDuration $callDuration")
            }

            override fun onMissedCall() {
                Log.e("MainActivity", "Missed")
            }

        })

    }

    private fun invokeSensorSpecData(){

            val basic = "Basic ${Utils.toBase64(
                    "U3039047323@lamp.com:U3039047323")}"

            Thread {
                // Do network action in this function
                val activityString = ActivityAPI("https://lampv2.zcodemo.com:9093/").activityAll("U3039047323",basic)
                val activityResponse = Gson().fromJson(activityString.toString(), ActivityResponse::class.java)

                Log.e("KOK", " Lamp Core Response -  ${activityResponse.data[0].schedule?.get(0)?.notification_ids?.size.toString()}")
            }.start()



    }
}