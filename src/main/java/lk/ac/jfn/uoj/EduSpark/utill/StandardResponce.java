package lk.ac.jfn.uoj.EduSpark.utill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponce {
    private  int code;
    private String message;
    private Object data;
}
