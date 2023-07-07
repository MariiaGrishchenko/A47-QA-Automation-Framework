import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public String addSongToPlaylist() {

        String addedSongNotificationText = "Added 1 song into Test";

        navigateToPage();
        enterEmail("mariia868g@gmail.com");
        enterPassword("te$t$tudent");
        clickLoginBatton();
        searchSong("Epic Song");
        clickViewAllButton();
        clickFirstSong();
        clickAddToButton();
        clickTestAlbum();
        Assert.assertTrue(notificationMessageDisplayed().contains(addedSongNotificationText));
    }

        public void searchSong(String songName){
            WebElement searchField = driver.findElement(By.cssSelector("input[type = &#39;search&#39;]"));
            searchField.click();
            searchField.clear();
            searchField.sendKeys(songName);
        }

        public void clickViewAllButton(){
            WebElement vewAll = driver.findElement(By.cssSelector("[data-test = &#39;view-all- songs-btn&#39;]"));
            vewAll.click();
        }

        public void clickFirstSong(){
            WebElement firstSong = driver.findElement(By.xpath("[//th[@class=&#39;track-number&#39;][1]"));
            firstSong.click();
        }

        public void clickAddToButton(){
            WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add to"));
            addToButton.click();
        }

        public void clickTestAlbum(){
            WebElement testAlbum = driver.findElement(By.cssSelector("/section[@id=&#39;songResultsWrapper&#39;]//li[contains(text(),&#39;Test&#39;)]"));
            testAlbum.click();
        }

        public String notificationMessageDisplayed(){
            WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
            return notificationMessage.getText();
        }

}