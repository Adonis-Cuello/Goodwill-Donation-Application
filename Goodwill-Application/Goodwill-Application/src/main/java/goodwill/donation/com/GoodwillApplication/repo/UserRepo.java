package goodwill.donation.com.GoodwillApplication.repo;

import goodwill.donation.com.GoodwillApplication.model.Form;
import goodwill.donation.com.GoodwillApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>{
}
