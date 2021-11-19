package goodwill.donation.com.GoodwillApplication.service;

import goodwill.donation.com.GoodwillApplication.exceptions.FormNotFoundException;
import goodwill.donation.com.GoodwillApplication.model.Form;
import goodwill.donation.com.GoodwillApplication.model.Product;
import goodwill.donation.com.GoodwillApplication.model.User;
import goodwill.donation.com.GoodwillApplication.repo.FormRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class FormServiceTest {

    @MockBean
    private FormRepo mockFormRepo;

    @Autowired
    FormService formService;

    private Form inputForm;
    private Form mockResponse1;
    private Form mockResponse2;

    @BeforeEach
    public void setUp() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Old", "Nothing", 6, 2));
        products.add(new Product("New", "Never worn", 7, 0));

        User user = new User("Adonis Cuello", "Smyrna, DE");
        User user2 = new User("Alvina Waseem", "Bear, DE");


        inputForm = new Form(user, products, 2021, 500, "A", "Newark, DE");

        mockResponse1 = new Form(user2, products, 2021, 600, "A", "Newark, DE");
        mockResponse1.setId(1);

        mockResponse2 = new Form(user, products, 2014, 300, "B", "Newark, DE");
        mockResponse2.setId(2);
    }

    @Test
    @DisplayName("Create Form Success")
    public void createForm() {
        BDDMockito.doReturn(mockResponse1).when(mockFormRepo).save(ArgumentMatchers.any());
        Form returnedForm = formService.create(inputForm);
        Assertions.assertNotNull(returnedForm, "form shouldnt be null");
        Assertions.assertEquals(returnedForm.getId(), 1);
    }

    @Test
    @DisplayName("Form Service: Get Form by Id - Success")
    public void getFormByIdTestSuccess() throws FormNotFoundException {
        BDDMockito.doReturn(Optional.of(mockResponse1)).when(mockFormRepo).findById(1);
        Form foundForm = formService.getFormById(1);
        Assertions.assertEquals(mockResponse1.toString(), foundForm.toString());
    }

    @Test
    @DisplayName("Form Service: Get All forms - Success")
    public void getAllFormsTestSuccess(){
        List<Form> forms = new ArrayList<>();
        forms.add(mockResponse1);
        forms.add(mockResponse2);

        BDDMockito.doReturn(forms).when(mockFormRepo).findAll();

        List<Form> responseWidgets = formService.getAllForms();
        Assertions.assertIterableEquals(forms,responseWidgets);
    }

    @Test
    @DisplayName("Form Service: Update Form - Success")
    public void updateFormTestSuccess() throws FormNotFoundException {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Old", "Nothing", 6, 2));
        products.add(new Product("New", "Never worn", 7, 0));
        User user = new User("Adonis Cuello", "Smyrna, DE");
        Form expectedFormUpdate = new Form(user, products, 2021, 500, "B", "Newark, DE");

        BDDMockito.doReturn(Optional.of(mockResponse1)).when(mockFormRepo).findById(1);
        BDDMockito.doReturn(expectedFormUpdate).when(mockFormRepo).save(ArgumentMatchers.any());

        Form actualWidget = formService.update(1, expectedFormUpdate);
        Assertions.assertEquals(expectedFormUpdate.toString(), actualWidget.toString());
    }

    @Test
    @DisplayName("Form Service: Delete Form - Success")
    public void deleteFormTestSuccess() throws FormNotFoundException {
        BDDMockito.doReturn(Optional.of(mockResponse1)).when(mockFormRepo).findById(1);
        Boolean actualResponse = formService.deleteForm(1);
        Assertions.assertTrue(actualResponse);
    }












}