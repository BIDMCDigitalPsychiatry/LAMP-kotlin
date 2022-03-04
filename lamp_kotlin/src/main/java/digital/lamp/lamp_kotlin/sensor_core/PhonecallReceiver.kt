package digital.lamp.lamp_kotlin.sensor_core

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager

 class PhonecallReceiver : BroadcastReceiver() {

    private var callStartTime: Long? = null
    private var isIncoming = false

    override fun onReceive(context: Context, intent: Intent) {


        val stateStr = intent.extras!!.getString(TelephonyManager.EXTRA_STATE)
        var state = 0
        if (stateStr == TelephonyManager.EXTRA_STATE_IDLE) {
            state = TelephonyManager.CALL_STATE_IDLE
        } else if (stateStr == TelephonyManager.EXTRA_STATE_OFFHOOK) {
            state = TelephonyManager.CALL_STATE_OFFHOOK
        } else if (stateStr == TelephonyManager.EXTRA_STATE_RINGING) {
            state = TelephonyManager.CALL_STATE_RINGING
        }
        onCallStateChanged(context, state)

    }



    //Deals with actual events
    //Incoming call-  goes from IDLE to RINGING when it rings, to OFFHOOK when it's answered, to IDLE when its hung up
    //Outgoing call-  goes from IDLE to OFFHOOK when it dials out, to IDLE when hung up
    private fun onCallStateChanged(context: Context?, state: Int) {
        if (lastState == state) {
            //No change, debounce extras
            return
        }
        when (state) {
            TelephonyManager.CALL_STATE_RINGING -> {
                isIncoming = true
                // callStartTime = new Date();
                //onIncomingCallReceived(context, callStartTime)

               // context?.startService(Intent(context, Telephony::class.java).setAction(Telephony.ACTION_LAMP_SCREEN_ON))
            }
            TelephonyManager.CALL_STATE_OFFHOOK ->                 //Transition of ringing->offhook are pickups of incoming calls.  Nothing done on them
                if (lastState != state) {
                    if (lastState != TelephonyManager.CALL_STATE_RINGING) {
                        isIncoming = false
                        callStartTime = System.currentTimeMillis()
                       // onOutgoingCallStarted(context, callStartTime)
                    } else {
                        isIncoming = true
                        callStartTime = System.currentTimeMillis()
                       // onIncomingCallAnswered(context, callStartTime)
                    }
                }
            TelephonyManager.CALL_STATE_IDLE ->                 //Went to idle-  this is the end of a call.  What type depends on previous state(s)
                if (lastState == TelephonyManager.CALL_STATE_RINGING) {
                    //Ring but no pickup-  a miss
                  //  onMissedCall(context, callStartTime)
                    context?.startService(Intent(context, TelephonySensor::class.java).setAction(TelephonySensor.ACTION_LAMP_MISSED_CALL))
                } else if (isIncoming) {
                    val intent = Intent(context, TelephonySensor::class.java)
                    intent.putExtra("call_start_time",callStartTime)
                    intent.putExtra("call_end_time",System.currentTimeMillis())
                    intent.setAction(TelephonySensor.ACTION_LAMP_INCOMING_CALL)
                    context?.startService(intent)
                   // onIncomingCallEnded(context, callStartTime, System.currentTimeMillis())
                } else {
                    /*context?.startService(Intent(context, Telephony::class.java).setAction(Telephony.ACTION_LAMP_SCREEN_ON))
                    onOutgoingCallEnded(context, callStartTime, System.currentTimeMillis())*/
                    val intent = Intent(context, TelephonySensor::class.java)
                    intent.putExtra("call_start_time",callStartTime)
                    intent.putExtra("call_end_time",System.currentTimeMillis())
                    intent.setAction(TelephonySensor.ACTION_LAMP_OUTGOING_CALL)
                    context?.startService(intent)
                }
        }
        lastState = state
    }

    companion object {
        //The receiver will be recreated whenever android feels like it.  We need a static variable to remember data between instantiations
        private var lastState = TelephonyManager.CALL_STATE_IDLE
    }
}