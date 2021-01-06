package digital.lamp.mindlamp.sensor

import android.content.Context
import digital.lamp.ActivityTransitions
import digital.lamp.Lamp
import digital.lamp.mindlamp.R
import digital.lamp.models.ActivityData
import digital.lamp.mindlamp.network.model.LogEventRequest
import digital.lamp.models.SensorEvent
import digital.lamp.models.DimensionData
import digital.lamp.mindlamp.utils.LampLog
import digital.lamp.mindlamp.utils.Utils

class ActivityTransitionData constructor(sensorListener: SensorListener, context: Context) {

    companion object {
        private val TAG = ActivityTransitionData::class.java.simpleName
    }

    init {
        try {

            Lamp.startActivityTransition(context)//start sensor

            //Sensor Observer
            ActivityTransitions.setSensorObserver { activityType, transitionType ->
                val activityData = ActivityData()
                when(activityType) {
                    "running" -> { activityData.running = transitionType}
                    "cycling" -> { activityData.cycling = transitionType}
                    "in_car" -> { activityData.automotive = transitionType}
                    "stationary" -> { activityData.stationary = transitionType}
                    "unknown" -> { activityData.unknown = transitionType}
                    "walking" -> { activityData.walking = transitionType}
                    "on_foot" -> { activityData.on_foot = transitionType}
                }
                val dimensionData =
                    DimensionData(
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
                        null,
                        null,
                        null,
                        null,null,null,activityData
                    )
                val sensorEventData =
                    SensorEvent(
                        dimensionData,
                        "lamp.activity_recognition",System.currentTimeMillis().toDouble()
                    )

                LampLog.e("Activity Transition : $activityData")
                sensorListener.getActivityData(sensorEventData)
            }
        }catch (ex:Exception){
            ex.printStackTrace()
            val logEventRequest = LogEventRequest()
            logEventRequest.message = context.getString(R.string.log_activity_error)
            LogUtils.invokeLogData(Utils.getApplicationName(context), context.getString(R.string.error), logEventRequest)
        }
    }
}