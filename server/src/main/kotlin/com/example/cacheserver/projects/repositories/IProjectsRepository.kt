package com.example.cacheserver.projects.repositories

import com.example.cacheserver.projects.Project

interface IProjectsRepository {
    fun get(projectId: String): Project?

    fun getAll(): List<Project>

    fun create(project: Project): Project

    fun delete(projectId:String)

    fun update(project: Project): Project
}