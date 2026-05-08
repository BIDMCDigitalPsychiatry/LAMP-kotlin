/**
 * LAMP Platform
 * The LAMP Platform API.
 *
 * Dedicated API client for participant video diary multipart upload endpoints
 * (initiate, refresh-urls, complete).
 */
package digital.lamp.lamp_kotlin.lamp_core.apis

import android.util.Log
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.ApiClient
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.ClientError
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.ClientException
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.MultiValueMap
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.RequestConfig
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.RequestMethod
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.ResponseType
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.Serializer
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.ServerError
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.ServerException
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.Success
import digital.lamp.lamp_kotlin.lamp_core.models.VideoUploadCompleteRequest
import digital.lamp.lamp_kotlin.lamp_core.models.VideoUploadInitiateRequest
import digital.lamp.lamp_kotlin.lamp_core.models.VideoUploadRefreshUrlsRequest

class VideoDiaryAPI(basePath: String = defaultBasePath) : ApiClient(basePath) {
    companion object {
        private const val TAG = "VideoDiaryAPI"

        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("digital.lamp.lamp-core.baseUrl", "https://api.lamp.digital")
        }
    }

    /**
     * Initiate a participant video diary upload.
     * Initiate upload metadata for a participant video recording.
     * @param participantId
     * @param videoUploadInitiateRequest
     * @param token Optional bearer/basic authorization header value.
     * @return kotlin.String
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun videoUploadInitiate(
        participantId: String,
        videoUploadInitiateRequest: VideoUploadInitiateRequest,
        token: String? = null
    ): String {
        val localVariableBody: Any? = videoUploadInitiateRequest
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf<String, String>()
            .apply {
                if (token != null) {
                    put("authorization", token)
                }
            }
        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/participant/{participant_id}/video/upload/initiate"
                .replace("{" + "participant_id" + "}", "$participantId"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<String>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as String
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Refresh presigned URLs for a participant video diary upload.
     * Refresh upload URLs for selected multipart upload part numbers.
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun videoUploadRefreshUrls(
        participantId: String,
        videoUploadRefreshUrlsRequest: VideoUploadRefreshUrlsRequest,
        token: String? = null
    ): String {
        val localVariableBody: Any? = videoUploadRefreshUrlsRequest
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf<String, String>()
            .apply {
                if (token != null) {
                    put("authorization", token)
                }
            }
        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/participant/{participant_id}/video/upload/refresh-urls"
                .replace("{" + "participant_id" + "}", "$participantId"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<String>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as String
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Complete a participant video diary upload.
     * Complete a multipart video upload after all presigned parts have been uploaded.
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun videoUploadComplete(
        participantId: String,
        videoUploadCompleteRequest: VideoUploadCompleteRequest,
        token: String? = null
    ): String {
        val localVariableBody: Any? = videoUploadCompleteRequest
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf<String, String>()
            .apply {
                if (token != null) {
                    put("authorization", token)
                }
            }

        Log.d(
            TAG,
            "videoUploadComplete json ${Serializer.moshi.adapter(VideoUploadCompleteRequest::class.java).toJson(videoUploadCompleteRequest)}"
        )
        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/participant/{participant_id}/video/upload/complete"
                .replace("{" + "participant_id" + "}", "$participantId"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<String>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as String
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }
}
