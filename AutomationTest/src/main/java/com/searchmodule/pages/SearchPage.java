package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(id="search_form_input_homepage")
    private WebElement searchTxtField;

    @FindBy(id="search_button_homepage")
    private WebElement searchBtn;

    @FindBy(linkText="Videos")
    private WebElement videosLink;

    @FindBy(className="tile--vid")
    private List<WebElement> videosList;


    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String keyword){
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTxtField));
        this.searchTxtField.sendKeys(keyword);
        this.searchBtn.click();
    }

    public void goToVideo(){
        this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));
        this.videosLink.click();
    }

    public int getResult(){
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        System.out.println(this.videosList.size());
        return videosList.size();
    }


}
