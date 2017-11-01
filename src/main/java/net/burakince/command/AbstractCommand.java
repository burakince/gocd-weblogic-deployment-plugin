package net.burakince.command;

import com.google.gson.GsonBuilder;
import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.Map;

public abstract class AbstractCommand {

    public static final String URL_PROPERTY = "Url";
    public static final String ADDITIONAL_OPTIONS = "AdditionalOptions";
    public static final String SECURE_CONNECTION = "yes";
    public static final String SECURE_CONNECTION_PROPERTY = "SecureConnection";
    public static final String REQUEST_TYPE = "-G";
    public static final String REQUEST_PROPERTY = "RequestType";

    public abstract GoPluginApiResponse execute(GoPluginApiRequest request);

    protected GoPluginApiResponse prepareResponse(int responseCode, Map body) {
        final DefaultGoPluginApiResponse response = new DefaultGoPluginApiResponse(responseCode);
        response.setResponseBody(new GsonBuilder().serializeNulls().create().toJson(body));
        return response;
    }

}
