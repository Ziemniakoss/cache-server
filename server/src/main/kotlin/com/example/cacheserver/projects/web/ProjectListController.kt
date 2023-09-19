package com.example.cacheserver.projects.web

import com.example.cacheserver.projects.service.IProjectService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ProjectListController(private val projectService: IProjectService) {
    @GetMapping("/")
    fun showProjectList(model: Model): String {
        model["projects"] = projectService.getAll()
        return "index.html"
    }
}