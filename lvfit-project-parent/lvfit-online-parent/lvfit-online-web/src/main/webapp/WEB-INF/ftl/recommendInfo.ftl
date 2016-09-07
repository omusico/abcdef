
        <!-- 热卖目的地 START-->
        <input type="hidden" id="belongSiteId" name="belongSiteId" value="${belongSiteId}">
        <div class="hot">
            <div class="hot-title clearfix">
                <!-- 更多按钮 -->
                <div class="more-btns">
                    <#list destinations as val>
                    <a href="${val.url}" target="_blank" <#if val_index ==0 >style="display: inline;"</#if> >更多${val.title}<i></i></a>
                    </#list>
                </div>
                <h4>热卖目的地</h4>
                <ul class="hot-tab clearfix">
                    <#list destinations as val>
                    <li <#if val_index ==0>class="active"</#if> >${val.title}</li>
                    </#list>
                </ul>
            </div>

            <#list hotDestinationImgs as imgs>
            <ul class="hot-product clearfix" <#if imgs_index == 0>style="display:block"</#if> >
                <#list imgs as val>
                <li>
                    <a class="thumbnail" href="${val.url}" target="_blank">
                        <img to="${val.imgUrl}" width="265" height="176" alt="">
                    </a>
                    <a class="subtitle" href="${val.url}" target="_blank" title="${val.title}">${val.title}</a>
                    <p class="price"><i>¥</i><em>${val.price}</em>起</p>
                </li>
                </#list>
            </ul>
            </#list>
        </div>
        <!-- 热卖目的地 END-->

        <!-- 自由行热卖推荐 START -->
        <div class="recommend">
            <h3>自由行热卖推荐</h3>
            <div class="rec-main">
                <a class="rec-img" href="${map['fit_guanggao_left'][0].url}" target="_blank"><img to="${map['fit_guanggao_left'][0].imgUrl}" width="224" height="366" alt=""></a>
                <div class="rec-product">
                    <!-- top1-4 -->
                    <ol class="rec-top clearfix">
                        <#list map["fit_remaituijian"] as val>
                        <#if val_index lt 4>
                        <li>
                            <a class="thumbnail" href="${val.url}" target="_blank">
                                <span class="top-tip">TOP ${val_index+1}</span>
                                <img to="${val.imgUrl}" width="219" height="144" alt="">
                            </a>
                            <p class="des"><i></i>${val.bakWord1}<em>|</em><a href="${val.url}" target="_blank" title="${val.title}">${val.title}</a></p>
                            <p class="price"><i>¥</i><em>${val.price}</em>起</p>
                        </li>
                        </#if>
                        </#list>
                    </ol>
                    <!-- top5-7 -->
                    <ol class="rec-list clearfix">
                        <#list map["fit_remaituijian"] as val>
                        <#if val_index gt 3 && val_index lt 7>
                        <li>
                            <span class="num">${val_index+1}</span>
                            <a href="${val.url}" target="_blank" title="${val.title}">${val.title}</a>
                            <p class="price"><i>¥</i><em>${val.price}</em>起</p>
                        </li>
                        </#if>
                        </#list>
                    </ol>
                    <!-- top8-10 -->
                    <ol class="rec-list clearfix">
                        <#list map["fit_remaituijian"] as val>
                        <#if val_index gt 6>
                        <li>
                            <span class="num">${val_index+1}</span>
                            <a href="${val.url}" target="_blank" title="${val.title}">${val.title}</a>
                            <p class="price"><i>¥</i><em>${val.price}</em>起</p>
                        </li>
                        </#if>
                        </#list>
                    </ol>
                    <!-- 角标 -->
                    <i class="corner"></i>
                </div>
            </div>
        </div>