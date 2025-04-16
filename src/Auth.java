import java.util.ArrayList;
import java.util.Scanner;

interface Auth {
    void login(String username, String password) throws InvalidCredentialsException;
}

