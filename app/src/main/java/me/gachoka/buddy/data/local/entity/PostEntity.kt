package me.gachoka.buddy.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
    @PrimaryKey
    var id: Int = 0,
    var userId: Int?,
    var title: String?,
    var body: String?
)
