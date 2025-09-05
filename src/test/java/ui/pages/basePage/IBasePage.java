package ui.pages.basePage;

import com.codeborne.selenide.WebDriverRunner;
import core.context.ui.UiContextHolder;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static enums.CookieNameType.EXPIRES;
import static enums.CookieNameType.TOKEN;
import static enums.CookieNameType.USER_ID;
import static enums.CookieNameType.USERNAME;

public interface IBasePage {

  default void setAuthUserCookiesAndOpenPrivateAreaPage(String url) {
    Cookie[] cookies = {
      new Cookie(USER_ID.getCookieName(), UiContextHolder.getContext().getUserId()),
      new Cookie(USERNAME.getCookieName(), UiContextHolder.getContext().getUsername()),
      new Cookie(TOKEN.getCookieName(), UiContextHolder.getContext().getToken()),
      new Cookie(EXPIRES.getCookieName(), UiContextHolder.getContext().getExpiresDate()),
    };
    for (Cookie cookie : cookies) {
      WebDriverRunner.getWebDriver().manage().addCookie(cookie);
    }
    open(url);
  }
}