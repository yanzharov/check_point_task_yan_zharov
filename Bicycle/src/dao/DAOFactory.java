package dao;

import dao.impl.FileNBDAO;

public class DAOFactory {
	private static final DAOFactory INSTANCE = new DAOFactory();
		
	private NBDao nbDao = new FileNBDAO();
	
	private DAOFactory(){}
	
	public static DAOFactory getInstance(){
		return INSTANCE;
	}
	
	public NBDao getNBDao(){
		return nbDao;
	}

}
