package Logica;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-4.0.4.v20240719-r059428cdd2583c46f1f3e50d235854840a6fa9a7", date="2024-11-27T01:16:28")
@StaticMetamodel(Usuario.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> nombreUsuario;
    public static volatile SingularAttribute<Usuario, String> rol;
    public static volatile SingularAttribute<Usuario, String> contraseña;

}