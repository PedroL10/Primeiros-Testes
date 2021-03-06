package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
Classe base para criação das novas PagesObjects
Todas as pages devem ser herdadas dessa classe
 */
public abstract class BasePO {
    
    /**Driver base que será usado pelas pages */
    protected WebDriver driver;

    /**
     * Construtor base para criação da fabrica de elementos
     * @param driver Driver da pagina atual.
     */
    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
