package br.facens.plataformateologia.infrastructure.config;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
public class CacheConfig {

    @CacheEvict(value = "material/home", allEntries = true)
    @Scheduled(fixedRateString = "${cache.material.home.ttl-miliseconds}")
    public void limparCacheMateriaisHome() {
        System.out.println("Limpeza do cache de materiais da home.");
    }

    @CacheEvict(value = "material/paginacao", allEntries = true)
    @Scheduled(fixedRateString = "${cache.material.paginacao.ttl-miliseconds}")
    public void limparCacheMateriaisPaginacao() {
        System.out.println("Limpeza do cache de materiais com paginação.");
    }

    @CacheEvict(value = "material/detalhe", allEntries = true)
    @Scheduled(fixedRateString = "${cache.material.detalhe.ttl-miliseconds}")
    public void limparCacheDetalheMaterial() {
        System.out.println("Limpeza do cache de detalhes do material.");
    }

    @CacheEvict(value = "capitulo/detalhe", allEntries = true)
    @Scheduled(fixedRateString = "${cache.capitulo.detalhe.ttl-miliseconds}")
    public void limparCacheDetalheCapitulo() {
        System.out.println("Limpeza do cache de detalhes do capitulo.");
    }

}
