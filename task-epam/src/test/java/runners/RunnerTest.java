package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber") // uruchamia silnik Cucumber
@SelectClasspathResource("features") // katalog z plikami .feature
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "base,tests.login,tests.home") // pakiety z krokami
public class RunnerTest {
}
