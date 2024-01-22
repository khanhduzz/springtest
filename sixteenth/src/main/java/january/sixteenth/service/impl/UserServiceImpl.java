package january.sixteenth.service.impl;

import jakarta.transaction.Transactional;
import january.sixteenth.model.Item;
import january.sixteenth.model.User;
import january.sixteenth.repository.ItemRepository;
import january.sixteenth.repository.UserRepository;
import january.sixteenth.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    ItemRepository itemRepository;
    public UserServiceImpl(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public User getUser(long userId) {
        if (userRepository.findById(userId).isPresent()) {
            return userRepository.findById(userId).get();
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "User created successfully";
    }

    @Override
    public String updateUser(User user) {
        userRepository.save(user);
        return "User updated successfully";
    }

    @Override
    public String deleteUser(long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return "Delete user successfully";
        } else {
            return String.format("User with id = %s does not exist",userId);
        }
    }

    @Override
    public String addItemToUser(long userId, long itemId) {
        User user;
        Item item;
        if (userRepository.findById(userId).isPresent() && itemRepository.findById(itemId).isPresent()) {
            user = userRepository.findById(userId).get();
            item = itemRepository.findById(itemId).get();
        } else {
            return "User or item do not exist";
        }
        user.getItems().add(item);
        userRepository.save(user);
        return "Add item successfully";
    }

    @Override
    public List<Item> getAllAddItem(long userId) {
        User user;
        if (userRepository.findById(userId).isPresent()) {
            user = userRepository.findById(userId).get();
            return user.getItems();
        } else {
            return null;
        }
    }
}
