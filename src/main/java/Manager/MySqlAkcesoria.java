package Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Akcesoria.Akcesoria;

public class MySqlAkcesoria implements IManager<Akcesoria> {

	Connection connection;
	Connect connect;
	
	PreparedStatement createTable;
	PreparedStatement dropTable;
	PreparedStatement delete;
	PreparedStatement insert;
	PreparedStatement update;
	PreparedStatement select;
	
	// Sekcja zapytañ
	String sCreate = "CREATE TABLE akcesoria (id int auto_increment primary key, nazwa varchar(255), opis varchar(255), cena decimal (10.2))";
	String sDrop = "";
	String sDelete = "";
	String sInsert = "";
	String sUpdate = "";
	String sSelect = "";
	
	public MySqlAkcesoria ()
	{
		connect = new Connect();
		
		try {
			connection=DriverManager.getConnection(connect.getUrl(), connect.getUser(), connect.getPassword());
			
			createTable = connection.prepareStatement(sCreate);
			dropTable = connection.prepareStatement(sDrop);
			delete = connection.prepareStatement(sDelete);
			insert = connection.prepareStatement(sInsert);
			update = connection.prepareStatement(sUpdate);
			select = connection.prepareStatement(sSelect);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	public void dropTable() {
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public void insert() {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void select() {
		// TODO Auto-generated method stub
		
	}

}
