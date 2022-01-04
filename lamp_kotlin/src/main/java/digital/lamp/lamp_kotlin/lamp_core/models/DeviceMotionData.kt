package digital.lamp.lamp_kotlin.lamp_core.models

import digital.lamp.lamp_kotlin.lamp_core.models.GravityData
import digital.lamp.lamp_kotlin.lamp_core.models.MagnetData
import digital.lamp.lamp_kotlin.lamp_core.models.MotionData
import digital.lamp.lamp_kotlin.lamp_core.models.RotationData

data class DeviceMotionData(
    val motion: MotionData?,
    val magnetic: MagnetData?,
    val attitude:AttitudeData?,
    val gravity: GravityData?,
    val rotation: RotationData?
)


