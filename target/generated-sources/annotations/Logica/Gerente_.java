package Logica;

import Logica.Usuario;
import Logica.Ventas;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-4.0.4.v20240719-r059428cdd2583c46f1f3e50d235854840a6fa9a7", date="2024-11-27T01:16:28")
@StaticMetamodel(Gerente.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Gerente_ extends Persona_ {

    public static volatile SingularAttribute<Gerente, Usuario> unUsuario;
    public static volatile ListAttribute<Gerente, Ventas> listaventasGerente;

}