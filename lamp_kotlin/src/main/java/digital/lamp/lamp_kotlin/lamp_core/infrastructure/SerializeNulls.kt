package digital.lamp.lamp_kotlin.lamp_core.infrastructure

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.SerializeNulls
import java.lang.reflect.Type

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class SerializeNulls {
    companion object {
        var JSON_ADAPTER_FACTORY: JsonAdapter.Factory = object : JsonAdapter.Factory {
            override fun create(type: Type, annotations: Set<Annotation?>, moshi: Moshi): JsonAdapter<*>? {
                val nextAnnotations = Types.nextAnnotations(annotations, SerializeNulls::class.java)
                        ?: return null
                return moshi.nextAdapter<Any>(this, type, nextAnnotations).serializeNulls()
            }
        }
    }
}