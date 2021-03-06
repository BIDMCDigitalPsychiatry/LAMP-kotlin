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
 * A sensor that may or may not be available on a physical device.
 * @param id A globally unique reference for objects.
 * @param spec A globally unique reference for objects.
 * @param name The name of the sensor.
 * @param settings The configuration settings for the sensor.
 */
@Parcelize

data class Sensor (
    /* A globally unique reference for objects. */
    @Json(name = "id")
    var id: kotlin.String? = null,
    /* A globally unique reference for objects. */
    @Json(name = "spec")
    var spec: kotlin.String? = null,
    /* The name of the sensor. */
    @Json(name = "name")
    var name: kotlin.String? = null,
    /* The configuration settings for the sensor. */
    @Json(name = "settings")
    var settings: @RawValue kotlin.Any? = null
) : Serializable, Parcelable {
	companion object {
		private const val serialVersionUID: Long = 123
	}

}

