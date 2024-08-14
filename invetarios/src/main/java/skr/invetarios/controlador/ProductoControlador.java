package skr.invetarios.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skr.invetarios.excepcion.RecursoNoEncontradoExcepcion;
import skr.invetarios.modelo.Producto;
import skr.invetarios.servicio.ProductoServicio;

import java.util.List;

@RestController
@RequestMapping("/inventario-app")
//reequerir desde app exteerna
@CrossOrigin(value = "http://localhost:4200")
public class ProductoControlador {

    //Mandar informacion a consola
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    ///inventario-app/productos
    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        List<Producto> productos = productoServicio.listarProductos();
        logger.info("Productos Obtenidos:");
        productos.forEach(producto -> {
            logger.info(productos.toString());
        });
        return productos;
    }

    //inventario app/
    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        logger.info("Producto a agregar: " + producto);
        return this.productoServicio.guardarProducto(producto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(
            @PathVariable int id){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if(producto != null){
            return ResponseEntity.ok(producto);
        }else{
            throw new RecursoNoEncontradoExcepcion("No se encontro ID " + id);
        }

    }
}
