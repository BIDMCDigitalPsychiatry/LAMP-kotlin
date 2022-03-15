package digital.lamp.lamp_kotlin.lamp_core.infrastructure;

import androidx.annotation.Nullable;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonQualifier;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Type;
import java.util.Set;

@Retention(RetentionPolicy.RUNTIME)
@JsonQualifier
public @interface SerializeNulls {
    JsonAdapter.Factory JSON_ADAPTER_FACTORY = new JsonAdapter.Factory() {
        @Nullable
        @Override
        public JsonAdapter<?> create(Type type, Set<? extends Annotation> annotations, Moshi moshi) {
            Set<? extends Annotation> nextAnnotations =
                    Types.nextAnnotations(annotations, SerializeNulls.class);
            if (nextAnnotations == null) {
                return null;
            }
            return moshi.nextAdapter(this, type, nextAnnotations).serializeNulls();
        }


    };
}