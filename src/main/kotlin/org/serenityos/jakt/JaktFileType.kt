package org.serenityos.jakt

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object JaktFileType : LanguageFileType(JaktLanguage) {
    override fun getName(): String = "jakt file"
    override fun getDescription(): String = "The jakt programming language"
    override fun getDefaultExtension(): String = "jakt"
    override fun getIcon(): Icon = JaktIcon.icon
}
