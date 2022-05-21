package org.serenityos.jakt

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

import org.serenityos.jakt.JaktTypes.*

val HIGHLIGHT_DOT = arrayOf(createTextAttributesKey("JAKT_DOT", DefaultLanguageHighlighterColors.DOT))
val HIGHLIGHT_COMMA = arrayOf(createTextAttributesKey("JAKT_COMMA", DefaultLanguageHighlighterColors.COMMA))
val HIGHLIGHT_IDENTIFIER = arrayOf(createTextAttributesKey("JAKT_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER))
val HIGHLIGHT_STRING = arrayOf(createTextAttributesKey("JAKT_STRING", DefaultLanguageHighlighterColors.STRING))
val HIGHLIGHT_OPERATION_SIGN = arrayOf(createTextAttributesKey("JAKT_OPERATION_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN))
val HIGHLIGHT_KEYWORD = arrayOf(createTextAttributesKey("JAKT_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD))
val HIGHLIGHT_COMMENT = arrayOf(createTextAttributesKey("JAKT_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT))
val HIGHLIGHT_NUMBER = arrayOf(createTextAttributesKey("JAKT_NUMBER", DefaultLanguageHighlighterColors.NUMBER))

val HIGHLIGHT_PARENTHESES = arrayOf(createTextAttributesKey("JAKT_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES))
val HIGHLIGHT_BRACES = arrayOf(createTextAttributesKey("JAKT_BRACES", DefaultLanguageHighlighterColors.BRACES))
val HIGHLIGHT_BRACKETS = arrayOf(createTextAttributesKey("JAKT_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS))

class JaktSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer = JaktLexerAdapter()
    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
        when (tokenType) {
            EXTERN_KEYWORD,

            CLASS_KEYWORD,
            STRUCT_KEYWORD,
            FUNCTION_KEYWORD,

            LET_KEYWORD,
            IF_KEYWORD,
            ELSE_KEYWORD,

            WHILE_KEYWORD,
            FOR_KEYWORD,
            LOOP_KEYWORD,

            RETURN_KEYWORD,
            THROW_KEYWORD,
            DEFER_KEYWORD,

            TRUE_KEYWORD,
            FALSE_KEYWORD,

            MUTABLE_KEYWORD,
            ANONYMOUS_KEYWORD,
            RAW_KEYWORD,
            THROWS_KEYWORD -> HIGHLIGHT_KEYWORD

            PAREN_OPEN,
            PAREN_CLOSE -> HIGHLIGHT_PARENTHESES

            CURLY_OPEN,
            CURLY_CLOSE -> HIGHLIGHT_BRACES

            BRACKET_OPEN,
            BRACKET_CLOSE -> HIGHLIGHT_BRACKETS

            COLON,
            COLON_COLON,
            DOT,
            DOT_DOT -> HIGHLIGHT_DOT

            COMMA -> HIGHLIGHT_COMMA
            EQUALS,
            PLUS,
            MINUS,
            ASTERISK,
            SLASH,
            AMPERSAND -> HIGHLIGHT_OPERATION_SIGN

            IDENTIFIER -> HIGHLIGHT_IDENTIFIER

            STRING_LITERAL -> HIGHLIGHT_STRING
            COMMENT -> HIGHLIGHT_COMMENT
            else -> TextAttributesKey.EMPTY_ARRAY
        }
}
