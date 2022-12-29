package pl.website.zuberek;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Register, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Register u SET u.enabled = true WHERE u.id = ?1") //select user a potem update enable to true
    void enableUser(Integer id);
}