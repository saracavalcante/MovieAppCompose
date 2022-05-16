package br.com.saradev.movieapp.utils

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val message: String?,
) {
    companion object {

        fun <T> empty(): Resource<T> =
            Resource(Status.EMPTY, null, null)

        fun <T> success(data: T?): Resource<T> =
            Resource(Status.SUCCESS, data, null)

        fun <T> error(message: String, data: T?): Resource<T> =
            Resource(Status.ERROR, data, message)

        fun <T> loading(data: T?): Resource<T> =
            Resource(Status.LOADING, data, null)
    }
}