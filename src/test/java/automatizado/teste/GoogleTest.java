package automatizado.teste;

import static org.junit.Assert.assertTrue;

// import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
// import org.openqa.selenium.By;
/// import org.openqa.selenium.Keys;
// import org.openqa.selenium.WebElement;

import automatizado.page.GooglePO;


public class GoogleTest extends BaseTeste {


    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes(){
        driver.get("https://www.google.com/");
        googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001_deveSerPossivelPesquisarNoGoogleOTextoBatataFrita() {    

        //Arrange - Preparação
        // WebElement inputPesquisa = driver.findElement(By.name("q"));

        // googlePage.inputPesquisa.sendKeys("Batata frita" + Keys.ENTER);

        googlePage.pesquisar("Batata frita");

        // String resultado = driver.findElement(By.id("result-stats")).getText();
        
        String resultado = googlePage.obterResultadoDaPesquisa();

        assertTrue(resultado, resultado.contains("Aproximadamente"));      

    }


    @Test 
    public void TC002_deveSerPossivelPesquisarNoGooleOTextoNutella() {
        googlePage.pesquisar("Nutella");

        String resultado = googlePage.obterResultadoDaPesquisa();
        
        assertTrue(resultado, resultado.contains("resultados"));
    }

}
