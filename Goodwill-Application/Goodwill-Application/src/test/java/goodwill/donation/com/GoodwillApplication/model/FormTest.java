package goodwill.donation.com.GoodwillApplication.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FormTest {
    private Form form1;
    private Form form2;

    private Form emptyForm1;
    private Form emptyForm2;

    @BeforeEach
    public void setUp() {
        emptyForm1 = new Form();
        emptyForm2 = new Form();

        List<Product> products = new ArrayList<>();
        products.add(new Product("Old", "Nothing", 6, 2));
        products.add(new Product("New", "Never worn", 7, 0));

        User user = new User("Adonis Cuello", "Smyrna, DE");
        User user2 = new User("Alvina Waseem", "Bear, DE");


        form1 = new Form(user2, products, 2021, 600, "A", "Newark, DE");
        form1.setId(1);

        form2 = new Form(user, products, 2014, 300, "B", "Newark, DE");
        form2.setId(2);
    }

    @Test
    public void testEmptyEquals() throws Exception {

        assertTrue(
                emptyForm1.equals(emptyForm2),
                "Both empty Form instances should be equal");
    }

    @Test
    public void testContentEquals() throws Exception {

        assertTrue(
                form1.equals(form2),
                "Both non-empty Form instances should be equal");
    }

    @Test
    public void testNotEquals() throws Exception {

        assertFalse(
                emptyForm1.equals(form2),
                "The Form instances should not be equal");
    }

    @Test
    public void testEmptyHashCode() throws Exception {

        assertEquals(
                emptyForm1.hashCode(),
                emptyForm2.hashCode(),
                "Both empty Form instances should have the same hashCode");
    }

    @Test
    public void testContentHashCode() throws Exception {

        assertEquals(
                form1.hashCode(),
                form2.hashCode(),
                "Both non-empty Form instances should have the same hashCode");
    }

    @Test
    public void testHashCode() throws Exception {

        assertNotEquals(
                emptyForm1.hashCode(),
                form2.hashCode(),
                "The Form instances should not have the same hashCode");
    }

    @Test
    public void testEmptyToString() throws Exception {

        assertEquals(
                emptyForm1.toString(),
                emptyForm1.toString(),
                "Both empty Form instances should have the same toString");
    }

    @Test
    public void testContentToString() throws Exception {

        assertEquals(
                form1.toString(),
                form2.toString(),
                "Both non-empty Form instances should have the same toString");
    }

    @Test
    public void testNotToString() throws Exception {

        assertNotEquals(
                emptyForm1.toString(),
                form2.toString(),
                "The Widget instances should not have the same toString");
    }
}