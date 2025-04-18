package lk.ac.jfn.uoj.EduSpark.repo;

import lk.ac.jfn.uoj.EduSpark.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    Optional<UserEntity> findByName(String name);

}
