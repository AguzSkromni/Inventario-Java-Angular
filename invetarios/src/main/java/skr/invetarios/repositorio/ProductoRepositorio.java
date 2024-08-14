package skr.invetarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import skr.invetarios.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
