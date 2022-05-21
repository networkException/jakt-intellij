package org.serenityos.jakt

import com.intellij.psi.tree.IElementType

class JaktToken(debugName: String) : IElementType(debugName, JaktLanguage) {
    override fun toString() = "JaktToken.${super.toString()}"
}
