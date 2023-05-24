package org.atya.opensource.init.script.runner.listeners

import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import org.atya.opensource.init.script.runner.listeners.shell.DirectoryLocator
import org.atya.opensource.init.script.runner.listeners.shell.ScriptExecutor
import org.atya.opensource.init.script.runner.listeners.shell.ShellLocator
import org.jetbrains.annotations.NotNull
import org.slf4j.Logger
import org.slf4j.LoggerFactory

internal class ScriptExecutorListener : ProjectManagerListener {

    private val logger: Logger = LoggerFactory.getLogger(ScriptExecutorListener::class.java)

    override fun projectOpened(@NotNull project: Project) {
        logger.info("Atya Mode: Executing Init Script Runner for project : {}", project.name)
        val shellLocator = ShellLocator(logger)
        val shellLocation = shellLocator.getShellLocation()

        if(shellLocation != null) {

            val directoryLocator = DirectoryLocator(logger)
            val projectDirectory = directoryLocator.getProjectDirectory(project)
            val scriptsDir = directoryLocator.getScriptsDir(projectDirectory)
            val scriptFiles = directoryLocator.getScriptFiles(scriptsDir)

            val scriptExecutor = ScriptExecutor(logger)

            for (file in scriptFiles) {
                try {
                    scriptExecutor.executeScript(file, shellLocation, projectDirectory)
                } catch (e: Error) {
                    logger.error("Exception : {}, while executing script : {}", e, file)
                }
            }
        } else {
            logger.error("Terminating : Shell/Zsh not found")
        }



    }

}
