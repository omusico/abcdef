package com.lvmama.lvfit.solrClient.extend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.SolrClient;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;

@Component
public class FitMainSearchSolrClient extends SolrClient {

    @Value("solr.host")
    private String solrHost;

    @Value("solr.core_fit_search_record")
    private String solrCore;

    @Override
    public String getSolrUrl() {
        String solrHosts = CustomizedPropertyPlaceholderConfigurer.getContextProperty(solrHost);
        String solrCores = CustomizedPropertyPlaceholderConfigurer.getContextProperty(solrCore);
        return solrHosts + solrCores;
    }

}
