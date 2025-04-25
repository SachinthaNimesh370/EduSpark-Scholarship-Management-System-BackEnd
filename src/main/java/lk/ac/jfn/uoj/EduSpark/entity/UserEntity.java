package lk.ac.jfn.uoj.EduSpark.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class UserEntity {
    @Id
    int id;
    String name;
    String email;
    String password;
}
