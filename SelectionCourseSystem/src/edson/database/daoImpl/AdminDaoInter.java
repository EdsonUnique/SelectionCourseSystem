package edson.database.daoImpl;

import edson.bean.Admin;

public interface AdminDaoInter {

	Admin findAdmin(String username, String pwd);

}