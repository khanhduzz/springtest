package january.sixteenth.controller;

import january.sixteenth.model.Item;
import january.sixteenth.model.User;
import january.sixteenth.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000/")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("{userId}")
    public User getUser(@PathVariable("userId") long userId) {
        return userService.getUser(userId);
    }
    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
    @PostMapping()
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @PutMapping()
    public String updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable("userId") Long userId){
        return userService.deleteUser(userId);
    }
    @PostMapping("{userId}/{itemId}")
    public String addItemToUser(@PathVariable("userId") Long userId, @PathVariable("itemId") Long itemId) {
        return userService.addItemToUser(userId, itemId);
    }
    @GetMapping("allItems/{userId}")
    public List<Item> getAllAddItem(@PathVariable("userId") Long userId) {
        return userService.getAllAddItem(userId);
    }
}
