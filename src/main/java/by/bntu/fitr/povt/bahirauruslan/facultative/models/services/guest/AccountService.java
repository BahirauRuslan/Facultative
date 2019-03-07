package by.bntu.fitr.povt.bahirauruslan.facultative.models.services.guest;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.IDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.JdbcAccountDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Account;

import java.util.List;

public class AccountService {
    private IDao<Account, Integer> dao = JdbcAccountDao.getInstance();

    private List<Account> getAllAccounts() {
        return dao.getAll();
    }

    public boolean addAccount(Account account) {
        return dao.add(account);
    }
}
