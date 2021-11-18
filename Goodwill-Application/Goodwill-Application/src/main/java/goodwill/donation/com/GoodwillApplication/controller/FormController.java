package goodwill.donation.com.GoodwillApplication.controller;

import goodwill.donation.com.GoodwillApplication.exceptions.FormNotFoundException;
import goodwill.donation.com.GoodwillApplication.model.Form;

import goodwill.donation.com.GoodwillApplication.service.FormService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin("*")
@RequestMapping("/forms")
public class FormController {

    @Autowired
    private FormService formService;




    @GetMapping("/all")
    public ResponseEntity<List<Form>> getAllForms() {
        List<Form> trades = formService.getAllForms();
        ResponseEntity<List<Form>> response = new ResponseEntity<>(trades, HttpStatus.OK);
        return response;
    }

    @PostMapping("")
    public ResponseEntity<Form> createForm(@RequestBody  Form form) {
        Form saved = formService.create(form);
//        User userSaved = userService.create(user);
//        Product productSaved = productService.create(product);

        ResponseEntity response = new ResponseEntity(saved, HttpStatus.CREATED);
        return response;
    }

//    @PostMapping("/forms/submit")
//    public RedirectView submitPost(
//            HttpServletRequest request,
//            @ModelAttribute Form form,
//            RedirectAttributes redirectAttributes) {
//        if (Form.isValidPoem(form)) {
//            redirectAttributes.addFlashAttribute("form", form);
//            return new RedirectView("/forms/submit", true);
//        } else {
//            return new RedirectView("/forms/submit", true);
//        }
//    }

    @GetMapping("/forms/success")
    public String getSuccess(HttpServletRequest request) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            Form form = (Form) inputFlashMap.get("form");
            return "success";
        } else {
            return "redirect:/forms/submit";
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateForm(@PathVariable Integer id, @RequestBody Form form) {
        try {
            Form updatedForm = formService.update(id, form);
            ResponseEntity response = new ResponseEntity(updatedForm, HttpStatus.OK);
            return response;
        } catch (FormNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteForm(@PathVariable Integer id) {
        try {
            formService.deleteForm(id);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (FormNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}
