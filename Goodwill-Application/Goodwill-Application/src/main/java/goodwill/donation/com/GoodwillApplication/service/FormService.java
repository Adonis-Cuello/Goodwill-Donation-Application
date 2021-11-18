package goodwill.donation.com.GoodwillApplication.service;

import goodwill.donation.com.GoodwillApplication.exceptions.FormNotFoundException;
import goodwill.donation.com.GoodwillApplication.model.Form;

import java.util.List;

public interface FormService {
    Form create(Form form);
    List<Form> getAllForms();
    Form update(Integer id, Form form) throws FormNotFoundException;
    Boolean deleteForm(Integer id) throws FormNotFoundException;


}
