package digital.lamp.lamp_kotlin.sensor_core

import android.os.IBinder
import android.os.PowerManager
import android.app.KeyguardManager
import android.app.Service
import android.content.*
import android.location.Location
import android.telephony.TelephonyManager
import android.util.Log
import kotlin.math.floor

/**
 * Service that logs telephony data
 *
 *
 *
 */
class TelephonySensor : Service() {
    private var phoneCallReceiver: PhonecallReceiver? = null

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    interface TelephonyListener {

      //  fun onIncomingCallReceived(ctx: Context?, start: Long?)
       // fun onIncomingCallAnswered(ctx: Context?, start: Long?)
      // fun onOutgoingCallStarted( start: Long?)
        fun onIncomingCallEnded(callDuration:Long?)
        fun onOutgoingCallEnded( callDuration:Long?)
        fun onMissedCall()
    }

    override fun onCreate() {
        super.onCreate()
        if (Lamp.DEBUG) Log.d(TAG, "Telephony service created!")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (phoneCallReceiver != null) unregisterReceiver(phoneCallReceiver)
        if (Lamp.DEBUG) Log.d(TAG, "Telephony service terminated...")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        if(intent!=null) {
            if (intent.action != null) {
                if (intent.action == ACTION_LAMP_MISSED_CALL) {
                    sensorObserver?.onMissedCall()
                    Log.d(TAG, ACTION_LAMP_MISSED_CALL)

                    return START_STICKY
                }
                if (intent.action == ACTION_LAMP_INCOMING_CALL) {
                    if (intent.hasExtra("call_start_time")) {
                        if (intent.hasExtra("call_end_time")) {
                            val startTime = intent.getLongExtra("call_start_time", 0)
                            val endTime = intent.getLongExtra("call_end_time", 0)
                            val callDuration = endTime?.let { end -> startTime?.let { start -> end - start } }
                            callDuration?.let {
                                if (sensorObserver != null) sensorObserver!!.onIncomingCallEnded(callDuration)
                                if (Lamp.DEBUG) Log.d(TAG, ACTION_LAMP_INCOMING_CALL)
                            }
                        }
                    }

                    return START_REDELIVER_INTENT
                }
                if (intent.action == ACTION_LAMP_OUTGOING_CALL) {
                    if (intent.hasExtra("call_start_time")) {
                        if (intent.hasExtra("call_end_time")) {
                            val startTime = intent.getLongExtra("call_start_time", 0)
                            val endTime = intent.getLongExtra("call_end_time", 0)
                            val callDuration = endTime?.let { end -> startTime?.let { start -> end - start } }
                            callDuration?.let {
                                if (sensorObserver != null) sensorObserver!!.onOutgoingCallEnded(callDuration)
                                if (Lamp.DEBUG) Log.d(TAG, ACTION_LAMP_INCOMING_CALL)
                            }
                        }
                    }
                    return START_REDELIVER_INTENT
                }
            }
        }
        if (phoneCallReceiver == null) {
            phoneCallReceiver = PhonecallReceiver()
            val filter = IntentFilter()
            filter.addAction("android.intent.action.PHONE_STATE")
            registerReceiver(phoneCallReceiver, filter)
        }
        if (Lamp.DEBUG) Log.d(TAG, "Telephony service active...")
        return START_REDELIVER_INTENT
    }



    companion object {
        private const val TAG = "LAMP::Telephony"

        /**
         * Broadcasted event: incoming call
         */
         const val ACTION_LAMP_INCOMING_CALL = "ACTION_LAMP_INCOMING_CALL"

        /**
         * Broadcasted event: outgoing call
         */
        const val ACTION_LAMP_OUTGOING_CALL = "ACTION_LAMP_OUTGOING_CALL"

        /**
         * Broadcasted event: missed call
         */
        const val ACTION_LAMP_MISSED_CALL = "ACTION_LAMP_MISSED_CALL"

        private var sensorObserver: TelephonyListener? = null

        @JvmStatic
        fun setSensorObserver(listener: TelephonyListener) {
            sensorObserver = listener
        }

    }



}