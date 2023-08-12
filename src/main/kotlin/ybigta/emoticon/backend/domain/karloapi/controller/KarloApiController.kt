package ybigta.emoticon.backend.domain.karloapi.controller

import org.springframework.http.HttpStatus
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import ybigta.emoticon.backend.domain.karloapi.service.KarloApiService

@RestController
@RequestMapping("/karlo")
class KarloApiController(
    private val karloApiService: KarloApiService,
) {
    @GetMapping(
    @Operation(summary = "Karlo API를 이용해 프롬프트 1개에 대한 이미지 1장을 inference합니다.")
        "/infer",
        produces = [MediaType.IMAGE_JPEG_VALUE],
    )
    fun infer(
        @RequestParam
        key: String,
        @RequestParam
        prompt: String,
    ): ByteArray {
        if (key != "29af196d3bb3b46177f3ec5cbe4c44d8")
            throw ResponseStatusException(HttpStatus.FORBIDDEN)
        return karloApiService.infer(prompt)
    }
}