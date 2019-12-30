package com.user.login.filters;

import akka.stream.Materializer;
import com.google.inject.Inject;
import com.typesafe.config.Config;
import play.Logger;
import play.libs.ws.WSClient;
import play.mvc.Filter;
import play.mvc.Http;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public class OAuthTokenVerification extends Filter {
    private Config config;
    /**
     * The Logger.
     */
    private final Logger.ALogger logger = Logger.of(this.getClass());

    private WSClient ws;

    /**
     * Instantiates a new O auth token verification.
     *
     * @param mat the mat
     */
    @Inject
    public OAuthTokenVerification(Materializer mat, WSClient ws, Config config) {
        super(mat);
        this.ws = ws;
        this.config = config;
    }

    @Override
    public CompletionStage<Result> apply(Function<Http.RequestHeader,
        CompletionStage<Result>> next, Http.RequestHeader rh) {

        logger.info("Filter");
        return next.apply(rh).thenApply(result -> result);
    }
}
