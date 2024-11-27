package Logica;

import Logica.Almacenista;
import Logica.Gerente;
import Logica.Producto;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@Generated(value="EclipseLink-4.0.4.v20240719-r059428cdd2583c46f1f3e50d235854840a6fa9a7", date="2024-11-27T01:16:28")
@StaticMetamodel(InventarioProducto.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class InventarioProducto_ { 

    public static volatile SingularAttribute<InventarioProducto, Date> fecha;
    public static volatile ListAttribute<InventarioProducto, Producto> listaproducto;
    public static volatile SingularAttribute<InventarioProducto, Gerente> registroProductoGerente;
    public static volatile SingularAttribute<InventarioProducto, Integer> idProducto;
    public static volatile SingularAttribute<InventarioProducto, Almacenista> registroproductoAlmacenista;

}