package pl.website.zuberek;

import org.springframework.data.repository.CrudRepository;
import pl.website.zuberek.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}