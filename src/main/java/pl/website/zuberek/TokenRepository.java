package pl.website.zuberek;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token, Integer> {
    @Query("SELECT t FROM Token t WHERE t.token = ?1") //kod sql wyświetlić token z bazy danych select token from token okej
    public Token GetTokenByString(String token);
}