package lk.ac.jfn.uoj.EduSpark.repo;

import lk.ac.jfn.uoj.EduSpark.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
