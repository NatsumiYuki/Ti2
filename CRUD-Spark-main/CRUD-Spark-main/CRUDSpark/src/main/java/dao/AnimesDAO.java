package dao;

import model.Animes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimesDAO {

    private Connection connection;

    public AnimesDAO() {
        try {
            connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/CRUD Form Locadora Animes", "postgres", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Animes anime) {
        String sql = "INSERT INTO \"Animes\" (\"Nome\", \"Gênero\", \"Autor\", \"Ano\") VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, anime.getNome());
            stmt.setString(2, anime.getGenero());
            stmt.setString(3, anime.getAutor());
            stmt.setInt(4, anime.getAno());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Animes get(int id) {
        Animes anime = null;
        String sql = "SELECT * FROM \"Animes\" WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                anime = new Animes(rs.getInt("id"), rs.getString("Nome"), rs.getString("Gênero"), rs.getString("Autor"), rs.getInt("Ano"));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return anime;
    }

    public void update(Animes anime) {
        String sql = "UPDATE \"Animes\" SET \"Nome\" = ?, \"Gênero\" = ?, \"Autor\" = ?, \"Ano\" = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, anime.getNome());
            stmt.setString(2, anime.getGenero());
            stmt.setString(3, anime.getAutor());
            stmt.setInt(4, anime.getAno());
            stmt.setInt(5, anime.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM \"Animes\" WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Animes> getAll() {
        List<Animes> animes = new ArrayList<>();
        String sql = "SELECT * FROM \"Animes\" ORDER BY id ASC";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Animes anime = new Animes(rs.getInt("id"), rs.getString("Nome"), rs.getString("Gênero"), rs.getString("Autor"), rs.getInt("Ano"));
                animes.add(anime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animes;
    }
}
