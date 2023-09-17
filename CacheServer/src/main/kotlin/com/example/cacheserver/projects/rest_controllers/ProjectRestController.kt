package com.example.cacheserver.projects.rest_controllers

import com.example.cacheserver.projects.Project
import com.example.cacheserver.projects.service.IProjectService
import com.example.cacheserver.projects.service.ProjectNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProjectRestController(private val projectService: IProjectService) {
    @GetMapping("/api/projects")
    fun getAll(): List<Project> {
        return projectService.getAll()
    }

    @GetMapping("/api/projects/{projectId}")
    fun get(@PathVariable projectId: String): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(projectService.getProject(projectId) as Any)
        } catch (notFound: ProjectNotFoundException) {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/api/projects/{projectId}")
    fun delete(@PathVariable projectId: String):ResponseEntity<Any> {
        projectService.deleteProject(projectId)
        return ResponseEntity.ok("DELETED")
    }

    @PostMapping("/api/projects")
    fun upsert(@RequestBody project:Project):ResponseEntity<Any> {
        return if(project.id == null) {
            ResponseEntity.ok(projectService.createProject(project))
        } else {
            ResponseEntity.ok(projectService.updateProject(project))
        }
    }

}