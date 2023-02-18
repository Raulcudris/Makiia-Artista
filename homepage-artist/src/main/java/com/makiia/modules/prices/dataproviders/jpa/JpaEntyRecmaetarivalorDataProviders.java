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

            old.setRec_secreg_retp(
                    Objects.nonNull(dto.getRec_secreg_retp()) && !entity.getRec_secreg_retp().isEmpty()
                            ? entity.getRec_secreg_retp()
                            : old.getRec_secreg_retp());
            old.setApj_nroreg_aphp(
                    Objects.nonNull(entity.getApj_nroreg_aphp()) && !entity.getApj_nroreg_aphp().equals(0)
                            ? entity.getApj_nroreg_aphp()
                            : old.getApj_nroreg_aphp());
            old.setRec_tipres_repe(
                    Objects.nonNull(dto.getRec_tipres_repe()) && !entity.getRec_tipres_repe().isEmpty()
                            ? entity.getRec_tipres_repe()
                            : old.getRec_tipres_repe());
            old.setRec_titulo_retp(
                    Objects.nonNull(dto.getRec_titulo_retp()) && !entity.getRec_titulo_retp().isEmpty()
                            ? entity.getRec_titulo_retp()
                            : old.getRec_titulo_retp());
            old.setRec_notmem_retp(
                    Objects.nonNull(dto.getRec_notmem_retp()) && !entity.getRec_notmem_retp().isEmpty()
                            ? entity.getRec_notmem_retp()
                            : old.getRec_notmem_retp());
            old.setRec_notdet_retp(
                    Objects.nonNull(dto.getRec_notdet_retp()) && !entity.getRec_notdet_retp().isEmpty()
                            ? entity.getRec_notdet_retp()
                            : old.getRec_notdet_retp());
            old.setRec_image1_retp(
                    Objects.nonNull(dto.getRec_image1_retp()) && !entity.getRec_image1_retp().isEmpty()
                            ? entity.getRec_image1_retp()
                            : old.getRec_image1_retp());
            old.setRec_image2_retp(
                    Objects.nonNull(dto.getRec_image2_retp()) && !entity.getRec_image2_retp().isEmpty()
                            ? entity.getRec_image2_retp()
                            : old.getRec_image2_retp());

            old.setRec_image3_retp(
                    Objects.nonNull(dto.getRec_image3_retp()) && !entity.getRec_image3_retp().isEmpty()
                            ? entity.getRec_image3_retp()
                            : old.getRec_image3_retp());

            old.setRec_ordvis_retp(
                    Objects.nonNull(entity.getRec_ordvis_retp()) && !entity.getRec_ordvis_retp().equals(0)
                            ? entity.getRec_ordvis_retp()
                            : old.getRec_ordvis_retp());

            old.setRec_tipmon_retm(
                    Objects.nonNull(dto.getRec_tipmon_retm()) && !entity.getRec_tipmon_retm().isEmpty()
                            ? entity.getRec_tipmon_retm()
                            : old.getRec_tipmon_retm());

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
