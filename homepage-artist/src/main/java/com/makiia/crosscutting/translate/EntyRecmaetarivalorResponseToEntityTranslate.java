package com.makiia.crosscutting.translate;

import com.makiia.crosscutting.domain.model.EntyRecmaetarivalorResponse;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.patterns.Translator;
import com.makiia.crosscutting.persistence.entity.EntyRecmaetarivalor;
import com.makiia.crosscutting.utils.GsonUtil;
import org.springframework.stereotype.Component;

@Component
public class EntyRecmaetarivalorResponseToEntityTranslate  implements Translator<EntyRecmaetarivalorResponse, EntyRecmaetarivalor> {
    @Override
    public EntyRecmaetarivalor translate(EntyRecmaetarivalorResponse input) throws EBusinessException {
        return GsonUtil.getGson(false)
                .fromJson(GsonUtil.getGson().toJson(input), EntyRecmaetarivalor.class);
    }
}
