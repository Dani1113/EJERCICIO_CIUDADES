package com.example.ejercicio_ciudades.Modelos;

public class ConfiguracionDB {
	public static final String HOSTDB = "10.0.2.2";
	public static final String NOMBREDB = "Ciudades2";
	public static final String USUARIODB = "root";
	public static final String CLAVEDB = "Legendario11";
	private static final String OPCIONES = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String PUERTOMYSQL = "3306";
	public static final String URLMYSQL = "jdbc:mysql://"+ HOSTDB + ":" + PUERTOMYSQL+"/" + NOMBREDB + OPCIONES;
}