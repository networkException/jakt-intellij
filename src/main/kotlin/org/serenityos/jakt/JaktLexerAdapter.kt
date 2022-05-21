package org.serenityos.jakt

import com.intellij.lexer.FlexAdapter
import org.serenityos.jakt.lexer.JaktLexer;

class JaktLexerAdapter : FlexAdapter(JaktLexer(null))
