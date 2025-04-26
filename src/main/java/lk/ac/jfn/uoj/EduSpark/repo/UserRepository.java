package lk.ac.jfn.uoj.EduSpark.repo;

import lk.ac.jfn.uoj.EduSpark.entity.UserEntity;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    Optional<UserEntity> findByName(String name);
    boolean existsByName(String name);

    @Query("SELECT u.role FROM UserEntity u WHERE u.name = :name")
    String findRoleByName(String name);



}
