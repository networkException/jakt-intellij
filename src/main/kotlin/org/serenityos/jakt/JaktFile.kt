package org.serenityos.jakt

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class JaktFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, JaktLanguage) {
    override fun getFileType(): FileType = JaktFileType
    override fun toString(): String = "jakt file"
}
