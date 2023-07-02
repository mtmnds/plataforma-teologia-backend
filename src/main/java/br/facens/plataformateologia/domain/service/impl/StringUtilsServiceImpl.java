package br.facens.plataformateologia.domain.service.impl;

import br.facens.plataformateologia.domain.service.StringUtilsService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

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

    @Override
    public String createStringHash(String... args) {
        StringBuilder sb = new StringBuilder();
        for (String str : args) {
            if (str == null) {
                sb.append("_");
            }
            else {
                sb.append(String.format("%s_", str));
            }
        }
        return DigestUtils.md5DigestAsHex(sb.toString().getBytes(StandardCharsets.UTF_8));
    }
}
