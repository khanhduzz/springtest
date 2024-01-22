package january.sixteenth.service;

import january.sixteenth.model.Item;

import java.util.List;

public interface ItemService {
    public String createItem(Item item);
    public String updateItem(Item item);
    public String deleteItem(long itemId);
    public Item getItem(long itemId);
    public List<Item> getAllItems();
}
