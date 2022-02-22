package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Agenda;

public interface IAgendaDao {

	public Agenda consultaAgenda(Agenda a) throws SQLException, ClassNotFoundException;
	public List<Agenda> consultaAgendas()  throws SQLException, ClassNotFoundException;
	
}
