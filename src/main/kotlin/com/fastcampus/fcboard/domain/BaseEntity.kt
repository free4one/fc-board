package com.fastcampus.fcboard.domain

import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime

/**
 * <p></p>
 *
 * <ul>
 *     <li>Updated on : 3/29/24</li>
 *     <li>Updated by : spd2team</li>
 * </ul>
 */
@MappedSuperclass
abstract class BaseEntity(
    createdBy: String,
) {
    val createdBy: String = createdBy
    val createdAt: LocalDateTime = LocalDateTime.now()
    var updatedBy: String? = null
        protected set
    var updatedAt: LocalDateTime? = null
        protected set

    fun update(updatedBy: String) {
        this.updatedBy = updatedBy
        this.updatedAt = LocalDateTime.now()
    }
}
