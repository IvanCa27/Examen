package Dao;

import java.util.ArrayList;
import java.util.List;

import Model.Odontologo;

public class OdontologoDAOList implements iDao<Odontologo> {

        private List<Odontologo> odontologos = new ArrayList<>();

        @Override
        public void guardar(Odontologo odontologo) {
            this.odontologos.add(odontologo);
        }

        @Override
        public List<Odontologo> listarTodos() {
            return new ArrayList<>(odontologos);
        }
    }
