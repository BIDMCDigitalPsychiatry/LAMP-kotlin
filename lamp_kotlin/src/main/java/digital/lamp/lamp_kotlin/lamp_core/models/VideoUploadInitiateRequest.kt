package digital.lamp.lamp_kotlin.lamp_core.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class VideoUploadInitiateRequest(
    @Json(name = "participantId")
    var participantId: String,
    @Json(name = "metadata")
    var metadata: VideoUploadMetadata? = null
) : Serializable, Parcelable {
    companion object {
        private const val serialVersionUID: Long = 123
    }
}

@Parcelize
data class VideoUploadMetadata(
    @Json(name = "size")
    var size: Long? = null,
    @Json(name = "duration")
    var duration: Double? = null,
    @Json(name = "codec")
    var codec: String? = null,
    @Json(name = "bitrate")
    var bitrate: Long? = null,
    @Json(name = "frameRate")
    var frameRate: kotlin.Int? = null,
    @Json(name = "height")
    var height: kotlin.Int? = null,
    @Json(name = "width")
    var width: kotlin.Int? = null
) : Serializable, Parcelable {
    companion object {
        private const val serialVersionUID: Long = 123
    }
}

@Parcelize
data class VideoUploadInitiateResponse(
    @Json(name = "id")
    var id: String? = null,
    @Json(name = "parts")
    var parts: List<VideoUploadPart>? = null
) : Serializable, Parcelable {
    companion object {
        private const val serialVersionUID: Long = 123
    }
}

@Parcelize
data class VideoUploadRefreshUrlsRequest(
    @Json(name = "id")
    var id: String,
    @Json(name = "partNumbers")
    var partNumbers: List<Int>
) : Serializable, Parcelable {
    companion object {
        private const val serialVersionUID: Long = 123
    }
}

@Parcelize
data class VideoUploadRefreshUrlsResponse(
    @Json(name = "parts")
    var parts: List<VideoUploadRefreshedPart>? = null,
    @Json(name = "expiresAt")
    var expiresAt: Long? = null
) : Serializable, Parcelable {
    companion object {
        private const val serialVersionUID: Long = 123
    }
}

@Parcelize
data class VideoUploadRefreshedPart(
    @Json(name = "partNumber")
    var partNumber: Int? = null,
    @Json(name = "startByte")
    var startByte: Long? = null,
    @Json(name = "endByte")
    var endByte: Long? = null,
    @Json(name = "presignedUrl")
    var presignedUrl: String? = null
) : Serializable, Parcelable {
    companion object {
        private const val serialVersionUID: Long = 123
    }
}

@Parcelize
data class VideoUploadPart(
    @Json(name = "partNumber")
    var partNumber: Int? = null,
    @Json(name = "byteRange")
    var byteRange: VideoUploadByteRange? = null,
    @Json(name = "method")
    var method: String? = null,
    @Json(name = "presignedUrl")
    var presignedUrl: String? = null,
    @Json(name = "presignedUrlExpiration")
    var presignedUrlExpiration: Long? = null
) : Serializable, Parcelable {
    companion object {
        private const val serialVersionUID: Long = 123
    }
}

@Parcelize
data class VideoUploadByteRange(
    @Json(name = "start")
    var start: Long? = null,
    @Json(name = "end")
    var end: Long? = null
) : Serializable, Parcelable {
    companion object {
        private const val serialVersionUID: Long = 123
    }
}

@Parcelize
data class VideoUploadCompleteRequest(
    @Json(name = "id")
    var id: String,
    @Json(name = "parts")
    var parts: List<VideoUploadCompletedPart>
) : Serializable, Parcelable {
    companion object {
        private const val serialVersionUID: Long = 123
    }
}

@Parcelize
data class VideoUploadCompletedPart(
    @Json(name = "partNumber")
    var partNumber: Int,
    @Json(name = "etag")
    var etag: String
) : Serializable, Parcelable {
    companion object {
        private const val serialVersionUID: Long = 123
    }
}
