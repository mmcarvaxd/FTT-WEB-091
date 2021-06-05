package ec.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ec.ftt.model.Pacient;
import ec.ftt.model.User;
import ec.ftt.util.DBUtil;

public class PacientDao {

	private Connection connection;

	public PacientDao() {
		connection = DBUtil.getConnection();
	}

	public void addPacient(Pacient pacient) {

		try {

			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO ftt.pacient (NAME, AGE, WEIGHT, HEIGHT, CEP, ADDRESS, CITY, STATE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

			// Parameters start with 1
			preparedStatement.setString(1, pacient.getName());
			preparedStatement.setInt(2, pacient.getAge());
			preparedStatement.setInt(3, pacient.getWeight());
			preparedStatement.setInt(4, pacient.getHeight());
			preparedStatement.setString(5, pacient.getCep());
			preparedStatement.setString(6, pacient.getAddress());
			preparedStatement.setString(7, pacient.getCity());
			preparedStatement.setString(8, pacient.getState());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Pacient> getAllPacient() {

		List<Pacient> pacientList = new ArrayList<Pacient>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM ftt.PACIENT");
			while (rs.next()) {

				Pacient pacient = new Pacient();

				pacient.setId(rs.getInt("ID"));
				pacient.setName(rs.getString("NAME"));
				pacient.setAge(rs.getInt("AGE"));
				pacient.setWeight(rs.getInt("WEIGHT"));
				pacient.setHeight(rs.getInt("HEIGHT"));
				pacient.setCep(rs.getString("CEP"));
				pacient.setAddress(rs.getString("ADDRESS"));
				pacient.setCity(rs.getString("CITY"));
				pacient.setState(rs.getString("STATE"));

				pacientList.add(pacient);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pacientList;
	}

	public Pacient getPacientById(int id) {

		Pacient pacient = new Pacient();
		pacient.setId(id);

		return getPacientById(pacient);

	} // getPacientById long

	public Pacient getPacientById(Pacient user) {

		Pacient userOutput = new Pacient();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from ftt.Pacient WHERE ID=?");

			preparedStatement.setInt(1, user.getId());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				userOutput.setId(rs.getInt("ID"));
				userOutput.setName(rs.getString("NAME"));
				userOutput.setAge(rs.getInt("AGE"));
				userOutput.setWeight(rs.getInt("WEIGHT"));
				userOutput.setHeight(rs.getInt("HEIGHT"));
				userOutput.setCep(rs.getString("CEP"));
				userOutput.setAddress(rs.getString("ADDRESS"));
				userOutput.setCity(rs.getString("CITY"));
				userOutput.setState(rs.getString("STATE"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userOutput;
	} // getUserById

	public void deletePacient(int id) {

		Pacient p = new Pacient();
		p.setId(id);

		deletePacient(p);

	} // deleteUser long

	public void deletePacient(Pacient p) {
		try {

			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ftt.Pacient WHERE ID=?");

			/*
			 * 
			 * DELETE FROM `ftt`.`USER` WHERE <{where_expression}>;
			 * 
			 * 
			 */

			// Parameters start with 1
			preparedStatement.setInt(1, p.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // deleteUser
	
    public void updatePacient(Pacient pacient) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE ftt.pacient SET NAME=?, " 
                    		                          + "AGE=?, " 
                    		                          + "Weight=? " 
                    		                          + "HEIGHT=? " 
                    		                          + "CEP=? " 
                    		                          + "ADDRESS=? " 
                    		                          + "CITY=? " 
                    		                          + "STATE=? " 
                                               + "WHERE ID=?");
            
            /*
             * 
             * UPDATE `ftt`.`USER`
				SET
					`ID` = <{ID: }>,
					`NAME` = <{NAME: }>,
					`EMAIL` = <{EMAIL: }>,
					`COLOR` = <{COLOR: }>
					WHERE `ID` = <{expr}>;

             * 
             */
            
            // Parameters start with 1
            preparedStatement.setString(1, pacient.getName());
            preparedStatement.setInt(2, pacient.getAge());
            //preparedStatement.setDate(3, (java.sql.Date)user.getDob());
            preparedStatement.setInt(3, pacient.getWeight());
            preparedStatement.setInt(4, pacient.getHeight());
			preparedStatement.setString(5, pacient.getCep());
			preparedStatement.setString(6, pacient.getAddress());
			preparedStatement.setString(7, pacient.getCity());
			preparedStatement.setString(8, pacient.getState());

            preparedStatement.setInt(9, pacient.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //updateUser
}
