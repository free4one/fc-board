package com.fastcampus.fcboard.controller.dto

import com.fastcampus.fcboard.service.dto.PostSearchRequestDto
import org.springframework.web.bind.annotation.RequestParam

/**
 * <p></p>
 *
 * <ul>
 *     <li>Updated on : 3/29/24</li>
 *     <li>Updated by : spd2team</li>
 * </ul>
 */
data class PostSearchRequest(
    @RequestParam
    val title: String?,
    @RequestParam
    val createdBy: String?,
)

fun PostSearchRequest.toDto() =
    PostSearchRequestDto(
        title = title,
        createdBy = createdBy,
    )
