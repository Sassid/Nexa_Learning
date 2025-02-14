package fr.doranco.gestionFilm.sd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.gestionFilm.sd.business.Image;
import fr.doranco.gestionFilm.sd.dao.ConnexionBdd;
import fr.doranco.gestionFilm.sd.dao.ImageDao;
import fr.doranco.gestionFilm.sd.dao.Requete;

	public class ImageDaoImpl implements ImageDao {

	    private Connection connection;

	    public ImageDaoImpl() {
	        try {
	            connection = ConnexionBdd.getConnection();
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Image ajouterImage(Image image) throws SQLException {
	        PreparedStatement ps = connection.prepareStatement(Requete.AJOUT_IMAGE, Statement.RETURN_GENERATED_KEYS);
	        
	        ps.setLong(1, image.getIdImage());
	        ps.setString(2, image.getUrl());
	        ps.setNull(3, java.sql.Types.BIGINT); // Remplacez null par un ID de film si nÃ©cessaire
	        
	        ps.executeUpdate();
	        
	        ResultSet rs = ps.getGeneratedKeys();
	        if (rs.next()) {
	            image.setIdImage(rs.getLong(1));
	        }
	        
	        return image;
	    }

	    @Override
	    public Image modifierImage(Image image) throws SQLException {
	        PreparedStatement ps = connection.prepareStatement(Requete.UPDATE_IMAGE);
	        
	        ps.setString(1, image.getUrl());
	        ps.setLong(2, image.getIdImage());
	        
	        ps.executeUpdate();
	        
	        return image;
	    }

	    @Override
	    public boolean supprimerImage(Long id) throws SQLException {
	        PreparedStatement ps = connection.prepareStatement(Requete.SUPPRESSION_IMAGE);
	        
	        ps.setLong(1, id);
	        
	        return ps.execute();
	    }

	    @Override
	    public List<Image> findAllImages() throws SQLException {
	        PreparedStatement ps = connection.prepareStatement(Requete.TOUTES_LES_IMAGES);
	        
	        List<Image> images = new ArrayList<>();
	        
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Image image = new Image();
	            
	            image.setIdImage(rs.getLong("Id_Image"));
	            image.setUrl(rs.getString("nom"));
	            
	            images.add(image);
	        }
	        
	        return images;
	    }
	}
