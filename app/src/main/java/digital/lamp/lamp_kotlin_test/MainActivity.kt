package digital.lamp.lamp_kotlin_test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import digital.lamp.lamp_kotlin.lamp_core.apis.SensorAPI
import digital.lamp.lamp_kotlin.lamp_core.models.DimensionData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        invokeSensorSpecData()

    }

    private fun invokeSensorSpecData(){

            val basic = "Basic ${Utils.toBase64(
                    "U7832470994@lamp.com:U7832470994")}"

            Thread {
                // Do network action in this function
                val state = SensorAPI("https://api-staging.lamp.digital/").sensorAll("U7832470994", basic)
                Log.e("KOK", " Lamp Core Response -  ${state.toString()}")
            }.start()

    }
}