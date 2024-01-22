package january.sixteenth.controller;

import january.sixteenth.model.Item;
import january.sixteenth.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@CrossOrigin("http://localhost:3000/")
public class ItemController {
    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("{itemId}")
    public Item getItem(@PathVariable("itemId") long itemId) {
        return itemService.getItem(itemId);
    }
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
    @PostMapping()
    public String createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }
    @PutMapping()
    public String updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }
    @DeleteMapping("{itemId}")
    public String deleteItem(@PathVariable("itemId") long itemId) {
        return itemService.deleteItem(itemId);
    }
}
