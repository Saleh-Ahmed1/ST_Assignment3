import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginAppTest {
    private LoginApp loginApp;

    @BeforeEach
    public void setUp() {
        loginApp = new LoginApp();
    }

    @Test
    public void testSuccessfulLogin() {
        String email = "johndoe@example.com";
        String password = "password123";
        String result = loginApp.authenticateUser(email, password);
        assertNotNull(result, "User should be found");
        assertEquals("John Doe", result, "Expected user name does not match");
    }

    @Test
    public void testInvalidEmail() {
        String email = "invalid@example.com";
        String password = "password123";

        String result = loginApp.authenticateUser(email, password);
        assertNull(result, "User should not be found");
    }

    @Test
    public void testInvalidPassword() {
        String email = "johndoe@example.com";
        String password = "invalid";

        String result = loginApp.authenticateUser(email, password);
        assertNull(result, "User should not be found");
    }

    @Test
    public void testEmptyEmailField() {
        String email = "";
        String password = "password123";
        String result = loginApp.authenticateUser(email, password);
        assertNull(result, "User should not be found");
    }

    @Test
    public void testEmptyPasswordField() {
        String email = "johndoe@example.com";
        String password = "";
        String result = loginApp.authenticateUser(email, password);
        assertNull(result, "User should not be found");
    }
}

