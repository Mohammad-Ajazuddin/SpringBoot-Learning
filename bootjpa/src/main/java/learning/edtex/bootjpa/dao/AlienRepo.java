package learning.edtex.bootjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import learning.edtex.bootjpa.model.Alien;


//DAO data access obj. We generally create separate interfaces to keep bus logic separate with data access logic
//public interface AlienRepo extends CrudRepository<Alien,Integer>{
//here not writing any method names bcz CrudRepository has many meths provided by spring jpa
/*
	List<Alien> findByLang(String lang);
	//here we need not implement this method somewhere. spring takes care of this
	//CrudRepo already has findById meth, so the convention is
	//our own methods should start with findBy
	//immediate to it should have property we have "lang" in alien so findByLang
	
	List<Alien> findByAidGreaterThan(int aid);
	//aid prop, GreaterThan keyword. Returns all aliens with ids>specified.
	
	//Writing our own query.
	//findByLangSorted. there is no sorted keyword. with specific lang we should return names according to names in asc ord
	
	@Query("from Alien where lang=?1 order by aname")
	List<Alien> findByLangSorted(String lang);
	//select * we dont write here. it is a part of boiler plate. Actually it is jpql
	//lang=? bcz it will be entered by user ?1 bcz there can be multiple fields so numbering
	 * 
	 * */
//}

//JpaRepository extends pagingAndSortingRepository->CrudRepo
//so extra features. findAll() List<> unlike CrudRepo - an iterable
//And the objects are in the form of json objects
public interface AlienRepo extends JpaRepository<Alien,Integer>{
	
}
