package com.lvmama.lvf.common.domain;

import com.lvmama.lvf.common.dto.Dto;

/**
 * @author mashengwen
 * 表明是哪个领域的service
 */
public interface DomainBaseService<D extends Domain<? extends Dto>> {

}
