package pl.website.zuberek;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Register, Integer> {
    /**
     * @param id
     *we update the user's availability information in the database
     */
    @Transactional
    @Modifying
    @Query("UPDATE Register u SET u.enabled = true WHERE u.id = ?1")
    void enableUser(Integer id);

    /**
     * @param email
     * @return
     * we are looking for a user by email
     */
    public Optional<Register> findByEmail(String email);
}