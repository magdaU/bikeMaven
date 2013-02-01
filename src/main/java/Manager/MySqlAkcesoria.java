package Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	String sDrop = "DROP TABLE akcesoria";
	String sDelete = "DELETE FROM akcesoria";
	String sInsert = "INSERT INTO akcesoria values (NULL, 'pompka', 'Pompka do roweru', 10)";
	String sUpdate = "UPDATE akcesoria SET nazwa = ?)";
	String sSelect = "SELECT * FROM akcesoria";
	
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
	
	public Connection getConnection()
	{
		return connection;
	}
	
	public void createTable() {
		try {
			createTable.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void dropTable() {
		try {
			dropTable.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void delete() {
		try {
			delete.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void insert() {
		try {
			insert.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void update(String zmienna) {
		try {
			update.setString(1, zmienna);
			update.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Akcesoria select() {
		Akcesoria result = null;
		try {
			ResultSet rs = select.executeQuery();
			while(rs.next())
			{
				result = new Akcesoria(rs.getInt("id"),
						rs.getString("nazwa"),
						rs.getString("opis"),
						rs.getDouble("cena"));
			}
			
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
