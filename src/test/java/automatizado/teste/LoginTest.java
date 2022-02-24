package automatizado.teste;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTeste{
    private static LoginPO loginPage;


    /**
     * Metodo que tenta executar a ação de logar no sistema
     * @param email Email para tentativa de login   
     * @param senha Senha para tentativa de login
     */
    private void executarAcaoDeLogar(String email, String senha) {
        loginPage.escrever(loginPage.inputEmail, email);
        loginPage.escrever(loginPage.inputSenha, senha);

        loginPage.buttonEntrar.click();
    }

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {   

        //Como essa ação de logar e clicar estava sendo repetida, joguei para dentro de um metodo

        executarAcaoDeLogar("", "");

        //loginPage.inputEmail.sendKeys("");
        //loginPage.escrever(loginPage.inputEmail, "");
        // O teste nao tem que saber nada especifico da sua pagina, o teste deve testar

        //loginPage.inputSenha.sendKeys("");
        //loginPage.escrever(loginPage.inputSenha, "");

        //loginPage.buttonEntrar.click();

        String mensagem = loginPage.obterMensagem();
        // como essa mensagem será recebeida não é responsabilidade do teste
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos." );    
    }


    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia() {  

        executarAcaoDeLogar("teste", "");
        String mensagem = loginPage.obterMensagem();
        // como essa mensagem será recebeida não é responsabilidade do teste

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos." );
    
    }


    @Test
    public void TC003_naoDeveLogarNoSistemaComSenhaIncorretaEEmailVazio() {         

        executarAcaoDeLogar("", "teste");

        String mensagem = loginPage.obterMensagem();
        // como essa mensagem será recebeida não é responsabilidade do teste

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos." );
    
    }

    @Test
    public void TC004_naoDeveLogarNoSistemaComSenhaEEmailInvalidos() {         

        executarAcaoDeLogar("teste", "teste");

        String mensagem = loginPage.obterMensagem();
        

        assertEquals(mensagem, "E-mail ou senha inválidos" );
    
    }

    @Test
    public void TC005_naoDeveLogarNoSistemaComEmailCorretoESenhaInvalida() {         

        executarAcaoDeLogar("admin@admin.com", "teste");

        String mensagem = loginPage.obterMensagem();
        

        assertEquals(mensagem, "E-mail ou senha inválidos" );
    
    }

    @Test
    public void TC006_naoDeveLogarNoSistemaComSenhaCorretaEEmailInvalido() {         

        executarAcaoDeLogar("Aadmin@admin.com", "admin@123");

        String mensagem = loginPage.obterMensagem();
        

        assertEquals(mensagem, "E-mail ou senha inválidos" );
    
    }

    @Test
    public void TC007_deveLogarNoSistemaComSenhaEEmailValidos() {         

        executarAcaoDeLogar("admin@admin.com", "admin@123");   
        

        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");
    
    }

}
