package core.utils.cookie;

import com.codeborne.selenide.WebDriverRunner;
import core.context.ContextHolder;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static enums.CookieNameType.EXPIRES;
import static enums.CookieNameType.TOKEN;
import static enums.CookieNameType.USERNAME;
import static enums.CookieNameType.USER_ID;

public class CookieUtils {

  public static void setAuthUserCookiesAndOpenPrivateAreaPage(String url) {
    Cookie[] cookies = {
      new Cookie(USER_ID.getCookieName(), ContextHolder.getContext().getUserId()),
      new Cookie(USERNAME.getCookieName(), ContextHolder.getContext().getUsername()),
      new Cookie(TOKEN.getCookieName(), ContextHolder.getContext().getToken()),
      new Cookie(EXPIRES.getCookieName(), ContextHolder.getContext().getExpiresDate()),
    };
    for (Cookie cookie : cookies) {
      WebDriverRunner.getWebDriver().manage().addCookie(cookie);
    }
    open(url);
  }
}