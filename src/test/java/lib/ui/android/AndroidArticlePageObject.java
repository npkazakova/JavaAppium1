package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
        //ANDROID_ARTICLE_DESCRIPTION = "org.wikipedia:id/page_contents_container";
        ANDROID_ARTICLE_DESCRIPTION = "id:org.wikipedia:id/page_web_view";
        ANDROID_ARTICLE_DESCRIPTION_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description'][contains(@text,'{SUBSTRING}')]";
        FOOTER_ELEMENT = "id:org.wikipedia:id/page_web_view";
        SAVE_BUTTON = "xpath://*[contains(@text, 'Save')]";
        NAVIGATE_UP_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        SAVED_BUTTON = "xpath://android.widget.FrameLayout[@content-desc='Saved']";
        SAVED_ARTICLE = "xpath://*[@text='Java (programming language)']";
        ARTICLES_NEW_LIST_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][contains(@text,'{SUBSTRING}')]";
        ARTICLES_LIST_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][contains(@text,'{SUBSTRING}')]";
        ADD_TO_LIST_BUTTON = "xpath://*[@text='Add to list']";
        VIEW_LIST_BUTTON = "xpath://*[@text='View list']";
        INPUT_NAME_OF_LIST = "xpath://*[@text='Name of this list']";
        OK_BUTTON = "xpath://*[@text='OK']";
    }

    public AndroidArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
