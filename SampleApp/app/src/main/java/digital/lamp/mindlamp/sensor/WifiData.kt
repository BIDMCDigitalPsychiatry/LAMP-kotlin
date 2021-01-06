package digital.lamp.mindlamp.sensor

import android.content.ContentValues
import android.content.Context
import digital.lamp.Lamp
import digital.lamp.WiFi
import digital.lamp.mindlamp.R
import digital.lamp.models.DimensionData
import digital.lamp.mindlamp.network.model.LogEventRequest
import digital.lamp.models.SensorEvent
import digital.lamp.mindlamp.utils.LampLog
import digital.lamp.mindlamp.utils.Utils

/**
 * Created by ZCO Engineering Dept. on 06,February,2020
 */
class WifiData constructor(sensorListener: SensorListener, context: Context) {
    init{
        try {
            Lamp.startWiFi(context)//start sensor
            //Sensor Observer
            WiFi.sensorObserver = object : WiFi.LAMPSensorObserver {
                override fun onWiFiScanEnded() {
                }

                override fun onWiFiAPDetected(data: ContentValues?) {
                    if (data != null) {
                        val data = DimensionData(
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            data.getAsString("bssid"),
                            data.getAsString("ssid"),
                            null,
                            null,
                            null,null,null,null
                        )
                        val sensorEventData =
                            SensorEvent(
                                data,
                                "lamp.wifi",System.currentTimeMillis().toDouble()
                            )

                        LampLog.e("Wifi : ${data.bssid}")

                        sensorListener.getWifiData(sensorEventData)
                    }else{
                        val logEventRequest = LogEventRequest()
                        logEventRequest.message = context.getString(R.string.log_wifi_null)
                        LogUtils.invokeLogData(Utils.getApplicationName(context), context.getString(R.string.warning), logEventRequest)
                    }

                }

                override fun onWiFiScanStarted() {
                    LampLog.e("Scan Started")

                }

                override fun onWiFiDisabled() {
                }
            }
        }catch (ex: Exception){
            val logEventRequest = LogEventRequest()
            logEventRequest.message = context.getString(R.string.log_wifi_error)
            LogUtils.invokeLogData(Utils.getApplicationName(context), context.getString(R.string.error), logEventRequest)
        }
    }
}