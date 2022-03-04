package digital.lamp.lamp_kotlin.lamp_core.models

import android.os.Build

/**
 * Created by ZCO Engineering Dept. on 05,February,2020
 */
data class DimensionData(
        val x: Double?,
        val y: Double?,
        val z: Double?,
        val rotation: RotationData?,
        val motion: MotionData?,
        val gravity: GravityData?,
        val magnetic: MagnetData?,
        val longitude: Double?,
        val latitude: Double?,
        val altitude: Double?,
        val accuracy: Float?,
        val representation: String?,
        val battery_level: Int?,
        val bssid: String?,
        val ssid: String?,
        val rssi: Int?,
        val steps: Int?,
        val systolic: BloodPressureData?,
        val diastolic: BloodPressureData?,
        val unit: String?,
        val value: Any?,
        val type: Any?,
        val activity: ActivityData?,
        val source:String?,
        val duration: Long?
)

data class RotationData(
    val x: Double?,
    val y: Double?,
    val z: Double?
)

data class MotionData(
    val x: Double?,
    val y: Double?,
    val z: Double?
)

data class GravityData(
    val x: Double?,
    val y: Double?,
    val z: Double?
)

data class MagnetData(
    val x: Double?,
    val y: Double?,
    val z: Double?
)

data class NotificationData(
    val action: String,
    val user_action: String?,
    val payload: String
)

data class TokenData(
    var action: String,
    var device_token: String?,
    var device_type: String,
    var user_agent: String
){
    constructor() : this("",null,"", "")
}

data class ActivityData(
    var running: Boolean?,
    var cycling: Boolean?,
    var automotive: Boolean?,
    var stationary: Boolean?,
    var unknown: Boolean?,
    var walking: Boolean?,
    var on_foot: Boolean?,
) {
    constructor() : this(null,null,null,null,null,null,null)
}

data class BloodPressureData(
        val value: Float,
        val units: String?,
        val source: String?
)

data class AttitudeData(
    val x: Double?,
    val y: Double?,
    val z: Double?
)

data class LowPowerModeData(
        var device_type: String,
        var value: Int,
        val user_agent: String,
        var action: String,
)

data class TelephonyData(
    val duration: Int?,
    val trace: String?,
    val type: String?
)