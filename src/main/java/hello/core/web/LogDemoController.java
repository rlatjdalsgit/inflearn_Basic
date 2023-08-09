package hello.core.web;


import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    //나중에 구현할 서비스 객체
    private final MyLogger myLogger;

    @RequestMapping("log-demo")//라는 요청이 오면
    @ResponseBody//문자열 바로 반환
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();//고객이 어떤 URL로 요청했는지 알 수가 있다.
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";

    }
}
