package digital.lamp.lamp_kotlin.lamp_core.infrastructure

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.Date

object Serializer {
    @JvmStatic
    val moshiBuilder: Moshi.Builder = Moshi.Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
        .add(OffsetDateTimeAdapter())
        .add(LocalDateTimeAdapter())
        .add(LocalDateAdapter())
        .add(UUIDAdapter())
        .add(ByteArrayAdapter())
            .add(SerializeNulls.JSON_ADAPTER_FACTORY)
        .addLast(KotlinJsonAdapterFactory())


    @JvmStatic
    val moshi: Moshi by lazy {
        moshiBuilder.build()


    }
}
