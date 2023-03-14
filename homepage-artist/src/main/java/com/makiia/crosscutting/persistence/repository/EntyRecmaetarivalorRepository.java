package com.makiia.crosscutting.persistence.repository;
import com.makiia.crosscutting.persistence.entity.EntyRecmaetarivalor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface EntyRecmaetarivalorRepository extends JpaRepository<EntyRecmaetarivalor,String>
{
        Optional<EntyRecmaetarivalor> findById(String id);

}
