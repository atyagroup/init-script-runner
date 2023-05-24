package org.atya.opensource.init.script.runner.listeners.shell

import org.slf4j.Logger
import java.io.BufferedReader
import java.io.InputStreamReader

class ScriptExecutor(private val logger: Logger) {

    fun executeScript(scriptPath: String, shellLocation: String, projectBaseDir: String) {
        logger.info("Executing script : {}", scriptPath)
        val processBuilder = ProcessBuilder(shellLocation, scriptPath, projectBaseDir)
        processBuilder.redirectErrorStream(true)
        val process = processBuilder.start()

        val reader = BufferedReader(InputStreamReader(process.inputStream))
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            println(line)
        }
        reader.close()

        val exitCode = process.waitFor()
        logger.info("Bash script exited with code: $exitCode")
    }

}
