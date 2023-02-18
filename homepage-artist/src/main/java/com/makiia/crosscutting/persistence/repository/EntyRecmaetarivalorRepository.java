package com.makiia.crosscutting.persistence.repository;
import com.makiia.crosscutting.persistence.entity.EntyRecmaetarivalor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface EntyRecmaetarivalorRepository extends CrudRepository<EntyRecmaetarivalor,String>
{
        Optional<EntyRecmaetarivalor> findById(String id);

}
