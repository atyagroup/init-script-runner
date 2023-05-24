package org.atya.opensource.init.script.runner.listeners.shell

import com.intellij.openapi.project.Project
import org.slf4j.Logger
import java.io.File
import java.nio.file.Paths

class DirectoryLocator(private val logger: Logger) {

    fun getScriptFiles(scriptsDir: String): List<String> {
        logger.info("Scripts directory : {}", scriptsDir)
        val scriptsFolder = File(scriptsDir)
        val scriptFiles = mutableListOf<String>()

        if (scriptsFolder.exists() && scriptsFolder.isDirectory) {
            val files = scriptsFolder.listFiles()
            if (files != null) {
                for (file in files) {
                    scriptFiles.add(file.absolutePath)
                }
            }
        } else {
            logger.warn("Scripts directory does not exists")
        }
        logger.info("Number of scripts found : {}", scriptFiles.size)
        return scriptFiles
    }

    fun getScriptsDir(projectDirectory: String): String {
        return projectDirectory.plus(File.separator).plus(".scripts")
    }

    fun getProjectDirectory(project: Project): String {
        return Paths.get(project.basePath ?: "").toString()
    }

}
