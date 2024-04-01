package com.fastcampus.fcboard.service.dto

import com.fastcampus.fcboard.domain.Post

/**
 * <p></p>
 *
 * <ul>
 *     <li>Updated on : 4/1/24</li>
 *     <li>Updated by : spd2team</li>
 * </ul>
 */
data class PostCreateRequestDto(
    val title: String,
    val content: String,
    val createdBy: String,
)

fun PostCreateRequestDto.toEntity() =
    Post(
        title = title,
        content = content,
        createdBy = createdBy,
    )
