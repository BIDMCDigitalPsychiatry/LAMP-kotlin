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
 * @param start 
 * @param interval 
 * @param repeatCount 
 * @param end 
 */
@Parcelize

data class DurationInterval (
    @Json(name = "start")
    var start: java.sql.Timestamp? = null,
    @Json(name = "interval")
    var interval: @RawValue kotlin.Array<kotlin.Any>? = null,
    @Json(name = "repeat_count")
    var repeatCount: kotlin.Long? = null,
    @Json(name = "end")
    var end: java.sql.Timestamp? = null
) : Serializable, Parcelable {
	companion object {
		private const val serialVersionUID: Long = 123
	}

}

