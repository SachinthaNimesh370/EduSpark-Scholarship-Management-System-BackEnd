package lk.ac.jfn.uoj.EduSpark.entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "user")
@Data
public class UserEntity {
    @Id
    int id;
    String name;
    String email;
    String password;
}
