package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Agenda;

public class AgendaDao implements IAgendaDao {

	private GenericDao gDao;

	public AgendaDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public Agenda consultaAgenda(Agenda a) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT id, nome, email, "
				+ "'('+SUBSTRING(telefone,1,2)+')'+SUBSTRING(telefone,3,5)+'-'+SUBSTRING(telefone,8,4) AS telefone,"
				+ "tipo FROM v_agenda "
				+ "WHERE id = ? ORDER BY telefone";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, a.getId());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			a.setEmail(rs.getString("email"));
			a.setTelefone(rs.getString("telefone"));
			a.setTipo(rs.getString("tipo"));
		}
		rs.close();
		ps.close();
		c.close();
		
		return a;
	}

	@Override
	public List<Agenda> consultaAgendas() throws SQLException, ClassNotFoundException {
		List<Agenda> agendas = new ArrayList<Agenda>();
		Connection c = gDao.getConnection();
		String sql = "SELECT id, nome, email, "
				+ "'('+SUBSTRING(telefone,1,2)+')'+SUBSTRING(telefone,3,5)+'-'+SUBSTRING(telefone,8,4) AS telefone,"
				+ "tipo FROM v_agenda "
				+ "ORDER BY telefone";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Agenda a = new Agenda();
			a.setId(rs.getInt("id"));
			a.setNome(rs.getString("nome"));
			a.setEmail(rs.getString("email"));
			a.setTelefone(rs.getString("telefone"));
			a.setTipo(rs.getString("tipo"));
			
			agendas.add(a);
		}
		rs.close();
		ps.close();
		c.close();
		
		return agendas;
	}

}
