package com.makiia.modules.prices.dataproviders.jpa;
import com.makiia.crosscutting.domain.model.EntyRecmaetarivalorDto;
import com.makiia.crosscutting.exceptions.DataProvider;
import com.makiia.crosscutting.exceptions.ExceptionBuilder;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.messages.SearchMessages;
import com.makiia.crosscutting.patterns.Translator;
import com.makiia.crosscutting.persistence.entity.EntyRecmaetarivalor;
import com.makiia.crosscutting.persistence.repository.EntyRecmaetarivalorRepository;
import com.makiia.modules.prices.dataproviders.IjpaEntyRecmaetarivalorDataProviders;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Log4j2
@DataProvider
public class JpaEntyRecmaetarivalorDataProviders implements IjpaEntyRecmaetarivalorDataProviders {
    @Autowired
    private EntyRecmaetarivalorRepository repository;
    @Autowired
    @Qualifier("entyRecmaetarivalorSaveResponseTranslate")
    private Translator<EntyRecmaetarivalor, EntyRecmaetarivalorDto> saveResponseTranslate;
    @Autowired
    @Qualifier("entyRecmaetarivalorDtoToEntityTranslate")
    private Translator<EntyRecmaetarivalorDto, EntyRecmaetarivalor> dtoToEntityTranslate;
    @Override
    public List<EntyRecmaetarivalorDto> getAll() throws EBusinessException {
        List<EntyRecmaetarivalorDto> dtos = new ArrayList<>();

        try {
            List<EntyRecmaetarivalor> responses = (List<EntyRecmaetarivalor>) repository.findAll();

            if (!responses.isEmpty()) {
                for (EntyRecmaetarivalor response : responses) {
                    dtos.add(saveResponseTranslate.translate(response));
                }
            }

            return dtos;
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.SEARCH_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.SEARCH_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public EntyRecmaetarivalorDto get(String id) throws EBusinessException {
        try {
            return saveResponseTranslate.translate(repository.findById(id).get());
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.SEARCH_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.SEARCH_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public EntyRecmaetarivalorDto save(EntyRecmaetarivalorDto dto) throws EBusinessException {
        try {
            return saveResponseTranslate.translate(repository.save(dtoToEntityTranslate.translate(dto)));
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.CREATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.CREATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public List<EntyRecmaetarivalorDto> save(List<EntyRecmaetarivalorDto> dtos) throws EBusinessException {
        try {
            List<EntyRecmaetarivalor> entities = new ArrayList<>();

            for (EntyRecmaetarivalorDto dto : dtos) {
                entities.add(dtoToEntityTranslate.translate(dto));
            }
            dtos = new ArrayList<>();
            for (EntyRecmaetarivalor entity : repository.saveAll(entities)) {
                dtos.add(saveResponseTranslate.translate(entity));
            }
            return dtos;
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.CREATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.CREATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public EntyRecmaetarivalorDto update(String id, EntyRecmaetarivalorDto dto) throws EBusinessException {
        try {
            EntyRecmaetarivalor entity = dtoToEntityTranslate.translate(dto);
            EntyRecmaetarivalor old = repository.findById(id).get();

            old.setRecSecregRetp(
                    Objects.nonNull(dto.getRecSecregRetp()) && !entity.getRecSecregRetp().isEmpty()
                            ? entity.getRecSecregRetp()
                            : old.getRecSecregRetp());
            old.setApjNroregAphp(
                    Objects.nonNull(entity.getApjNroregAphp()) && !entity.getApjNroregAphp().equals(0)
                            ? entity.getApjNroregAphp()
                            : old.getApjNroregAphp());
            old.setRecTipresRepe(
                    Objects.nonNull(dto.getRecTipresRepe()) && !entity.getRecTipresRepe().isEmpty()
                            ? entity.getRecTipresRepe()
                            : old.getRecTipresRepe());
            old.setRecTituloRetp(
                    Objects.nonNull(dto.getRecTituloRetp()) && !entity.getRecTituloRetp().isEmpty()
                            ? entity.getRecTituloRetp()
                            : old.getRecTituloRetp());
            old.setRecNotmemRetp(
                    Objects.nonNull(dto.getRecNotmemRetp()) && !entity.getRecNotmemRetp().isEmpty()
                            ? entity.getRecNotmemRetp()
                            : old.getRecNotmemRetp());
            old.setRecNotdetRetp(
                    Objects.nonNull(dto.getRecNotdetRetp()) && !entity.getRecNotdetRetp().isEmpty()
                            ? entity.getRecNotdetRetp()
                            : old.getRecNotdetRetp());
            old.setRecImage1Retp(
                    Objects.nonNull(dto.getRecImage1Retp()) && !entity.getRecImage1Retp().isEmpty()
                            ? entity.getRecImage1Retp()
                            : old.getRecImage1Retp());
            old.setRecImage2Retp(
                    Objects.nonNull(dto.getRecImage2Retp()) && !entity.getRecImage2Retp().isEmpty()
                            ? entity.getRecImage2Retp()
                            : old.getRecImage2Retp());

            old.setRecImage3Retp(
                    Objects.nonNull(dto.getRecImage3Retp()) && !entity.getRecImage3Retp().isEmpty()
                            ? entity.getRecImage3Retp()
                            : old.getRecImage3Retp());

            old.setRecOrdvisRetp(
                    Objects.nonNull(entity.getRecOrdvisRetp()) && !entity.getRecOrdvisRetp().equals(0)
                            ? entity.getRecOrdvisRetp()
                            : old.getRecOrdvisRetp());

            old.setRecTipmonRetm(
                    Objects.nonNull(dto.getRecTipmonRetm()) && !entity.getRecTipmonRetm().isEmpty()
                            ? entity.getRecTipmonRetm()
                            : old.getRecTipmonRetm());

            old.setRecPrecioRetp(
                    Objects.nonNull(entity.getRecPrecioRetp()) && !entity.getRecPrecioRetp().equals(0)
                            ? entity.getRecPrecioRetp()
                            : old.getRecPrecioRetp());

            old.setRecEstregRetp(
                    Objects.nonNull(entity.getRecEstregRetp()) && !entity.getRecEstregRetp().equals(0)
                            ? entity.getRecEstregRetp()
                            : old.getRecEstregRetp());

            return saveResponseTranslate.translate(repository.save(old));
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.UPDATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.UPDATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();

        }
    }

    @Override
    public void delete(String id) throws EBusinessException {
        try {
            repository.delete(repository.findById(id).get());
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.DELETE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.DELETE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

}
