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

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
/**
 * 
 * @param `in` 
 * @param at 
 * @param on 
 * @param by 
 */
@Parcelize

data class AccessCitation (
    @Json(name = "in")
    var `in`: kotlin.String? = null,
    @Json(name = "at")
    var at: kotlin.String? = null,
    @Json(name = "on")
    var on: java.sql.Timestamp? = null,
    @Json(name = "by")
    var by: kotlin.String? = null
) : Serializable, Parcelable {
	companion object {
		private const val serialVersionUID: Long = 123
	}

}

