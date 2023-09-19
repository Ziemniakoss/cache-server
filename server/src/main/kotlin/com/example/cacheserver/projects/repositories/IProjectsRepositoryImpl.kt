package com.example.cacheserver.projects.repositories

import com.example.cacheserver.projects.Project
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import java.util.*

@Repository
class IProjectsRepositoryImpl(@Autowired private val jdbcTemplate: JdbcTemplate) : IProjectsRepository {
    override fun get(projectId: String): Project? {
        return jdbcTemplate.query("SELECT id,name, description FROM project WHERE id = ?", ProjectExtractor() as ResultSetExtractor<Project>, arrayOf(projectId))
    }

    override fun getAll(): List<Project> {
        return jdbcTemplate.query("SELECT id, name, description FROM project", ProjectExtractor() as RowMapper<Project>)
    }

    override fun create(project: Project): Project {
        val id = UUID.randomUUID()
        return jdbcTemplate.query("INSERT INTO project (id, name, description) VALUES (?, ?, ?) RETURNING id, name, description", ProjectExtractor() as RowMapper<Project>, id, project.name.trim(), project.description).firstOrNull()
            ?: throw IllegalStateException("Something went wrong while creating reocrd")
    }

    override fun delete(projectId: String) {
        jdbcTemplate.update("DELETE FROM project WHERE id = ?", arrayOf(projectId))
    }

    override fun update(project: Project): Project {
        if (project.id == null) {
            throw IllegalArgumentException("Update should have Id")
        }
        return jdbcTemplate.query("UPDATE project SET name = ?, description = ? WHERE id = ? RETURNING id, name, description", ProjectExtractor() as ResultSetExtractor<Project>, arrayOf(project.name, project.description, project.id))!!
    }

    private class ProjectExtractor : ResultSetExtractor<Project>, RowMapper<Project> {
        override fun extractData(rs: ResultSet): Project {
            return Project(id = rs.getString(1), name = rs.getString(2), description = rs.getString(3))
        }

        override fun mapRow(rs: ResultSet, rowNum: Int): Project {
            return extractData(rs)
        }
    }
}