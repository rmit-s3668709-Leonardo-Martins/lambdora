package org.fcrepo.lambdora.ldp;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.log4j.Logger;
import org.fcrepo.lambdora.ApiGatewayResponse;
import org.fcrepo.lambdora.Response;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * PostHandler class
 *
 * @author dbernstein
 */
public class PostHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = Logger.getLogger(GetHandler.class);

    @Override
    public ApiGatewayResponse handleRequest(final Map<String, Object> input, final Context context) {
        LOG.info("received: " + input);
        final Response responseBody = new Response("POST: Welcome to Lambdora, the current time is " + new Date());
        final Map<String, String> headers = new HashMap<>();
        headers.put("X-Powered-By", "AWS Lambda & Serverless");
        headers.put("Content-Type", "application/json");
        return ApiGatewayResponse.builder()
            .setStatusCode(200)
            .setObjectBody(responseBody)
            .setHeaders(headers)
            .build();
    }
}
