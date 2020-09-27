package com.org.converter

import io.github.millij.poi.ss.model.annotations.Sheet
import io.github.millij.poi.ss.model.annotations.SheetColumn

@Sheet("UploadTableRequest")
 class SomeModel {
    @SheetColumn("Model Name")
    var name: String? = null
    @SheetColumn("Type")
    var type: String? = null
    @SheetColumn("Qty")
    var quantity: Int? = 0
}