package com.example.cacheserver.projects.service

class ProjectNotFoundException(val projectId:String) :Exception("Project with id $projectId was not found")
