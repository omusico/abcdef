package com.lvmama.lvf.common.client;


import com.lvmama.lvf.common.client.SolrClient;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LowestPriceDailyClient extends SolrClient{

    @Value("solr.host_lowest_price_daily")
    private String solrHost;

    @Value("solr.core_lowest_price_daily")
    private String solrCore;

    @Override
    public String getSolrUrl() {
        String solrHosts = CustomizedPropertyPlaceholderConfigurer.getContextProperty(solrHost);
        String solrCores = CustomizedPropertyPlaceholderConfigurer.getContextProperty(solrCore);
        return solrHosts+solrCores;
    }
}
