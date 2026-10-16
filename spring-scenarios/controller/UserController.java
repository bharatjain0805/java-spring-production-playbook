package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    public ResponseEntity<UserResponse> getUser(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String email) {
        if (id != null) {
            return ResponseEntity.ok(userService.findById(id));
        } else if (email != null) {
            return ResponseEntity.ok(userService.findByEmail(email));
        }
        return ResponseEntity.badRequest().build();
    }
}