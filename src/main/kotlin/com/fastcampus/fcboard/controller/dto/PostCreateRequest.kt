package com.fastcampus.fcboard.controller.dto

import com.fastcampus.fcboard.service.dto.PostCreateRequestDto

/**
 * <p></p>
 *
 * <ul>
 *     <li>Updated on : 3/29/24</li>
 *     <li>Updated by : spd2team</li>
 * </ul>
 */
data class PostCreateRequest(
    val title: String,
    val content: String,
    val createdBy: String,
)

fun PostCreateRequest.toDto() =
    PostCreateRequestDto(
        title = title,
        content = content,
        createdBy = createdBy,
    )
