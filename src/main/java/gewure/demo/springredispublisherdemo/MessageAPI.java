package gewure.demo.springredispublisherdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MessageAPI {

    private final PublisherService publisherService;

    @Autowired
    public MessageAPI(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(value ="/msg")
    public String sendMessage(
            @RequestParam(value = "msg") String msg,
            @RequestParam(value="sender") String sender) {

            publisherService.publish(new SomeMessageClass(UUID.randomUUID().toString(),msg, sender,System.currentTimeMillis() ).toString());
            return "published";
    }
}
