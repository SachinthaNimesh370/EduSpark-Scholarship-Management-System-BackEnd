package lk.ac.jfn.uoj.EduSpark.repo;

import lk.ac.jfn.uoj.EduSpark.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity,Integer> {

    Optional<UserEntity> findByName(String name);

}
