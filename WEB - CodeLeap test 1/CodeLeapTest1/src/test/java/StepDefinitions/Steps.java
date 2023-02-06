package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Login;
import pageObjects.MainScreen;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Steps {
    WebDriver driver;
    WebDriverWait wait;

    String tempo = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

    String login ="Usuário de Teste QA";
    String postTitle = "Título do Post "+ tempo;
    String postContent = "321 Teste Testinho 123\n21 Teste Testinho 12\n1 Teste Testinho 1\nFim do Teste\n" + tempo;
    String urlLogin = "https://codeleap-frontend-test.netlify.app";
    String urlPosts = "https://codeleap-frontend-test.netlify.app/posts";


    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.of(1, ChronoUnit.SECONDS));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // Steps referente a LOGIN FEATURE ------------------------------______---------------------------------------------
    @Given("eu acesso o site")
    public void acessosite() {
        driver.get(urlLogin);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Login.Title)));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Login.SubTitle)));
    }

    @Then("o botao de login deve estar indisponivel")
    public void o_botao_de_login_deve_estar_indisponivel() {
            boolean isButtonEnabled = driver.findElement(Login.ButtonEnter).isEnabled();
            WebElement button = driver.findElement(Login.ButtonEnter);
            String color = button.getCssValue("color");
            if (!isButtonEnabled && color.equals("rgba(255, 255, 255, 1)")) {
            } else {
                throw new RuntimeException("O botão 'Enter' não está cinza ou está ativado");
            }
    }

    @When("eu escrevo meu usuario")
    public void eu_escrevo_meu_usuario() {
            driver.findElement(Login.InputName).sendKeys(login);
    }

    @Then("o botao de login deve ficar disponivel")
    public void o_botao_de_login_deve_ficar_disponivel() {
            driver.findElement(Login.ButtonEnter);
    }

    @When("eu clico no botao Enter")
    public void Enter() {
        driver.findElement(Login.ButtonEnter).click();
    }

    @Then("devo logar")
    public void devo_logar() throws InterruptedException {
        wait.until(ExpectedConditions.urlToBe(urlPosts));
        Thread.sleep(500);
    }

    // Steps referente a GESTÃO POST FEATURE ---------------------------------------------------------------------------
    @Given("que eu fiz o login e estou na tela de Posts")
    public void eu_acesso_o_site_de_post() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(MainScreen.TitleCodeLeap)));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(MainScreen.Title)));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(MainScreen.TitleContent)));
    }

    @Then("o botao de criar deve estar indisponivel")
    public void o_botão_de_criar_deve_estar_indisponivel() {
        boolean isButtonEnabled = driver.findElement(MainScreen.ButtonCreate).isEnabled();
        WebElement button = driver.findElement(MainScreen.ButtonCreate);
        String color = button.getCssValue("color");
        if (!isButtonEnabled && color.equals("rgba(255, 255, 255, 1)")) {
        } else {
            throw new RuntimeException("O botão 'Enter' não está cinza ou está ativado");
        }
    }

    @And("eu escrevo o titulo do Post")
    public void eu_escrevo_o_titulo_do_post() {
        driver.findElement(MainScreen.InputTitle).sendKeys(postTitle);
    }

    @When("eu escrevo o subtitulo do Post")
    public void eu_escrevo_o_subtitulo_do_post() {
        driver.findElement(MainScreen.InputContent).sendKeys(postContent);
    }

    @Then("o botao de criar deve ficar disponivel")
    public void o_botao_de_criar_deve_ficar_disponivel() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(MainScreen.ButtonCreate)));
    }
    @When("eu clico no botao criar")
    public void eu_clico_no_botao_criar() throws InterruptedException {
        driver.findElement(MainScreen.ButtonCreate).click();
        Thread.sleep(500);
    }
    @Then("a lista deve ser atualizada")
    public void a_lista_deve_ser_atualizada() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(MainScreen.PublicationTitle(postTitle))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(MainScreen.LoginTitle)));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(MainScreen.PublicationContent(postContent))));
    }

    // Steps referente a EDITAR POST -----------------------------------------------------------------------------------
    @Given("clico em editar o Post")
    public void clico_em_editar_o_post() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(MainScreen.ButtonEdit).click();
    }
    @Given("edito o Titulo")
    public void edito_o_titulo() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(MainScreen.InputTitleEdit).clear();
        driver.findElement(MainScreen.InputTitleEdit).sendKeys(postTitle);
    }
    @Given("edito o Content")
    public void edito_o_content() {
        driver.findElement(MainScreen.InputContentEdit).clear();
        driver.findElement(MainScreen.InputContentEdit).sendKeys(postContent);
    }
    @Given("clico em Save")
    public void clico_em_save() throws InterruptedException {
        driver.findElement(MainScreen.SaveEdit).click();
        Thread.sleep(500);
    }
}