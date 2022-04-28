package com.android.demo.data

data class DataResource<out T>(
    val status: DataStatus,
    val data: T?,
    val messageResId: Int?
) {
    companion object {
        fun <T> success(data: T?): DataResource<T> {
            return DataResource(DataStatus.SUCCESS, data, null)
        }

        fun <T> error(msg: Int, data: T? = null): DataResource<T> {
            return DataResource(DataStatus.ERROR, data, msg)
        }
    }
}

enum class DataStatus {
    SUCCESS,
    ERROR
}