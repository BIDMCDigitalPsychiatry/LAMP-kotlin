/**
* LAMP Platform
* The LAMP Platform API.
*
* The version of the OpenAPI document: 1.0.0
* Contact: team@digitalpsych.org
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package digital.lamp.lamp_kotlin.lamp_core.models



import com.squareup.moshi.Json
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

import java.io.Serializable
/**
 * 
 * @param repeatType 
 * @param date 
 * @param customTimes 
 */
@Parcelize
data class DurationIntervalLegacy (
    @Json(name = "repeat_interval")
    var repeat_interval: kotlin.String? = null,
    @Json(name = "start_date")
    var start_date: @RawValue Any? = null,
    @Json(name = "time")
    var time: @RawValue Any? = null,
    @Json(name = "customTimes")
    var custom_time: @RawValue ArrayList<Any>? = null,
    @Json(name = "notificationIds")
    var notification_ids: @RawValue ArrayList<Any>? = null
) : Serializable, Parcelable {
	companion object {
		private const val serialVersionUID: Long = 123
	}

}

