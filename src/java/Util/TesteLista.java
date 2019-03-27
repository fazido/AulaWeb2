package Util;

import Bean.ObraBean;
import DAO.ObraDAO;
import java.util.List;

public class TesteLista {

    public static void main(String[] args) {
        
        ObraDAO dao = new ObraDAO();
        List<ObraBean> obras = dao.getLista();
    
        for (ObraBean obra : obras) {
            System.out.println("Id: " + obra.getId());
            System.out.println("Nome: " + obra.getNome());
            System.out.println("Data: " + obra.getData());
            System.out.println("Tecnica: " + obra.getTecnica());
            System.out.println("Dimensoes: " + obra.getDimensoes());
            System.out.println("Autor: " + obra.getAutor());
            System.out.println("Procedencia: " + obra.getProcedencia());
            System.out.println("Tipo: " + obra.getTipo());
        }
        
    }
}
