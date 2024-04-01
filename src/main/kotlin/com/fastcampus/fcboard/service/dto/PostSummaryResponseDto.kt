package com.fastcampus.fcboard.service.dto

import com.fastcampus.fcboard.domain.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl

/**
 * <p></p>
 *
 * <ul>
 *     <li>Updated on : 4/1/24</li>
 *     <li>Updated by : spd2team</li>
 * </ul>
 */
data class PostSummaryResponseDto(
    val id: Long,
    val title: String,
    val createdBy: String,
    val createdAt: String,
)

fun Page<Post>.toSummaryResponseDto() =
    PageImpl(
        content.map { it.toSummaryResponseDto() },
        pageable,
        totalElements,
    )

fun Post.toSummaryResponseDto() =
    PostSummaryResponseDto(
        id = id,
        title = title,
        createdBy = createdBy,
        createdAt = createdAt.toString(),
    )
