package com.kudo.service;

import com.kudo.entity.Site;
import com.kudo.repository.SiteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SiteService {

    private static final Logger logger = LoggerFactory.getLogger(SiteService.class);

    @Autowired
    private SiteRepository siteRepository;

    public Site addSite(Site site){
        Site site1 = siteRepository.save(site);
        return site1;
    }

    public Site modifySite(String id, Site newSite){
        Site siteDB = siteRepository.findById(id).get();
        siteDB.modify(newSite);
        return siteRepository.save(siteDB);
    }

    public Site getSiteById(String id){
        return siteRepository.findById(id).get();
    }
}
