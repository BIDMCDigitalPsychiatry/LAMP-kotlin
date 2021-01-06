package digital.lamp.mindlamp.sensor

import android.content.Context
import digital.lamp.Lamp
import digital.lamp.Rotation
import digital.lamp.mindlamp.R
import digital.lamp.mindlamp.network.model.*
import digital.lamp.models.RotationData
import digital.lamp.models.SensorEvent
import digital.lamp.mindlamp.utils.LampLog
import digital.lamp.mindlamp.utils.Utils
import digital.lamp.models.DimensionData

/**
 * Created by ZCO Engineering Dept. on 06,February,2020
 */
class RotationData constructor(sensorListener: SensorListener, context: Context){
    init {
        try {
            Lamp.startRotation(context)//start Sensor
            //Sensor Observer
            Rotation.setSensorObserver {
                val x = it.getAsDouble(Rotation.VALUES_0)
                val y = it.getAsDouble(Rotation.VALUES_1)
                val z = it.getAsDouble(Rotation.VALUES_2)
                //val value=it.
                val rotationData =
                    RotationData(x, y, z)
                val data = DimensionData(
                    null,
                    null,
                    null,
                    rotationData,
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
                    null,null,null,null
                )
                val sensorEventData =
                    SensorEvent(
                        data,
                        "lamp.accelerometer.motion",System.currentTimeMillis().toDouble()
                    )
                LampLog.e("Rotation : $x : $y : $z")
                sensorListener.getRotationData(sensorEventData)
            }
        }catch (ex : Exception){
            val logEventRequest = LogEventRequest()
            logEventRequest.message = context.getString(R.string.log_rotation_error)
            LogUtils.invokeLogData(Utils.getApplicationName(context), context.getString(R.string.error), logEventRequest)
        }
    }
}