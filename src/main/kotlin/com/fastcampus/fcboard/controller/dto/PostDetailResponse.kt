package com.fastcampus.fcboard.controller.dto

/**
 * <p></p>
 *
 * <ul>
 *     <li>Updated on : 3/29/24</li>
 *     <li>Updated by : spd2team</li>
 * </ul>
 */
data class PostDetailResponse(
    val id: Long,
    val title: String,
    val content: String,
    val createdBy: String,
    val createdAt: String,
)
