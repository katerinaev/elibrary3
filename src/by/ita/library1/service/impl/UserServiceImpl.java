package by.ita.library1.service.impl;

import by.ita.library1.bean.Role;
import by.ita.library1.bean.User;
import by.ita.library1.dao.DAOFactory;
import by.ita.library1.dao.UserDao;
import by.ita.library1.dao.exception.DAOException;
import by.ita.library1.service.UserService;
import by.ita.library1.service.exception.ServiceException;

public class UserServiceImpl implements UserService{

	@Override
	public User logination(String login, String password) throws ServiceException {
		User loggedUser;
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDao userDAO = daoFactory.getUserDAO();
		
		try {
			loggedUser = userDAO.logination(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return loggedUser;
	}

	@Override
	public User registerUser(String login, String password) throws ServiceException {
		User signedUser;
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDao userDAO = daoFactory.getUserDAO();
		
		try {
			signedUser = userDAO.registerUser(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return signedUser;
	}

	@Override
	public boolean changeUserRole(String login, Role newRole) throws ServiceException {
		boolean success;
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDao userDAO = daoFactory.getUserDAO();
		
		try {
			success = userDAO.changeUserRole(login, newRole);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return success;
	}

}
