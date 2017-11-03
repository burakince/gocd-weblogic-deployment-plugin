package net.burakince.command;

import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;
import com.thoughtworks.go.plugin.api.task.JobConsoleLogger;

public class TaskExecutionCommand extends AbstractCommand {

    @Override
    public GoPluginApiResponse execute(GoPluginApiRequest request) {
        JobConsoleLogger.getConsoleLogger().printLine("Hello World");
        return new DefaultGoPluginApiResponse(DefaultGoPluginApiResponse.SUCCESS_RESPONSE_CODE);
    }

}
