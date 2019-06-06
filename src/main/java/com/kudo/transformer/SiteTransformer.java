package com.kudo.transformer;

import com.kudo.dto.SiteDTO;
import com.kudo.entity.Site;
import org.springframework.stereotype.Component;


@Component
public class SiteTransformer implements BaseTransformer<SiteDTO, Site> {

    @Override
    public SiteDTO toDto(Site site) {
        SiteDTO siteDTO = new SiteDTO(site.getId(), site.getTel(), site.getEmail(), site.getAddress(), site.getQrcode());
        return siteDTO;
    }

    @Override
    public Site toEntity(SiteDTO siteDTO) {
        Site site = new Site(siteDTO.getTel(), siteDTO.getEmail(), siteDTO.getAddress(), siteDTO.getQrcode());
        return site;
    }
}

