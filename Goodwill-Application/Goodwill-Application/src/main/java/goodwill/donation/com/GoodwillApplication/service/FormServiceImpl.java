package goodwill.donation.com.GoodwillApplication.service;

import goodwill.donation.com.GoodwillApplication.exceptions.FormNotFoundException;
import goodwill.donation.com.GoodwillApplication.model.Form;
import goodwill.donation.com.GoodwillApplication.repo.FormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormServiceImpl implements FormService {

    private FormRepo formRepo;

    @Autowired
    public FormServiceImpl(FormRepo formRepo){this.formRepo = formRepo;}

    public List<Form> getAllForms(){
        return formRepo.findAll();
    }

    public Form create(Form form){
        Form savedForm = formRepo.save(form);
        return savedForm;
    }

    public Form update(Integer id, Form form) throws FormNotFoundException{
        Optional<Form> formOptional = formRepo.findById(id);
        if (formOptional.isEmpty()){
            throw new FormNotFoundException("Form request not found");
        }
        Form savedForm = formOptional.get();
        return formRepo.save(savedForm);
    }

    public Boolean deleteForm(Integer id) throws FormNotFoundException{
        Optional<Form> formOptional = formRepo.findById(id);
        if (formOptional.isEmpty()){
            throw new FormNotFoundException("Cannot delete, Form doesn't exist");
        }
        Form tradeToDelete = formOptional.get();
        formRepo.delete(tradeToDelete);
        return true;
    }

    @Override
    public Form getFormById(Integer id)  throws FormNotFoundException{
        Optional<Form> widgetOptional = formRepo.findById(id);
        if(widgetOptional.isEmpty()){
            throw new FormNotFoundException("Form not found");
        }
        return widgetOptional.get();
    }
}
