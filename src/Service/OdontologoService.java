package Service;

import Dao.iDao;
import Dao.OdontologoDAOH2;
import Model.Odontologo;


import java.util.List;

public class OdontologoService {
    private iDao<Odontologo> odontologoDao;

    public OdontologoService(iDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public OdontologoService() {
        this.odontologoDao = new OdontologoDAOH2();
    }

    public void guardarOdontologo(Odontologo odontologo) {
        odontologoDao.guardar(odontologo);
    }

    public List<Odontologo> listarTodos() {
        return odontologoDao.listarTodos();
    }
}
