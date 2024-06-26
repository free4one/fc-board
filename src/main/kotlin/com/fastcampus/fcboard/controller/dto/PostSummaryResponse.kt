package com.fastcampus.fcboard.controller.dto

import com.fastcampus.fcboard.service.dto.PostSummaryResponseDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl

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

fun Page<PostSummaryResponseDto>.toResponse() =
    PageImpl(
        content.map { it.toResponse() },
        pageable,
        totalElements,
    )

fun PostSummaryResponseDto.toResponse() =
    PostSummaryResponse(
        id = id,
        title = title,
        createdBy = createdBy,
        createdAt = createdAt,
    )
