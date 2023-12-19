package digital.lamp.lamp_kotlin.lamp_core.models

import com.squareup.moshi.JsonClass
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.SerializeNulls

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
        val battery_level: Float?,
        val address: String?,
        val name: String?,
        val strength: Int?,
        val steps: Int?,
        val systolic: BloodPressureData?,
        val diastolic: BloodPressureData?,
        val unit: String?,
        val value: Any?,
        val type: Any?,
        val activity: ActivityData?,
        var source: Any?,
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
        val type: String,
        val payload: String,
        val user_agent: String
)

data class TokenData(
        var type: String,
        var device_token: String?,
        var device_type: String,
        var user_agent: String
) {
    constructor() : this("", null, "", "")
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
    constructor() : this(null, null, null, null, null, null, null)
}
@JsonClass(generateAdapter = true)
data class BloodPressureData(
        val value: Float,
        val units: String?,
        @field:[SerializeNulls]
        var source: Any?
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
        var type: String,
)

data class TelephonyData(
        val duration: Long?,
        val type: String?
)
@JsonClass(generateAdapter = true)
data class StepsData(
        val unit: String?,
        val value: Any?,
        val type: Any?,
        @field:[SerializeNulls]
         var source: Any?,
)
@JsonClass(generateAdapter = true)
data class NutritionData(
        val unit: String?,
        val value: Any?,
        val type: Any?,
        @field:[SerializeNulls] var source: Any?,
)
@JsonClass(generateAdapter = true)
data class GoogleFitData(
        val unit: String?,
        val value: Any?,
        @field:[SerializeNulls] var source: Any?,
)
@JsonClass(generateAdapter = true)
data class BloodPressure(

        val systolic: BloodPressureData?,
        val diastolic: BloodPressureData?,
)
@JsonClass(generateAdapter = true)
data class SleepData(
        val representation: String?,
        val value: Any?,
        @field:[SerializeNulls] var source: Any?,
        val duration: Long?
)
