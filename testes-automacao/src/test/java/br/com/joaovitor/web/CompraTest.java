package br.com.joaovitor.web;

import br.com.joaovitor.pages.LoginPage;
import br.com.joaovitor.pages.ProdutosPage;
import br.com.joaovitor.pages.CheckoutPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class CompraTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProdutosPage produtosPage;
    private CheckoutPage checkoutPage;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-save-password-bubble");
        
        options.addArguments("--headless=new"); 
        
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        
        loginPage = new LoginPage(driver);
        produtosPage = new ProdutosPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    @DisplayName("Deve realizar uma compra completa de ponta a ponta")
    public void testCompraCompleta() throws InterruptedException {

        loginPage.realizarLogin("standard_user", "secret_sauce");
        Thread.sleep(2000); 

        produtosPage.adicionarMochilaAoCarrinho();
        Thread.sleep(1500);
        produtosPage.irParaCarrinho();
        Thread.sleep(1500);
        produtosPage.clicarCheckout();
        

        checkoutPage.preencherDadosEContinuar("Joao", "Vitor", "64000-000");
        Thread.sleep(2000);

        checkoutPage.finalizarCompra();
        
        String mensagem = checkoutPage.obterMensagemSucesso();
        Assertions.assertEquals("Thank you for your order!", mensagem);
        
        Thread.sleep(5000);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}