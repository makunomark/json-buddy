package me.gachoka.buddy.data.local.dao

interface BaseDao<T> {
    fun insert(vararg t: T)
}
