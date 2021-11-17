package goodwill.donation.com.GoodwillApplication.service;

import goodwill.donation.com.GoodwillApplication.model.Form;
import goodwill.donation.com.GoodwillApplication.model.User;
import goodwill.donation.com.GoodwillApplication.repo.FormRepo;
import goodwill.donation.com.GoodwillApplication.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveUserDataImpl {

    private UserRepo userRepo;

    @Autowired
    public SaveUserDataImpl(UserRepo userRepo){this.userRepo = userRepo;}



    public User storeUserData(User user){
        User savedUser = (User) userRepo.save(user);
        return savedUser;
    }

    public User create(User user){
        User savedUser = userRepo.save(user);
        return savedUser;
    }

}
