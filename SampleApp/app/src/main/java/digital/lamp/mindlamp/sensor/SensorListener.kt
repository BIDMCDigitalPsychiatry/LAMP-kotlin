package digital.lamp.mindlamp.sensor

import digital.lamp.mindlamp.network.model.SensorEventData
import digital.lamp.models.SensorEvent

/**
 * Created by ZCO Engineering Dept. on 05,February,2020
 */
interface SensorListener {
    //Callback to Acclerometer Data
    fun getAccelerometerData(oSensorEvent: SensorEvent)
    //Callback to Rotation Data
    fun getRotationData(oSensorEvent: SensorEvent)
    //Callback to Magnetic Data
    fun getMagneticData(oSensorEvent: SensorEvent)
    //Callback to gyroscope Data
    fun getGyroscopeData(oSensorEvent: SensorEvent)
    //Callback to Location Data
    fun getLocationData(oSensorEvent: SensorEvent)
    //Callback to wifi Data
    fun getWifiData(oSensorEvent: SensorEvent)
    //Callback to ScreenState Data
    fun getScreenState(oSensorEvent: SensorEvent)
    //Callback to Activity Data
    fun getActivityData(oSensorEvent: SensorEvent)
    //Callback to Fitbit Data
    fun getGoogleFitData(sensorEventData: ArrayList<SensorEvent>)
}