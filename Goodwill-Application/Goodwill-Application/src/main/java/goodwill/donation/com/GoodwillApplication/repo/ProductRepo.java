package goodwill.donation.com.GoodwillApplication.repo;

import goodwill.donation.com.GoodwillApplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
