package Logica;

import Logica.InventarioProducto;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-4.0.4.v20240719-r059428cdd2583c46f1f3e50d235854840a6fa9a7", date="2024-11-27T01:16:28")
@StaticMetamodel(Producto.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, InventarioProducto> product;
    public static volatile SingularAttribute<Producto, String> materialProducto;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile SingularAttribute<Producto, Integer> cantidadRegistrada;
    public static volatile SingularAttribute<Producto, String> nombre;

}