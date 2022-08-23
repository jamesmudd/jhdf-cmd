package io.jhdf

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.annotation.Parameter

import picocli.CommandLine
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import picocli.CommandLine.Parameters
import java.io.File

@Command(name = "jhdf-cmd", description = ["..."], mixinStandardHelpOptions = true)
class JhdfCmdCommand : Runnable {

    @Option(names = ["-v", "--verbose"], description = ["..."])
    private var verbose: Boolean = false

    @Parameters(paramLabel = "FILE" )
    private var files = ArrayList<File>();

    override fun run() {
        // business logic here
        if (verbose) {
            println("Hi! " + files)
        }

        val hdfFile = HdfFile(files[0])
        println(hdfFile.children)

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            PicocliRunner.run(JhdfCmdCommand::class.java, *args)
        }
    }
}
