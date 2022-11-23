package br.univille.projetosistemapetshop.service;
import java.util.List;
import br.univille.projetosistemapetshop.entity.Veterinario;

public interface VeterinarioService {
    List<Veterinario> getAll();
    Veterinario save(Veterinario veterinario);
    Veterinario findById(long id);
    void delete(long id);
    List<Veterinario> findByNome(String nome);
}
