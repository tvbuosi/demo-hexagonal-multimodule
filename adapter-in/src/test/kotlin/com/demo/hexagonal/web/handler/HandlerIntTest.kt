package com.demo.hexagonal.web.handler

import io.mockk.every
import java.math.BigDecimal
import java.time.Instant
import java.time.OffsetDateTime
import java.util.UUID
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration
import org.springframework.context.annotation.Import
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@Import(AopAutoConfiguration::class)
class HandlerIntTest : BaseMvcIntegrationTest() {

    @Autowired
    private lateinit var demoUsecasePort: DemoUsecasePort

    @Test
    fun validCall() {

        every { getCampaignListToReviewPort.execute() } returns createReview()

        val url = DemoControllerUrls.BASE_PATH

        mockMvc
            .perform(
                MockMvcRequestBuilders.get(url)
                    .param("page", "0")
                    .param("size", "10")
                    .header("trace-id", "1eb48a22-a425-4d0a-ba0a-ea14717f9949")
                    .header(
                        "Authorization",
                        "Bearer eyJraWQiOiJkYWZkZTI5My0yY2Y3LTRmMzUtYThmYy1jZjYzODNiOTQ2MzciLCJhbGciOiJSUzUxMiIsInR5cCI6IkpXVCJ9.ewogICAgInJvbGVzIjogWwogICAgICAgICJVUERBVEVfQ0FNUEFJR05fR09WRVJOQU5DRSIsCiAgICAgICAgIlZJRVdfQ0FNUEFJR05fR09WRVJOQU5DRSIsCiAgICAgICAgIk9SREVSX1ZJRVdFUiIsCiAgICAgICAgIkNBVEFMT0dfTUFOQUdFTUVOVCIsCiAgICAgICAgIkRJU0NPVkVSWV9DTVNfUlciLAogICAgICAgICJDQU1QQUlHTl9TRUdNRU5UQVRJT04iLAogICAgICAgICJDQU1QQUlHTl9BVVRPTUFUSUNfRUxJR0lCSUxJVFkiLAogICAgICAgICJDQU1QQUlHTl9QRVJNSVNTSU9OX0xJU1RfTUFOQUdFUiIsCiAgICAgICAgIkNBTVBBSUdOX0JVREdFVF9NQU5BR0VSIgogICAgXSwKICAgICJpYXQiOiAxNjU0MjY3NzU4LAogICAgImlzcyI6ICJLb25nLUdsdXUtUGFydG5lci1CYWNrb2ZmaWNlIiwKICAgICJuYW1lIjogIklzcmFlbCBWaWxlbGEgUm9kcmlndWVzIiwKICAgICJkb21haW4iOiAiaWZvb2QuY29tLmJyIiwKICAgICJwcm92aWRlciI6ICJnbHV1IiwKICAgICJmYW1pbHlfbmFtZSI6ICJSb2RyaWd1ZXMiLAogICAgInVzZXIiOiAiaXNyYWVsLnJvZHJpZ3VlcyIsCiAgICAicHJvZmlsZSI6IFsKICAgICAgICAiVGVjaCBQcm9kdWN0IFJlc3RhdXJhbnQiCiAgICBdLAogICAgInN1YiI6ICJpc3JhZWwucm9kcmlndWVzQGlmb29kLmNvbS5iciIsCiAgICAiZW1haWxfdmVyaWZpZWQiOiB0cnVlLAogICAgImNhbXBhaWduX2FwcHJvdmFsX2dyb3VwIjogWwogICAgICAgICJNQVJLRVRJTkciCiAgICBdLAogICAgImdpdmVuX25hbWUiOiAiSXNyYWVsIiwKICAgICJleHAiOiAxNjU0MzU0MTU4Cn0=.hBM8jzj5x3ZWC4a-NFVxECV--amaym700AyLZG0DH3v180A_qcoCD86xoZPzbVTGkAORY6Neca83EiTdDGTarzyR57dkT4g2zxIzPIDycL-8DWhGveGmTqQPW-hAmNj7irdjKhkayGAYlT6N4XmLg0KtO0GJRcN83ZIafXIUeLwD_cXJBjN16CjqaoaajgS3G3Fa3LjmfIld68Jx3dbIlYgUKU0bIfmSNLR-4m_r1feHq2ycUwJA8h6wfUG47wNMoOclC3p80N4xY9XkKN2dHDTZAl86xNVV-L8Qgtju8scrjVzUzz2WWj7mYbDNpYYSwfVA8kaS8oUuMyTQjHUrXg"
                    )
            )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()

    }
}