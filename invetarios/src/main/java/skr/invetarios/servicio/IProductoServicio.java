package skr.invetarios.servicio;


import skr.invetarios.modelo.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoServicio {

    public List<Producto> listarProductos();

    public Producto buscarProductoPorId(Integer idProducto);

    public Producto guardarProducto(Producto producto);

    public void eliminarProducto(Integer idProducto);
}
