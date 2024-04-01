package com.fastcampus.fcboard.dto

/**
 * <p></p>
 *
 * <ul>
 *     <li>Updated on : 3/29/24</li>
 *     <li>Updated by : spd2team</li>
 * </ul>
 */
data class PostSummaryResponse(
    val id: Long,
    val title: String,
    val createdBy: String,
    val createdAt: String,
)
