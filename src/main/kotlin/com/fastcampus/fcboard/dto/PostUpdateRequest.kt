package com.fastcampus.fcboard.dto

/**
 * <p></p>
 *
 * <ul>
 *     <li>Updated on : 3/29/24</li>
 *     <li>Updated by : spd2team</li>
 * </ul>
 */
data class PostUpdateRequest(
    val title: String,
    val content: String,
    val updatedBy: String,
)
