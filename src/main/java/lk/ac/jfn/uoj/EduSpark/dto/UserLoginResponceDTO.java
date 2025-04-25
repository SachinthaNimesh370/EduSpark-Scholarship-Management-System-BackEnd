package lk.ac.jfn.uoj.EduSpark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserLoginResponceDTO {
    private Object token;
    private LocalDateTime time;
}
