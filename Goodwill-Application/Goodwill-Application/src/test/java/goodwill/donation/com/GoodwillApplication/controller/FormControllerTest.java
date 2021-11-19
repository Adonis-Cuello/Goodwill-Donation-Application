package goodwill.donation.com.GoodwillApplication.controller;

import goodwill.donation.com.GoodwillApplication.BaseControllerTest;
import goodwill.donation.com.GoodwillApplication.model.Form;
import goodwill.donation.com.GoodwillApplication.model.Product;
import goodwill.donation.com.GoodwillApplication.model.User;
import goodwill.donation.com.GoodwillApplication.service.FormService;
import goodwill.donation.com.GoodwillApplication.service.FormServiceImpl;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class FormControllerTest extends BaseControllerTest {

    @MockBean
    private FormService mockFormService;

    @Autowired
    MockMvc mockMvc;

    private Form inputForm;
    private Form mockResponse1;
    private Form mockResponse2;

    @BeforeEach
    public void setUp(){
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
    @DisplayName("create a form successfully")
    void createForm() throws Exception {
        BDDMockito.doReturn(mockResponse1).when(mockFormService).create(any());

        mockMvc.perform(MockMvcRequestBuilders.post("/forms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(inputForm)))

                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.signature", Is.is("A")));
    }

    @Test
    @DisplayName("GET /forms/1 - Found")
    public void getFormByIdTestSuccess() throws Exception{
        BDDMockito.doReturn(mockResponse1).when(mockFormService).getFormById(1);

        mockMvc.perform(get("/forms/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.signature", is("A")));
    }

    @Test
    @DisplayName("PUT /forms/1 - Success")
    public void putFormTestSuccess() throws Exception{
        List<Product> products = new ArrayList<>();
        products.add(new Product("Old", "Nothing", 6, 2));
        products.add(new Product("New", "Never worn", 7, 0));
        User user = new User("Adonis Cuello", "Smyrna, DE");


        Form expectedFormUpdate = new Form(user, products, 2021, 500, "B", "Newark, DE");
        expectedFormUpdate.setId(1);
        BDDMockito.doReturn(expectedFormUpdate).when(mockFormService).update(any(), any());
        mockMvc.perform(put("/forms/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(inputForm)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.signature", is("B")));
    }

    @Test
    @DisplayName("DELETE /forms/1 - Success")
    public void deleteFormTestNotSuccess() throws Exception{
        BDDMockito.doReturn(true).when(mockFormService).deleteForm(any());
        mockMvc.perform(delete("/forms/{id}", 1))
                .andExpect(status().isNoContent());
    }














}