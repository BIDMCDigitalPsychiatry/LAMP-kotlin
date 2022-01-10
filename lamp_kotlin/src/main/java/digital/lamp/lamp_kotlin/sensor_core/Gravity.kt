package digital.lamp.lamp_kotlin.sensor_core

import android.app.Service
import android.content.*
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import android.os.PowerManager
import android.util.Log
import digital.lamp.lamp_kotlin.sensor_core.utils.LampConstants

/**
 * Service that logs gyroscope readings from the device
 *
 * @author df
 */
class Gravity : Service(), SensorEventListener {


    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        //we log accuracy on the sensor changed values
    }

    override fun onSensorChanged(event: SensorEvent) {
        val currentTimeStamp = System.currentTimeMillis()
        if (currentTimeStamp - LAST_TS < interval) return

        val rowData = ContentValues()
        rowData.put(TIMESTAMP, currentTimeStamp)
        rowData.put(VALUES_0, event.values[0])
        rowData.put(VALUES_1, event.values[1])
        rowData.put(VALUES_2, event.values[2])
        rowData.put(ACCURACY, event.accuracy)

        callback(rowData)
        LAST_TS = currentTimeStamp
    }


    override fun onCreate() {
        super.onCreate()
        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        mGravity = mSensorManager!!.getDefaultSensor(Sensor.TYPE_GRAVITY)
        sensorThread = HandlerThread(Companion.TAG)
        sensorThread!!.start()
        val powerManager = getSystemService(POWER_SERVICE) as PowerManager
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,TAG)
        wakeLock?.acquire()
        sensorHandler = Handler(sensorThread!!.looper)

        if (Lamp.DEBUG) Log.d(TAG, "Gyroscope service created!")
    }

    override fun onDestroy() {
        super.onDestroy()
        sensorHandler!!.removeCallbacksAndMessages(null)
        mSensorManager!!.unregisterListener(this, mGravity)
        sensorThread!!.quit()
        wakeLock!!.release()
        if (Lamp.DEBUG) Log.d(TAG, "Gyroscope service terminated...")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
            if (mGravity == null) {
                stopSelf()
            } else {
                val newFrequency = LampConstants.FREQUENCY_GYROSCOPE
                val newThreshold = LampConstants.THRESHOLD_GYROSCOPE
                if (FREQUENCY != newFrequency
                        || THRESHOLD != newThreshold) {
                    sensorHandler!!.removeCallbacksAndMessages(null)
                    mSensorManager!!.unregisterListener(this, mGravity)
                    FREQUENCY = newFrequency
                    THRESHOLD = newThreshold
                }
                mSensorManager!!.registerListener(this, mGravity, newFrequency, sensorHandler)
            }
            if (Lamp.DEBUG) Log.d(TAG, "Gyroscope service active: " + FREQUENCY + "ms")
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    companion object {
        const val TIMESTAMP = "timestamp"
        const val VALUES_0 = "double_values_0"
        const val VALUES_1 = "double_values_1"
        const val VALUES_2 = "double_values_2"
        const val ACCURACY = "accuracy"

        private const val TAG = "LAMP::Gyroscope"
        private var mSensorManager: SensorManager? = null
        private var mGravity: Sensor? = null
        private var sensorThread: HandlerThread? = null
        private var sensorHandler: Handler? = null
        private var wakeLock: PowerManager.WakeLock? = null
        private var LAST_TS: Long = 0
        private var FREQUENCY = -1
        private var THRESHOLD = 0.0

        private var interval :Long = LampConstants.INTERVAL
        lateinit var callback : (ContentValues) -> Unit
        @JvmStatic
        fun setSensorObserver(listener: (ContentValues) -> Unit) {
            callback = listener
        }

        @JvmStatic
        fun setInterval(interval:Long) {
            this.interval = interval
        }
    }
}