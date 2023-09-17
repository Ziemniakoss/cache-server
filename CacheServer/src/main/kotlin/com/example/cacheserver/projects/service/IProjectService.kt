package com.example.cacheserver.projects.service

import com.example.cacheserver.projects.Project


interface IProjectService {
    fun getProject(projectId:String): Project
    fun getAll():List<Project>
    fun createProject(project: Project):Project
    fun deleteProject(projectId: String)
    fun updateProject(project: Project):Project
}