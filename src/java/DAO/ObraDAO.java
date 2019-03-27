package DAO;

import Bean.ObraBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObraDAO extends ConnectionFactory {

    public void inserir(ObraBean obra) {

        Connection conn = new ConnectionFactory().getConnection();
        String sql = "insert into masp (id, nome, data, tecnica, dimensoes, autor, procedencia, tipo)"
                + " values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, obra.getId());
            ps.setString(2, obra.getNome());
            ps.setString(3, obra.getData());
            ps.setString(4, obra.getTecnica());
            ps.setString(5, obra.getDimensoes());
            ps.setString(6, obra.getAutor());
            ps.setString(7, obra.getProcedencia());
            ps.setString(8, obra.getTipo());

            ps.executeUpdate();
            ps.close();
            System.out.println("GRAVADO");
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<ObraBean> getLista() {
        try {
            Connection conn = new ConnectionFactory().getConnection();
            List<ObraBean> obras = new ArrayList<ObraBean>();
            PreparedStatement stmt = conn.prepareStatement("select * from obras");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ObraBean obra = new ObraBean();
                obra.setId(rs.getString("id"));
                obra.setNome(rs.getString("nome"));
                obra.setData(rs.getString("data"));
                obra.setTecnica(rs.getString("tecnica"));
                obra.setDimensoes(rs.getString("dimensoes"));
                obra.setAutor(rs.getString("autor"));
                obra.setProcedencia(rs.getString("procedencia"));
                obra.setTipo(rs.getString("tipo"));
                
                obras.add(obra);
            }
            rs.close();
            stmt.close();
            return obras;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
