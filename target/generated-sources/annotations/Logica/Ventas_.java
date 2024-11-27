package Logica;

import Logica.Almacenista;
import Logica.Gerente;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-4.0.4.v20240719-r059428cdd2583c46f1f3e50d235854840a6fa9a7", date="2024-11-27T01:16:28")
@StaticMetamodel(Ventas.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Ventas_ { 

    public static volatile SingularAttribute<Ventas, String> descripcion;
    public static volatile SingularAttribute<Ventas, Integer> cantidadVendida;
    public static volatile SingularAttribute<Ventas, String> precio;
    public static volatile SingularAttribute<Ventas, Gerente> salesGerente;
    public static volatile SingularAttribute<Ventas, String> materialProducto;
    public static volatile SingularAttribute<Ventas, Almacenista> salesAlmacenista;
    public static volatile SingularAttribute<Ventas, String> encargadoVenta;
    public static volatile SingularAttribute<Ventas, String> producto;
    public static volatile SingularAttribute<Ventas, Integer> cantidadRegistrada;
    public static volatile SingularAttribute<Ventas, Integer> idVenta;
    public static volatile SingularAttribute<Ventas, String> fechaVenta;

}