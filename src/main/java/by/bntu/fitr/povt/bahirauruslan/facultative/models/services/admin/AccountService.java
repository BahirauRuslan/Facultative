package by.bntu.fitr.povt.bahirauruslan.facultative.models.services.admin;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.IDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.JdbcAccountDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Account;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Permission;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.services.guest.PermissionService;

import java.util.List;
import java.util.ArrayList;

public class AccountService {
    private IDao<Account, Integer> dao = JdbcAccountDao.getInstance();

    public List<Account> getAllAccounts() {
        List<Account> accounts = dao.getAll();
        List<Account> filterAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (!account.getPermission().getName().equals("Admin")) {
                filterAccounts.add(account);
            }
        }
        return filterAccounts;
    }

    public List<Account> getAllTeachers() {
        List<Account> accounts = dao.getAll();
        List<Account> filterAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getPermission().getName().equals("Teacher")) {
                filterAccounts.add(account);
            }
        }
        return filterAccounts;
    }

    public Account getAccount(int id) {
        return dao.get(id);
    }

    public Account findTeacher(String login) {
        List<Account> accounts = getAllAccounts();
        for (Account account : accounts) {
            if (account.getLogin().equals(login) && account.getPermission().getName().equals("Teacher")) {
                return account;
            }
        }
        return new Account();
    }

    public void updateAccount(Account account, boolean isAvailable, String permission) {
        Permission per = new PermissionService().getByName(permission);
        if (per.getName().equals(permission) && !permission.equals("Admin")) {
            account.setAvailable(isAvailable);
            account.setPermission(per);
            dao.update(account);
        }
    }

    public void deleteAccount(Account account) {
        dao.delete(account);
    }
}
