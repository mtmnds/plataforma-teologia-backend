package br.facens.plataformateologia.domain.service.impl;

import br.facens.plataformateologia.domain.service.StringUtilsService;
import org.springframework.stereotype.Service;

@Service
public class StringUtilsServiceImpl implements StringUtilsService {

    @Override
    public String limitStringTo100char(String text) {
        if (text != null && text.length() > 100) {
            text = text.substring(0, 97);
            text += "...";
        }

        return text;
    }

}
