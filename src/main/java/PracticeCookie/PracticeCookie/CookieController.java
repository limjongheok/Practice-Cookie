package PracticeCookie.PracticeCookie;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestController
public class CookieController {
    // 쿠키 쓰기
    @GetMapping("/setCookie")
    public String setCookie(HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("username","Lim");
        cookie.setMaxAge(7 * 24 * 60 * 60);
        httpServletResponse.addCookie(cookie);
        return "Username is changed";
    }
    // 쿠기 읽기
    @GetMapping("/getCookie")
    public String readCookie(@CookieValue (value = "userName", defaultValue= "Atta") String username){
        return username;
    }

    // 모든 쿠키 읽기
    @GetMapping("/getCookies")
    public String readCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }
        return  "확인";
    }

    @GetMapping("/deleteCookie")
    public String deleteCookies(HttpServletResponse servletResponse){
        Cookie cookie = new Cookie("userName","null");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        servletResponse.addCookie(cookie);
        return "cookie 삭제 ";
    }
}
