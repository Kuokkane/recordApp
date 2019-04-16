package hh.swd20.wilson.domain;
import hh.swd20.wilson.domain.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);

}