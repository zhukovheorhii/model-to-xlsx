package com.org.converter

import org.apache.commons.lang3.RandomStringUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class SImpleTest {
    @Test
    fun `should convert collection to xlsx`() {
        val someModelList = listOf(
            SomeModel().apply {
                name = "Name 1"
                type = "Some Type"
                quantity = 3
            },
            SomeModel().apply {
                name = "Name 2"
                type = "Some Type 2"
                quantity = 11
            }
        )

        val xlsxFile = XlsxConverter()
            .convertListToXlsx(someModelList, "${RandomStringUtils.randomAlphabetic(10)}.xlsx")

        val backwardConvertedList = XlsxConverter()
            .convertXlsxToModel(xlsxFile, SomeModel::class)


        assertAll(
            { assertEquals(backwardConvertedList.size, someModelList.size) },
            { backwardConvertedList.forEach { assertTrue(it::class == SomeModel::class) } }
        )
    }
}