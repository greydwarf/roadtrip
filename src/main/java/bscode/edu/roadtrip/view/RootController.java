package bscode.edu.roadtrip.view;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@AllArgsConstructor
public class RootController {
    private final RootService service;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView index(@AuthenticationPrincipal OAuth2User principal) {

        ModelAndView mav = new ModelAndView("index");
        service.prepareIndex(principal, mav);
        return mav;
    }
}
