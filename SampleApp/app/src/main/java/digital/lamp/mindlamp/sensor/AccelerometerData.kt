package digital.lamp.mindlamp.sensor

import android.content.Context
import digital.lamp.Accelerometer
import digital.lamp.Lamp
import digital.lamp.mindlamp.R
import digital.lamp.mindlamp.network.model.LogEventRequest
import digital.lamp.mindlamp.utils.LampLog
import digital.lamp.models.SensorEvent
import digital.lamp.models.DimensionData
import digital.lamp.mindlamp.utils.Utils

/**
 * Created by ZCO Engineering Dept. on 05,February,2020
 */
class AccelerometerData constructor(sensorListener: SensorListener, context:Context) {
     init {
         try {
             //Accelerometer settings
             Lamp.startAccelerometer(context)//start sensor
             //Sensor Observer
             Accelerometer.setSensorObserver{
                 val x = it.getAsDouble(Accelerometer.VALUES_0)
                 val y = it.getAsDouble(Accelerometer.VALUES_1)
                 val z = it.getAsDouble(Accelerometer.VALUES_2)
                 val dimensionData =
                     DimensionData(
                         x,
                         y,
                         z,
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
                         null,
                         null,null,null,null
                     )
                 val sensorEventData =
                     SensorEvent(
                         dimensionData,
                         "lamp.accelerometer",System.currentTimeMillis().toDouble()
                     )

                 LampLog.e("Accelerometer : $x : $y : $z")
//                     Aware.stopAccelerometer(context)
                 sensorListener.getAccelerometerData(sensorEventData)
             }
         }catch (ex:Exception){
             ex.printStackTrace()
             val logEventRequest = LogEventRequest()
             logEventRequest.message = context.getString(R.string.log_accelerometer_error)
             LogUtils.invokeLogData(Utils.getApplicationName(context), context.getString(R.string.error), logEventRequest)
         }
    }
}