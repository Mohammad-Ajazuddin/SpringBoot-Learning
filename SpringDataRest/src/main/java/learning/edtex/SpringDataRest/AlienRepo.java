package learning.edtex.SpringDataRest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import learning.edtex.SpringDataRest.model.Alien;

//Now no controller is needed. THe base url aliens. Now spring takes care of crud ops
//localhost:8080/aliens will get all objs
//localhost:8080/aliens/123
@RepositoryRestResource(collectionResourceRel="aliens",path="aliens")
public interface AlienRepo extends JpaRepository<Alien,Integer>{

}
