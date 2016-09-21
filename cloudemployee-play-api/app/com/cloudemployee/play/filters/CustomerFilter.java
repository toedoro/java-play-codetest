package com.cloudemployee.play.filters;

import akka.stream.Materializer;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.function.Function;
import javax.inject.*;
import play.mvc.*;
import play.mvc.Http.RequestHeader;

/**
 * Sept 21, 2016 6:33:03 PM
 * 
 * @author © tdelacerna <teodoro.delacerna@fsoft.com.vn>
 */
@Singleton
public class CustomerFilter extends Filter {

    private final Executor exec;

    @Inject
    public CustomerFilter(Materializer mat, Executor exec) {
        super(mat);
        this.exec = exec;
    }

    @Override
    public CompletionStage<Result> apply(
        Function<RequestHeader, CompletionStage<Result>> next,
        RequestHeader requestHeader) {

        return next.apply(requestHeader).thenApplyAsync(
            result -> result.withHeader("X-CustomerFilter", "foo"),
            exec
        );
    }

}
