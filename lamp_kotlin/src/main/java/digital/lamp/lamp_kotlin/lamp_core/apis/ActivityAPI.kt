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
package digital.lamp.lamp_kotlin.lamp_core.apis

import digital.lamp.lamp_kotlin.lamp_core.infrastructure.*
import digital.lamp.lamp_kotlin.lamp_core.models.Activity
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.ApiClient


class ActivityAPI(basePath: kotlin.String = defaultBasePath) : ApiClient(basePath) {
    companion object {
        @JvmStatic
        val defaultBasePath: String = ""
    }

    /**
    * Get the set of all activities.
    * Get the set of all activities.
    * @param transform  (optional)
    * @return kotlin.Array<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun activityAll(participantId: String,basic: String) : Any {
        val localVariableBody: kotlin.Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        localVariableHeaders.apply {
            put("Authorization",basic)
        }
        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/participant/{participant_id}/activity".replace("{" + "participant_id" + "}", participantId),
                query = localVariableQuery,
                headers = localVariableHeaders
        )
        val localVarResponse = request<kotlin.Array<kotlin.Any>>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as Any
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
    * Get all activities for a participant.
    * Get the set of all activities available to a participant, by  participant identifier.
    * @param participantId  
    * @param transform  (optional)
    * @return kotlin.Array<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun activityAllByParticipant(participantId: kotlin.String, transform: kotlin.String?) : kotlin.Array<kotlin.Any> {
        val localVariableBody: kotlin.Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (transform != null) {
                    put("transform", listOf(transform.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/participant/{participant_id}/activity".replace("{"+"participant_id"+"}", "$participantId"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<kotlin.Array<kotlin.Any>>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.Array<kotlin.Any>
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
    * Get all activities for a researcher.
    * Get the set of all activities available to participants of any study  conducted by a researcher, by researcher identifier.
    * @param researcherId  
    * @param transform  (optional)
    * @return kotlin.Array<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun activityAllByResearcher(researcherId: kotlin.String, transform: kotlin.String?) : kotlin.Array<kotlin.Any> {
        val localVariableBody: kotlin.Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (transform != null) {
                    put("transform", listOf(transform.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/researcher/{researcher_id}/activity".replace("{"+"researcher_id"+"}", "$researcherId"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<kotlin.Array<kotlin.Any>>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.Array<kotlin.Any>
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
    * Get all activities in a study.
    * Get the set of all activities available to  participants of a single  study, by study identifier.
    * @param studyId  
    * @param transform  (optional)
    * @return kotlin.Array<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun activityAllByStudy(studyId: kotlin.String, transform: kotlin.String?) : kotlin.Array<kotlin.Any> {
        val localVariableBody: kotlin.Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (transform != null) {
                    put("transform", listOf(transform.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/study/{study_id}/activity".replace("{"+"study_id"+"}", "$studyId"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<kotlin.Array<kotlin.Any>>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.Array<kotlin.Any>
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
    * Create a new Activity under the given Study.
    * Create a new Activity under the given Study.
    * @param studyId  
    * @param activity  
    * @return kotlin.String
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun activityCreate(studyId: kotlin.String, activity: Activity) : kotlin.String {
        val localVariableBody: kotlin.Any? = activity
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/study/{study_id}/activity".replace("{"+"study_id"+"}", "$studyId"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<kotlin.String>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.String
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
    * Delete an Activity.
    * Delete an Activity.
    * @param activityId  
    * @return kotlin.String
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun activityDelete(activityId: kotlin.String) : kotlin.String {
        val localVariableBody: kotlin.Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        val localVariableConfig = RequestConfig(
            RequestMethod.DELETE,
            "/activity/{activity_id}".replace("{"+"activity_id"+"}", "$activityId"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<kotlin.String>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.String
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
    * Update an Activity&#39;s settings.
    * Update an Activity&#39;s settings.
    * @param activityId  
    * @param activity  
    * @return kotlin.String
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun activityUpdate(activityId: kotlin.String, activity: Activity) : kotlin.String {
        val localVariableBody: kotlin.Any? = activity
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        val localVariableConfig = RequestConfig(
            RequestMethod.PUT,
            "/activity/{activity_id}".replace("{"+"activity_id"+"}", "$activityId"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<kotlin.String>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.String
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
    * Get a single activity, by identifier.
    * Get a single activity, by identifier.
    * @param activityId  
    * @param transform  (optional)
    * @return kotlin.Array<kotlin.Any>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun activityView(activityId: kotlin.String, transform: kotlin.String?) : kotlin.Array<kotlin.Any> {
        val localVariableBody: kotlin.Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (transform != null) {
                    put("transform", listOf(transform.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/activity/{activity_id}".replace("{"+"activity_id"+"}", "$activityId"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<kotlin.Array<kotlin.Any>>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.Array<kotlin.Any>
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
