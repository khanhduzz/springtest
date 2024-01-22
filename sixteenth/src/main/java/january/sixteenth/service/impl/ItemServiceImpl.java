package january.sixteenth.service.impl;

import january.sixteenth.model.Item;
import january.sixteenth.repository.ItemRepository;
import january.sixteenth.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public String createItem(Item item) {
        itemRepository.save(item);
        return "Item created successfully";
    }

    @Override
    public String updateItem(Item item) {
        itemRepository.save(item);
        return "Item updated successfully";
    }

    @Override
    public String deleteItem(long itemId) {
        if (itemRepository.existsById(itemId)) {
            itemRepository.deleteById(itemId);
            return "Item deleted successfully";
        } else {
            return String.format("Item with id = %s does not exist.",itemId);
        }
    }

    @Override
    public Item getItem(long itemId) {
        if (itemRepository.findById(itemId).isPresent()) {
            return itemRepository.findById(itemId).get();
        } else {
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
