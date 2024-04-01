package com.fastcampus.fcboard.repository

import com.fastcampus.fcboard.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

/**
 * <p></p>
 *
 * <ul>
 *     <li>Updated on : 4/1/24</li>
 *     <li>Updated by : spd2team</li>
 * </ul>
 */
interface PostRepository : JpaRepository<Post, Long>
