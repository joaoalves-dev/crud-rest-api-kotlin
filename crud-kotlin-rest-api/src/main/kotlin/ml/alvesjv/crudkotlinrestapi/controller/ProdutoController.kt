package ml.alvesjv.crudkotlinrestapi.controller

import jakarta.validation.Valid
import ml.alvesjv.crudkotlinrestapi.model.Produto
import ml.alvesjv.crudkotlinrestapi.repositories.ProdutoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.Optional


@RestController
@RequestMapping("/api/produtos")
class ProdutoController {

    @Autowired
    private val produtoRepository: ProdutoRepository? = null


    //CREATE
    @PostMapping
    fun criar(@RequestBody @Valid produto: Produto): Produto {
        produtoRepository!!.save(produto)
        return produto;
    }

    //UPDATE
    @PutMapping("/{id}")
    fun uptade(@PathVariable id: Int, @RequestBody @Valid produto: Produto){
        val prod = produtoRepository!!.findById(id)
        produtoRepository.save(prod.get())
    }

    //READ
    @GetMapping
    fun obterProduto(): Iterable<Produto> = produtoRepository!!.findAll()

    //READ BY IDs
    @GetMapping("/{id}")
    fun obterProdutoPorId(@PathVariable id: Int): Optional<Produto> = produtoRepository!!.findById(id)

    //DELETE
    @DeleteMapping("/{id}")
    fun excluirProduto(@PathVariable id: Int) = produtoRepository!!.deleteById(id)

}