package Runners;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        /*
        features: localização dos arquivos de feature.
        glue: localização das classes de definição de passo.
        plugin: configurações de relatórios, neste caso, o plugin "pretty" para exibir no console e o plugin "html" para gerar um relatório em HTML.
         */
        features = "src/test/resources",
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        dryRun = false
)
public class RunCucumberTest {
}