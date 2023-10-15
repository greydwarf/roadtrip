package bscode.edu.roadtrip.view;

import bscode.edu.roadtrip.api.PlaylistRepository;
import bscode.edu.roadtrip.api.User;
import bscode.edu.roadtrip.api.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RootService {
    private final PlaylistRepository playlistRepo;
    private final UserRepository userRepo;

    void prepareIndex(OAuth2User principal, ModelAndView mav) {
        Optional<User> maybeUser = userRepo.findById(principal.getName());
        User user = maybeUser.orElseGet(() -> addUser(principal));
        var playlists = playlistRepo.findByEditor(user);
        mav.addObject("user", user);
        mav.addObject("playlists", playlists);
    }

    private User addUser(OAuth2User principal) {
        var ret = new User(principal.getName(), (String)principal.getAttributes().get("name"));
        userRepo.save(ret);
        return ret;
    }
}
