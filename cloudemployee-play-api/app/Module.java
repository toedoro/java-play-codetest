import java.time.Clock;

import com.cloudemployee.play.service.ApplicationTimer;
import com.cloudemployee.play.service.AtomicCounter;
import com.cloudemployee.play.service.Counter;
import com.google.inject.AbstractModule;


/**
 * Sept 21, 2016 3:45:03 PM
 * 
 * @author © tdelacerna <teodoro.delacerna@fsoft.com.vn>
 */
public class Module extends AbstractModule {

    @Override
    public void configure() {
        // Use the system clock as the default implementation of Clock
        bind(Clock.class).toInstance(Clock.systemDefaultZone());
        
        // Ask Guice to create an instance of ApplicationTimer when the
        // application starts.
        bind(ApplicationTimer.class).asEagerSingleton();
        
        // Set AtomicCounter as the implementation for Counter.
        bind(Counter.class).to(AtomicCounter.class);
    }

}
