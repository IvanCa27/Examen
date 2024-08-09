import org.junit.Before;
import org.junit.Test;

import Dao.OdontologoDAOList;
import Model.Odontologo;
import Service.OdontologoService;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class OdontologoServiceListTest {
    private OdontologoService odontologoService;

    @Before
    public void setUp() {
        // Usando la implementación en memoria para pruebas rápidas
        odontologoService = new OdontologoService(new OdontologoDAOList());
    }

    @Test
    public void testGuardarYListarOdontologo() {
        Odontologo odontologo = new Odontologo(1234, "3445566", "Juan", "Pérez");
        odontologoService.guardarOdontologo(odontologo);

        List<Odontologo> odontologos = odontologoService.listarTodos();
        assertTrue(odontologos.contains(odontologo));
    }
}
