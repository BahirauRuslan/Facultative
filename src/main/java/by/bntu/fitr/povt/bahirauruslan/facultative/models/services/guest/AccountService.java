package by.bntu.fitr.povt.bahirauruslan.facultative.models.services.guest;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.IDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.JdbcAccountDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Account;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.util.registration.RegistrationResult;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.util.authentication.AuthenticationResult;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.util.authentication.PasswordAuthentication;

import java.util.List;

public class AccountService {
    private IDao<Account, Integer> dao = JdbcAccountDao.getInstance();

    private List<Account> getAllAccounts() {
        return dao.getAll();
    }

    public boolean addAccount(Account account) {
        return dao.add(account);
    }

    public AuthenticationResult authenticate(String login, String password) {
        Account account = findAccount(login);
        PasswordAuthentication authentication = new PasswordAuthentication();

        if (account.getLogin() == null || account.getLogin().equals("")) {
            return AuthenticationResult.USER_DOES_NOT_EXIST;
        }

        if (!authentication.authenticate(password.toCharArray(), account.getHash())) {
            return AuthenticationResult.PASSWORD_CHECK_FAILED;
        }

        if (!account.isAvailable()) {
            return AuthenticationResult.ACCOUNT_DISABLED;
        }

        return AuthenticationResult.valueOf(account.getPermission().getName().toUpperCase());
    }

    public RegistrationResult registration(String login, String password,
                                           String password_repeat, String fullName) {
        if (login == null || login.length() < 5 || login.length() > 50) {
            return RegistrationResult.INCORRECT_LOGIN;
        }

        if (login.equals(findAccount(login).getLogin())) {
            return RegistrationResult.EXISTING_LOGIN;
        }

        if (password == null || password.length() < 6 || password.length() > 32) {
            return RegistrationResult.INCORRECT_PASSWORD;
        }

        if (!password.equals(password_repeat)) {
            return RegistrationResult.INCORRECT_REPEAT_PASSWORD;
        }

        if (fullName == null || fullName.length() < 5 || fullName.length() > 50) {
            return RegistrationResult.INCORRECT_FULLNAME;
        }

        Account account = new Account();
        PasswordAuthentication authentication = new PasswordAuthentication();
        account.setLogin(login);
        account.setHash(authentication.hash(password.toCharArray()));
        account.setFullName(fullName);
        addAccount(account);
        return RegistrationResult.OK;
    }

    private Account findAccount(String login) {
        List<Account> accounts = getAllAccounts();
        for (Account account : accounts) {
            if (account.getLogin().equals(login)) {
                return account;
            }
        }
        return new Account();
    }
}
