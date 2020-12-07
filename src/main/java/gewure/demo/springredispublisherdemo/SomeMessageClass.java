package gewure.demo.springredispublisherdemo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@Data
public class SomeMessageClass {

    @Id
    public String id;
    public String sender;
    public String message;
    public long timestamp;

    public SomeMessageClass(String id, String sender, String message, long timestamp) {
        this.id = id;
        this.sender = sender;
        this.message = message;
        this.timestamp = timestamp;
    }
}
