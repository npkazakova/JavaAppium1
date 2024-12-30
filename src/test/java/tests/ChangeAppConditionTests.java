package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {

    @Test
    public void testChangeScreenOrientationOnSearchResults()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        String search_line = "Java";
        String article_title = "Java (programming language)";

        SearchPageObject.clickSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring(article_title);


        String description_before_rotation = ArticlePageObject.getArticleDescription();
        this.rotateScreenLandscape();
        String description_after_rotation = ArticlePageObject.getArticleDescription();

        assertEquals(
                "Article description has been changed after screen rotation",
                description_before_rotation,
                description_after_rotation
        );

        this.rotateScreenPortrait();
        String description_after_second_rotation = ArticlePageObject.getArticleDescription();

        assertEquals(
                "Article description has been changed after screen rotation",
                description_before_rotation,
                description_after_second_rotation
        );
    }

    @Test
    public void testCheckSearchArticleInBackground()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        String search_line = "Java";
        String article_title = "Java (programming language)";

        SearchPageObject.clickSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForSearchResult(article_title);

        this.backgroundApp(2);
        SearchPageObject.waitForSearchResult(article_title); // баг в приложении, поиск сбрасывается после возвращения из фона
    }
}