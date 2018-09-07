package com.campusnumerique.vehiclerental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.campusnumerique.vehiclerental.entity.Client;

public class ConnexionDAO extends DAO<Client> {

	@Override
	public boolean create(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Client> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client find(int id) throws SQLException {
		Client client = new Client();

		ResultSet result = this.connection
				.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
				.executeQuery("SELECT * FROM client WHERE id = " + id);
		if (result.first())
			client = new Client(id, result.getString("login"), result.getString("firstName"),
					result.getString("lastName"), result.getString("mail"), result.getString("password"),
					result.getDate("birthDate"), result.getString("numPermis"), result.getDate("datePermis"), result.getBoolean("agent"));
		return null;
	}

	public Client checkUserAuth(String password, String login) throws SQLException {
		Client connectClient = new Client();
		ResultSet result = this.connection.createStatement()
				.executeQuery("SELECT * FROM client WHERE login = '" + login + "' AND password = '" + password + "'");
		if (result.first())
			connectClient = new Client(result.getInt("id"), result.getString("login"), result.getString("firstName"),
					result.getString("lastName"), result.getString("mail"), result.getString("password"),
					result.getDate("birthDate"), result.getString("numPermis"), result.getDate("datePermis"), result.getBoolean("agent"));

		return connectClient;
	}
	public Client checkAgent(String agent)throws SQLException{
		Client agentClient = new Client();
		ResultSet result = this.connection.createStatement()
		.executeQuery("SELECT * FROM client WHERE agent = " + agent );
		
		if (result.first())
			agentClient = new Client(result.getInt("id"), result.getString("login"), result.getString("firstName"),
					result.getString("lastName"), result.getString("mail"), result.getString("password"),
					result.getDate("birthDate"), result.getString("numPermis"), result.getDate("datePermis"), result.getBoolean("agent"));

		return agentClient;
		
	}

}
