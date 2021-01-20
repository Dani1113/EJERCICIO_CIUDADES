package com.example.ejercicio_ciudades.Modelos;

import android.util.Log;

import com.example.ejercicio_ciudades.Clases.Provincia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProvinciaDB {

	public static boolean insertarProvinciaTabla(Provincia p)
	{
		Connection conexión = BaseDB.conectarConBaseDeDatos();
		if(conexión == null) {
			return false;
		}
		try {
			String ordenSQL = "INSERT INTO provincias (nombre) VALUES (?);";
			PreparedStatement sentenciaPreparada = conexión.prepareStatement(ordenSQL);
			sentenciaPreparada.setString(1, p.getNombre());
			int filasAfectadas = sentenciaPreparada.executeUpdate();
			sentenciaPreparada.close();
			conexión.close();
			if(filasAfectadas > 0) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	public static ArrayList<Provincia> obtenerProvincias() {
		Connection conexión = BaseDB.conectarConBaseDeDatos();
		if(conexión == null)
		{
			return null;
		}
		ArrayList<Provincia> provinciasDevueltas = new ArrayList<Provincia>();
		try {
			Statement sentencia = conexión.createStatement();
			String ordenSQL = "select * from provincias";
			ResultSet resultado = sentencia.executeQuery(ordenSQL);
			while(resultado.next()) {
				int idprovincia = resultado.getInt("idprovincia");
				String nombre = resultado.getString("nombre");
				Provincia p = new Provincia(idprovincia, nombre);
				provinciasDevueltas.add(p);
			}
			resultado.close();
			sentencia.close();
			conexión.close();
			return provinciasDevueltas;
		} catch (SQLException e) {
			Log.i("sql", "error sql");
			return provinciasDevueltas;
		}
	}

	public static Provincia buscarProvinciaTabla(String nombre)
	{
		Connection conexion = BaseDB.conectarConBaseDeDatos();
		if(conexion == null)
		{
			return null;
		}
		//---------------------------------
		Provincia provinciaEncontrada = null;
		try {
			ResultSet resultadosql = BaseDB.buscarFilasEnTabla(conexion, "provincias", "nombre", nombre);
			if(resultadosql == null)
			{
				return null;
			}
			while(resultadosql.next())
			{
				int idprovincia = resultadosql.getInt("idprovincia");
				String nombreprovincia = resultadosql.getString("nombre");
				provinciaEncontrada = new Provincia(idprovincia,nombreprovincia);
			}
			resultadosql.close();
			conexion.close();
			return provinciaEncontrada;
		} catch (SQLException e) {
          return null;
		}
	}

    public static boolean borrarProvincia(Provincia p) {
		Connection conexión = BaseDB.conectarConBaseDeDatos();
		if(conexión == null) {
			return false;
		}
		try {
			String OrdenSQL = "DELETE FROM provincias WHERE nombre LIKE ?;";
			PreparedStatement sentenciaPreparada = conexión.prepareStatement(OrdenSQL);
			sentenciaPreparada.setString(1, p.getNombre());
			int filasAfectadas = sentenciaPreparada.executeUpdate();
			sentenciaPreparada.close();
			conexión.close();
			if(filasAfectadas > 0)
			{
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
    }

    public static boolean actualizarProvinciaTabla(Provincia p) {
		Connection conexion = BaseDB.conectarConBaseDeDatos();
		if(conexion == null) {
			return false;
		}
		try {
			String ordensql = "UPDATE provincias SET nombre = ? WHERE idprovincia = ?";
			PreparedStatement pst = conexion.prepareStatement(ordensql);
			pst.setString(1, p.getNombre());
			pst.setInt(2, p.getIdprovincia());
			int filasAfectadas = pst.executeUpdate();
			pst.close();
			conexion.close();
			if(filasAfectadas > 0)
			{
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
    }
}