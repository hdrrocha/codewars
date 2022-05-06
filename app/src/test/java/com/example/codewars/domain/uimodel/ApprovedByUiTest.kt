package com.example.codewars.domain.uimodel

import com.example.codewars.helper.BaseUnitTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ApprovedByUiTest : BaseUnitTest() {
    @Test
    fun constructor() = runBlocking {
        val model = ApprovedByUi("username", "url")

        Truth.assertThat(model.username).isEqualTo("username")
        Truth.assertThat(model.url).isEqualTo("url")

    }
}