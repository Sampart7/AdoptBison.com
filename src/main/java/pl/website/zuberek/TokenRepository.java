package pl.website.zuberek;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token, Integer> {
    /**
     * @param token
     * @return
     * displaying the generated token
     */
    @Query("SELECT t FROM Token t WHERE t.token = ?1")
    public Token GetTokenByString(String token);
}