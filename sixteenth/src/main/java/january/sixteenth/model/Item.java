package january.sixteenth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="item_table")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Item_ID")
    private long itemId;
    private String name;
    private String description;
    private String price;
    private String date;

    @ManyToMany(mappedBy = "items")
    @JsonIgnore
    private List<User> users;
}
