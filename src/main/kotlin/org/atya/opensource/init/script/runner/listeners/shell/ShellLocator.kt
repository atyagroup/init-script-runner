package org.atya.opensource.init.script.runner.listeners.shell

import org.slf4j.Logger
import java.io.File

class ShellLocator(private val logger: Logger) {

    fun getShellLocation(): String? {
        val shell = System.getenv("SHELL")
        return if (shell != null && (shell.contains("bash") || shell.contains("zsh"))) {
            logger.info("Shell Location : {}", shell)
            shell
        } else {
            getShellLocationInternal()
        }
    }

    private fun getShellLocationInternal(): String? {
        val path = System.getenv("PATH")
        val pathDirectories = path.split(":")
        for (directory in pathDirectories) {
            val bashPath = "$directory/bash"
            val zshPath = "$directory/zsh"
            if (File(bashPath).exists()) {
                logger.info("Shell Location using PATH: {}", bashPath)
                return bashPath
            } else if (File(zshPath).exists()) {
                logger.info("Zsh Location using PATH: {}", zshPath)
                return zshPath
            }
        }
        return null
    }
}

