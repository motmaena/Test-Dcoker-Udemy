package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SearchTests extends BaseTests {

    @Test
    @Parameters({"keyword"})
    public void search(String keyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideo();
        int size = searchPage.getResult();

        Assert.assertTrue(size > 0);
    }
}
