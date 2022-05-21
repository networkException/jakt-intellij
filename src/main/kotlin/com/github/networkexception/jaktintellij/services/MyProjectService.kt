package com.github.networkexception.jaktintellij.services

import com.intellij.openapi.project.Project
import com.github.networkexception.jaktintellij.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
