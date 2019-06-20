package cybsec.accenture.l11SpringBoot;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import cybsec.accenture.l11SpringBoot.model.Prodotto;

@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface ProdottoRepository extends PagingAndSortingRepository<Prodotto, Integer> {

}
