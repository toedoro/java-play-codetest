import javax.inject.Inject;
import javax.inject.Singleton;

import com.cloudemployee.play.filters.CustomerFilter;

import play.Environment;
import play.filters.cors.CORSFilter;
import play.http.HttpFilters;
import play.mvc.EssentialFilter;

/**
 * Sept 21, 2016 3:55:03 PM
 * 
 * @author © tdelacerna <teodoro.delacerna@fsoft.com.vn>
 */
@Singleton
public class Filters implements HttpFilters {

    private final Environment env;
    private final EssentialFilter exampleFilter;
    
    @Inject
    CORSFilter corsFilter;

    @Inject
    public Filters(Environment env, CustomerFilter exampleFilter) {
        this.env = env;
        this.exampleFilter = exampleFilter;
    }

    @Override
    public EssentialFilter[] filters() {
    	return new EssentialFilter[] { corsFilter.asJava() };
    }

}
