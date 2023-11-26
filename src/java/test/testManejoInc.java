package test;

import Conexiones.IncidenteDAO;
import domain.Incidente;
import java.text.ParseException;
import java.util.List;

public class testManejoInc {

    public static void main(String[] args) throws ParseException {
        IncidenteDAO incdao = new IncidenteDAO();

        //Seleccionando la clave mayor
        int num = incdao.sel_clave();
        System.out.println("Numero de la siguiente clave es: " + num);

        //Insertando un nuevo objeto de tipo Incidente
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
//        Incidente incnew=new Incidente(num,"INCPROOFDEV"+num,timestamp,timestamp);
//        incdao.insertar(incnew);

        //numero de clave
        int clave = incdao.clave();
        System.out.println("Numero de clave es: " + clave);

//        //Actualizar registro
        Incidente inc_mod = new Incidente(clave, "SMPROOF" + clave, "Este es un comentario de prueba", "Cerrado", timestamp);
        incdao.actualizar(inc_mod);

        //Eliminar  un registro
//        Incidente inc_del=new Incidente(1);
//        incdao.eliminar(inc_del);
        //Seleccionar un nuevo objeto de tipo incidente
        List<Incidente> incs = incdao.Seleccionar();
        for (Incidente inc : incs) {
            System.out.println("Incidente = " + inc);
        }
    }

}
