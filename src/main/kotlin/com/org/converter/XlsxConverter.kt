package com.org.converter

import io.github.millij.poi.ss.reader.XlsxReader
import io.github.millij.poi.ss.writer.SpreadsheetWriter
import java.io.File
import kotlin.reflect.KClass

class XlsxConverter {
    @Suppress("DEPRECATION")
    fun <T : Any> convertListToXlsx(tableContent: List<T>, fileName: String): File {
        //in Kotlin this converter does not support data class
        //if table content was generated based on lombok @Builder it will add one empty column "lder"
        //if converted class extends any other class, super class fields will be not included in final file
        val xlsxFile = File(fileName)
        val writer: SpreadsheetWriter = SpreadsheetWriter(xlsxFile)
        if (tableContent.isNotEmpty()) {
            writer.addSheet(tableContent[0].javaClass, tableContent)
        }
        writer.write()
        return xlsxFile
    }

    fun <T : Any> convertXlsxToModel(file: File, expectedReportModel: KClass<T>): MutableList<T> {
        return XlsxReader().read(expectedReportModel.java, file)
    }
}