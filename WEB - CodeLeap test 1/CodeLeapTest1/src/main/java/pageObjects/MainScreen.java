package pageObjects;
import org.openqa.selenium.By;

public class MainScreen {
    public static final By TitleCodeLeap = By.xpath("//h1[text()='CodeLeap Network']");
    public static final By Title = By.xpath("//p[text()='Title']");
    public static final By InputTitle = By.xpath("//input[@name='title'][@placeholder='Hello world']");
    public static final By TitleContent = By.xpath("//p[text()='Content']");
    public static final By InputContent = By.xpath("//textarea[@name='content'][@placeholder='Content here']");
    public static final By ButtonCreate = By.xpath("//button[@class='btn-fill btn-upper']");
    public static final By PublicationTitle(String titulo){
        return By.xpath("//h2[@aria-hidden='true'][text()='"+titulo+"']");
    }

    public static final By LoginTitle = By.xpath("//*[contains(text()[2],'Usuário de Teste QA')]");
    public static final By PublicationContent(String conteudo){
        return By.xpath("//p[contains(text(),'"+conteudo+"') and @aria-hidden='true']");
    }
    public static final By ButtonDelete = By.xpath("(//*[@class='icon'][1])[1]");
    public static final By ButtonEdit = By.xpath("(//*[@class='icon'][2])[1]");
    public static final By InputTitleEdit = By.xpath("(//input[@name='title'][@placeholder='Hello world'])[2]");
    public static final By InputContentEdit = By.xpath("(//textarea[@name='content'][@placeholder='Content here'])[2]");
    public static final By SaveEdit = By.xpath("//button[@class='btn-fill btn-upper'][text()='Save']");
}
