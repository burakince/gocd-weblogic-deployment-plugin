package net.burakince.command;

import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;
import com.thoughtworks.go.plugin.api.task.JobConsoleLogger;
import net.burakince.domain.Result;

public class TaskExecutionCommand extends AbstractCommand {

    @Override
    public GoPluginApiResponse execute(GoPluginApiRequest request) {
        JobConsoleLogger.getConsoleLogger().printLine("Hello World");
        Result result = new Result(true, "Test");
        return prepareResponse(result.responseCode(), result.toMap());
    }

}
