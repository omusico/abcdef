<script src="http://pic.lvmama.com/js/v6/public/footer.js"></script>
	<div class="hh_cooperate">
    <#if friendList?? && friendList?size gt 0>
	    <p><b>友情链接：</b><span>
	        <#list friendList as seoFriendLink>
	            <#assign linkUrl = seoFriendLink.friendLinkUrl/>
	            <#if linkUrl?if_exists>
	                <#if linkUrl?contains("http://")>
	                    <a href="${linkUrl}" target="_blank" hidefocus="false">${seoFriendLink.friendLinkName?if_exists}</a>
	                <#else>
	                    <a href="http://${linkUrl}" target="_blank" hidefocus="false">${seoFriendLink.friendLinkName?if_exists}</a>
	                </#if>
	            <#else>
	                <a href="#" target="_blank" hidefocus="false">${seoFriendLink.friendLinkName?if_exists}</a>
	            </#if>
	        </#list>
	    </span></p>
	</#if>
    <#if innerList?? && innerList?size gt 0>
    <p><b>热门精选：</b><span>
        <#list innerList as innerLink>
            <#assign linkUrl = innerLink.linkUrl/>
            <#if linkUrl?if_exists>
                <#if linkUrl?contains("http://")>
                    <a href="${linkUrl}" target="_blank" hidefocus="false">${innerLink.linkName?if_exists}</a>
                <#else>
                    <a href="http://${linkUrl}" target="_blank" hidefocus="false">${innerLink.linkName?if_exists}</a>
                </#if>
            <#else>
                <a href="#" target="_blank" hidefocus="false">${innerLink.linkName?if_exists}</a>
            </#if>
        </#list>
    </span></p>
</#if>
</div>
	<div class="footer_links"></div>