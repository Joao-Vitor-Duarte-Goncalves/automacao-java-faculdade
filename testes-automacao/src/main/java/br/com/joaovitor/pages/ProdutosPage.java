package br.com.joaovitor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutosPage {
    private WebDriver driver;

    // Selecionando a mochila "Sauce Labs Backpack"
    private By botaoAdicionarMochila = By.id("add-to-cart-sauce-labs-backpack");
    private By iconeCarrinho = By.className("shopping_cart_link");
    private By botaoCheckout = By.id("checkout");

    public ProdutosPage(WebDriver driver) {
        this.driver = driver;
    }

    public void adicionarMochilaAoCarrinho() {
        driver.findElement(botaoAdicionarMochila).click();
    }

    public void irParaCarrinho() {
        driver.findElement(iconeCarrinho).click();
    }

    public void clicarCheckout() {
        driver.findElement(botaoCheckout).click();
    }
}