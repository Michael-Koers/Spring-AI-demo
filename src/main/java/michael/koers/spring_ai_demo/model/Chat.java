package michael.koers.spring_ai_demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class Chat {
    String sender;
    String message;
}
