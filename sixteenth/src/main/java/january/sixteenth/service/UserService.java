package january.sixteenth.service;


import january.sixteenth.model.Item;
import january.sixteenth.model.User;

import java.util.List;

public interface UserService {
    public User getUser(long userId);
    public List<User> getAllUser();
    public String createUser(User user);
    public String updateUser(User user);
    public String deleteUser(long userId);
    public String addItemToUser(long userId, long itemId);
    public List<Item> getAllAddItem(long userId);
}
