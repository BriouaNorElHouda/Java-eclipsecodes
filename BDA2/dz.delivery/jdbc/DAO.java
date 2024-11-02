package jdbc;

import java.sql.Connection;

public abstract class DAO<T> {
	protected Connection con = null;
	public DAO(Connection con){
	this.con = con;
	}
	public abstract boolean create(T obj);
	public abstract boolean delete(T obj);
	public abstract boolean update(T obj);
	public abstract T find(int id);
	}


