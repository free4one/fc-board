package com.fastcampus.fcboard.exception

/**
 * <p></p>
 *
 * <ul>
 *     <li>Updated on : 4/1/24</li>
 *     <li>Updated by : spd2team</li>
 * </ul>
 */
open class PostException(message: String) : RuntimeException(message)

class PostNotFoundException() : PostException("게시글을 찾을 수 없습니다.")

class PostNotUpdatableException() : PostException("게시글을 수정할 수 없습니다.")

class PostNotDeletableException() : PostException("삭제할 수 없는 게시물 입니다.")
