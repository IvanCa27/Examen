import Model.Odontologo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Service.OdontologoService;
import Dao.BD;

import java.util.List;

public class OdontologoServiceH2Test {

    private OdontologoService odontologoService;

    @Before
    public void setUp() {
        BD.crearTablas();
        odontologoService = new OdontologoService();
    }

    @Test
    public void testGuardarYListarOdontologos() {
        Odontologo odontologo1 = new Odontologo(1234, "3445566","Juan", "Pérez");
        Odontologo odontologo2 = new Odontologo(5678, "1234456","María", "Gómez");

        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);

        List<Odontologo> odontologos = odontologoService.listarTodos();

        Assert.assertNotNull(odontologos);
        Assert.assertEquals(2, odontologos.size());
        Assert.assertTrue(odontologos.contains(odontologo1));
        Assert.assertTrue(odontologos.contains(odontologo2));
    }
}
