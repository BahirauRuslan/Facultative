package by.bntu.fitr.povt.bahirauruslan.facultative.models.services.guest;

import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.IDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.dao.JdbcPermissionDao;
import by.bntu.fitr.povt.bahirauruslan.facultative.models.entities.Permission;

import java.util.List;

public class PermissionService {
    private IDao<Permission, Integer> dao = JdbcPermissionDao.getInstance();

    public List<Permission> getAll() {
        return dao.getAll();
    }

    public Permission getByName(String name) {
        List<Permission> permissions = getAll();
        for (Permission permission : permissions) {
            if (permission.getName().equals(name)) {
                return permission;
            }
        }
        return new Permission();
    }
}
