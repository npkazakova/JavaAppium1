package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArticleTests extends CoreTestCase
{
    @Test
    public void testCompareArticleDescription() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        String search_line = "Java";
        String article_title = "Java (programming language)";

        if (!isPlatformIOS()) {
            SearchPageObject.clickSkipButton();
        }
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring(article_title);

        if (isPlatformIOS()) {
            String article_description = ArticlePageObject.getArticleDescription();

            assertEquals(
                    "We see unexpected description!",
                    "Object-oriented programming language",
                    article_description
            );
        }

//        String article_description = ArticlePageObject.getArticleDescription();
//
//        assertEquals(
//                "We see unexpected description!",
//                "Object-oriented programming language",
//                article_description
//        );
    }

    @Test
    public void testArticleHasDescription() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        String search_line = "Java";
        String article_description = "Object-oriented programming language";

        if (!isPlatformIOS()) {
            SearchPageObject.clickSkipButton();
        }
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring(article_description);
        if (isPlatformIOS()) {
            ArticlePageObject.waitForTitleElement();
            ArticlePageObject.assertArticleDescriptionPresent();
        }
//        ArticlePageObject.waitForDescriptionElement();
//        ArticlePageObject.assertArticleDescriptionPresent();
    }

    @Test
    public void testSwipeArticle() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        String search_line = "Java";
        String article_description = "Object-oriented programming language";

        if (!isPlatformIOS()) {
            SearchPageObject.clickSkipButton();
        }
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring(article_description);

        if (isPlatformIOS()) {
            ArticlePageObject.waitForDescriptionElement();
        }
        ArticlePageObject.swipeToFooter();
    }
}
