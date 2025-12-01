package digital.lamp.lamp_kotlin.lamp_core.apis

import digital.lamp.lamp_kotlin.lamp_core.apis.SensorAPI.Companion.defaultBasePath
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.ApiClient
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.ClientError
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.ClientException
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.MultiValueMap
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.RequestConfig
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.RequestMethod
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.ResponseType
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.ServerError
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.ServerException
import digital.lamp.lamp_kotlin.lamp_core.infrastructure.Success

class RenewAccessTokenAPI(basePath: kotlin.String = defaultBasePath) : ApiClient(basePath) {
    companion object {
        @JvmStatic
        val defaultBasePath: String = ""
    }

    fun renewAccessToken(basic: String,body: kotlin.Any?): Any {
        val localVariableBody: kotlin.Any? = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()

        localVariableHeaders.apply {
            put("Authorization",basic)
        }
        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/renewToken",
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val response = request<kotlin.String>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as Any
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = response as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, response)
            }
            ResponseType.ServerError -> {
                val localVarError = response as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, response)
            }

        }


    }


}