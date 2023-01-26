package ml.alvesjv.crudkotlinrestapi.repositories;

import ml.alvesjv.crudkotlinrestapi.model.Produto;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
