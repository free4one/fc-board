package com.fastcampus.fcboard.service

import com.fastcampus.fcboard.domain.Post
import com.fastcampus.fcboard.exception.PostNotDeletableException
import com.fastcampus.fcboard.exception.PostNotFoundException
import com.fastcampus.fcboard.exception.PostNotUpdatableException
import com.fastcampus.fcboard.repository.PostRepository
import com.fastcampus.fcboard.service.dto.PostCreateRequestDto
import com.fastcampus.fcboard.service.dto.PostUpdateRequestDto
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.longs.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull

/**
 * <p></p>
 *
 * <ul>
 *     <li>Updated on : 4/1/24</li>
 *     <li>Updated by : spd2team</li>
 * </ul>
 */
@SpringBootTest
class PostServiceTest(
    private val postService: PostService,
    private val postRepository: PostRepository,
) : BehaviorSpec({
        given("게시글 생성 시") {
            When("게시글 입력 데이터가 정상적으로 들어오면") {
                val postId: Long =
                    postService.createPost(
                        PostCreateRequestDto(
                            title = "제목",
                            content = "내용",
                            createdBy = "harris",
                        ),
                    )
                then("게시글이 정상적으로 생성됨을 확인한다.") {
                    postId shouldBeGreaterThan 0L
                    val post = postRepository.findByIdOrNull(postId)
                    post shouldNotBe null
                    post?.title shouldBe "제목"
                    post?.content shouldBe "내용"
                    post?.createdBy shouldBe "harris"
                }
            }
        }
        given("게시글 수정 시") {
            val saved: Post = postRepository.save(Post(title = "title", content = "content", createdBy = "harris"))
            When("정상 수정 시") {
                val updatedId: Long =
                    postService.updatePost(
                        saved.id,
                        PostUpdateRequestDto(
                            title = "updated title",
                            content = "updated content",
                            updatedBy = "harris",
                        ),
                    )
                then("게시글이 정상적으로 수정됨을 확인한다.") {
                    saved.id shouldBe updatedId
                    val updated: Post? = postRepository.findByIdOrNull(updatedId)
                    updated shouldNotBe null
                    updated?.title shouldBe "updated title"
                    updated?.content shouldBe "updated content"
                    updated?.updatedBy shouldBe "harris"
                }
            }
            When("게시글이 없을 때") {
                then("게시글을 찾을 수 없다는 예외가 발생한다.") {
                    shouldThrow<PostNotFoundException> {
                        postService.updatePost(
                            9999L,
                            PostUpdateRequestDto(
                                title = "update title",
                                content = "update content",
                                updatedBy = "update harris",
                            ),
                        )
                    }
                }
            }
            When("작성자가 동일하지 않으면") {
                then("수정할 수 없는 게시물 입니다. 예외가 발생한다.") {
                    shouldThrow<PostNotUpdatableException> {
                        postService.updatePost(
                            1L,
                            PostUpdateRequestDto(
                                title = "update title",
                                content = "update content",
                                updatedBy = "update harris",
                            ),
                        )
                    }
                }
            }
        }
        given("게시글 삭제 시") {
            val saved: Post = postRepository.save(Post(title = "title", content = "content", createdBy = "harris"))
            When("정상 삭제 시") {
                val postId: Long = postService.deletePost(saved.id, "harris")
                then("게시글이 정상적으로 삭제됨을 확인한다.") {
                    postId shouldBe saved.id
                    postRepository.findByIdOrNull(postId) shouldBe null
                }
            }
            When("작성자가 동일하지 않으면") {
                val saved2: Post = postRepository.save(Post(title = "title", content = "content", createdBy = "harris"))
                then("삭제할 수 없는 게시물 입니다. 예외가 발생한다.") {
                    shouldThrow<PostNotDeletableException> {
                        postService.deletePost(saved2.id, "harris2")
                    }
                }
            }
        }
    })
