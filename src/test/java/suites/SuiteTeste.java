package suites;


import tests.TestesAutomatizados;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        TestesAutomatizados.class,
        TestesAutomatizados.class,
        TestesAutomatizados.class,
})
public class SuiteTeste {


}
