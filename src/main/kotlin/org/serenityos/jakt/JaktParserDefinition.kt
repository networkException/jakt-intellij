package org.serenityos.jakt

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.serenityos.jakt.parser.JaktParser

val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
val COMMENTS = TokenSet.create()
val STRING_LITERALS = TokenSet.create(JaktTypes.STRING_LITERAL)

val FILE = IFileElementType(JaktLanguage)

class JaktParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?): Lexer = JaktLexerAdapter()
    override fun createParser(project: Project?): PsiParser = JaktParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun createElement(node: ASTNode?): PsiElement = JaktTypes.Factory.createElement(node)
    override fun createFile(viewProvider: FileViewProvider): PsiFile = JaktFile(viewProvider)

    override fun getCommentTokens(): TokenSet = COMMENTS
    override fun getWhitespaceTokens(): TokenSet = WHITE_SPACES
    override fun getStringLiteralElements(): TokenSet = STRING_LITERALS
}
