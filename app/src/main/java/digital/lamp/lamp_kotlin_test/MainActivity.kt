package digital.lamp.lamp_kotlin_test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import digital.lamp.lamp_kotlin.lamp_core.apis.ActivityAPI
import digital.lamp.lamp_kotlin.lamp_core.apis.SensorAPI
import digital.lamp.lamp_kotlin.lamp_core.models.ActivityResponse
import digital.lamp.lamp_kotlin.lamp_core.models.DimensionData
import digital.lamp.lamp_kotlin.lamp_core.models.SensorSpec
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        invokeSensorSpecData()

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