package com.example.cacheserver.projects.service

import com.example.cacheserver.projects.Project
import com.example.cacheserver.projects.repositories.IProjectsRepository
import org.springframework.stereotype.Service

@Service
class IProjectServiceImpl(
    private val projectsRepository: IProjectsRepository
) : IProjectService {
    // TODO implement security
    override fun getProject(projectId: String): Project {
        return projectsRepository.get(projectId) ?: throw ProjectNotFoundException(projectId)
    }

    override fun getAll(): List<Project> {
        return projectsRepository.getAll()
    }

    override fun createProject(project: Project): Project {
        return projectsRepository.create(project)
    }

    override fun deleteProject(projectId: String) {
        projectsRepository.delete(projectId)
    }

    override fun updateProject(project: Project): Project {
        return projectsRepository.update(project)
    }
}