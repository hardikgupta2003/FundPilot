package com.hardik.fundpilot.core.network

sealed class ResponseResult<out T> {

    object Loading : ResponseResult<Nothing>()
    data class Success<out T>(val data : T) : ResponseResult<T>()

    data class Error<out T>(val error : NetworkError) : ResponseResult<T>()
}

sealed class NetworkError{

    data class Network(val code : Int, val message : String) : NetworkError()

    data class Http(val message : String = "No Internet Connection") : NetworkError()

}