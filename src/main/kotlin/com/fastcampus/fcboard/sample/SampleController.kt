package com.fastcampus.fcboard.sample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * <p></p>
 *
 * <ul>
 *     <li>Updated on : 3/29/24</li>
 *     <li>Updated by : spd2team</li>
 * </ul>
 */
@RestController
class SampleController {
    @GetMapping("/sample")
    fun sample(): String {
        return "sample"
    }

    @PostMapping("/sample")
    fun samplePost(
        @RequestParam name: String,
    ): String {
        return "Sample name: $name"
    }

    @PutMapping("/sample")
    fun samplePut(
        @RequestParam name: String,
    ): String {
        return "Sample modified name: $name"
    }
}
