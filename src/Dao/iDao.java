package Dao;

import Model.Odontologo;
import java.util.List;

public interface iDao<Odontologo> {
    void guardar(Odontologo odontologo);
    List<Odontologo> listarTodos();
}

