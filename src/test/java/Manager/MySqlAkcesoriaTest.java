package Manager;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class MySqlAkcesoriaTest {

	MySqlAkcesoria aMgr = new MySqlAkcesoria();
	Connection connection = aMgr.getConnection();
	ResultSet rs;
	boolean tableExists = false;
	
	@Test
	public void checkConnection()
	{
		assertNotNull("Problem z po³¹czeniem do DB. Sprawdz czy prawidlowo podales dane.", aMgr.getConnection());
	}
	
	@Test
	public void testCreateTable() {
		try {
			
			//sprawdzenie czy tabela istnieje. Jak tak to nalezy ja recznie usunac.
			rs = connection.getMetaData().getTables(null, null, null, null);
			tableExists = false;
			
			while(rs.next())
			{
				if (rs.getString("TABLE_NAME").equalsIgnoreCase("akcesoria"));
				{
					tableExists = true;
					break;
				}
			}
			assertEquals("Tabela juz istnieje. Usun ja", false, tableExists);
			
			aMgr.createTable();
			rs = connection.getMetaData().getTables(null, null, null, null);
			tableExists = false;
			
			while(rs.next())
			{
				if (rs.getString("TABLE_NAME").equalsIgnoreCase("akcesoria"));
				{
					tableExists = true;
					break;
				}
			}
			assertEquals("Problem z utworzeniem tabeli", true, tableExists);

			aMgr.dropTable();
			
			rs = connection.getMetaData().getTables(null, null, null, null);
			tableExists = false;
			while(rs.next())
			{
				if (rs.getString("TABLE_NAME").equalsIgnoreCase("akcesoria"));
				{
					tableExists = true;
					break;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsert() {
		
		try {
		rs = connection.getMetaData().getTables(null, null, null, null);
		tableExists = false;
		
		while(rs.next())
		{
			if (rs.getString("TABLE_NAME").equalsIgnoreCase("akcesoria"));
			{
				tableExists = true;
				break;
			}
		}
		assertEquals("Tabela juz istnieje. Usun ja", false, tableExists);
		
		aMgr.createTable();

		rs = connection.getMetaData().getTables(null, null, null, null);
		
		tableExists = false;
		
		while(rs.next())
		{
			if (rs.getString("TABLE_NAME").equalsIgnoreCase("akcesoria"));
			{
				tableExists = true;
				break;
			}
		}
		assertEquals("Problem z utworzeniem tabeli", true, tableExists);
		
		aMgr.insert();
		assertEquals("Blad przy dodawaniu rekordu.", 1, aMgr.select().getId());
		
		aMgr.dropTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDropTable() {
		
		try {
			
			rs = connection.getMetaData().getTables(null, null, null, null);
			tableExists = false;
			
			while(rs.next())
			{
				if (rs.getString("TABLE_NAME").equalsIgnoreCase("akcesoria"));
				{
					tableExists = true;
					break;
				}
			}
			
			if (tableExists = false ) aMgr.dropTable();
			
			rs = connection.getMetaData().getTables(null, null, null, null);
			tableExists = false;
			while(rs.next())
			{
				if (rs.getString("TABLE_NAME").equalsIgnoreCase("akcesoria"));
				{
					tableExists = true;
					break;
				}
			}
			assertEquals("Tabela nie zosta³a usuniêta!", false, tableExists);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelect() {
		fail("Not yet implemented");
	}
	
}
