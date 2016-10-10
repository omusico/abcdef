/**
 * Project Name:lvfit-adapter-vst
 * File Name:UserReceiverServiceAdapterImpl.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter.impl
 * Date:2015-12-10下午3:28:04
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.adapter.vst.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lvmama.comm.bee.vo.UsrReceivers;
import com.lvmama.comm.pet.service.user.IReceiverUserService;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.StringUtil;
import com.lvmama.lvfit.adapter.vst.adapter.UserReceiverServiceAdapter;
import com.lvmama.lvfit.common.dto.enums.Gender;
import com.lvmama.lvfit.common.dto.enums.IDCardType;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.member.FitPassengerInfoDto;
import com.lvmama.lvfit.common.dto.member.FitUserContacterDto;
import com.lvmama.lvfit.common.dto.request.FitOrderPassengerRequest;
import com.lvmama.lvfit.common.dto.request.MemUserRequest;

/**
 * ClassName:UserReceiverServiceAdapterImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-10 下午3:28:04 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
@Service
public class UserReceiverServiceAdapterImpl implements UserReceiverServiceAdapter {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private IReceiverUserService userReceiverService;

	@Override
	public List<FitUserContacterDto> getUserReceiverByUserId(MemUserRequest request) {
		BaseResultDto<FitUserContacterDto> baseResponse = new BaseResultDto<FitUserContacterDto>();
		List<FitUserContacterDto> results = new ArrayList<FitUserContacterDto>();
		try {
			List<UsrReceivers> receIverList = userReceiverService.loadUserReceiversByUserId(request.getUserId());
			if (CollectionUtils.isNotEmpty(receIverList)) {
				for (UsrReceivers receiver : receIverList) {
					FitUserContacterDto passengerVst = new FitUserContacterDto();
					/** 乘客id */
					passengerVst.setReceiverId(receiver.getReceiverId());
					/** 乘客姓名 */
					passengerVst.setReceiverName(receiver.getReceiverName());
					/** 乘客类型 */
					if (StringUtils.isNotEmpty(receiver.getPeopleType())) {
						if ("PEOPLE_TYPE_ADULT".equals(receiver.getPeopleType())) {
							passengerVst.setPeopleType("ADULT");
						} else if ("PEOPLE_TYPE_CHILD".equals(receiver.getPeopleType())) {
							passengerVst.setPeopleType("CHILDREN");
						}
					}
					/** 乘客性别 */
					if (StringUtils.isNotEmpty(receiver.getGender())) {
						if (receiver.getGender().equals("M")) {
							passengerVst.setReceiverGender("MALE");
						} else if (receiver.getGender().equals("F")) {
							passengerVst.setReceiverGender("FEMALE");
						}
					}
					/** 证件号码 */
					passengerVst.setCertNo(receiver.getCardNum());
					/** 证件类型 */
					if (StringUtils.isNotEmpty(receiver.getCardType())) {
						if (receiver.getCardType().equals("ID_CARD")) {
							passengerVst.setCertType("ID");
						} else if (receiver.getCardType().equals("HUZHAO")) {
							passengerVst.setCertType("PASSPORT");
						} else if (receiver.getCardType().equals("JUNGUAN")) {
							passengerVst.setCertType("OFFICER");
						} else if (receiver.getCardType().equals("SHIBING")) {
							passengerVst.setCertType("SOLDIER");
						} else if (receiver.getCardType().equals("TAIBAOZHENG")) {
							passengerVst.setCertType("TAIBAO");
						} else {
							passengerVst.setCertType("OTHER");
						}
					}
					passengerVst.setEmail(receiver.getEmail());
					/** 生日 */
					passengerVst.setBirthday(receiver.getBrithday());
					/** 手机号码 */
					passengerVst.setMobileNumber(receiver.getMobileNumber());
					results.add(passengerVst);
				}
			}
		} catch (Exception e) {
			logger.error("VST查询常用乘客信息",e);
			baseResponse.setIsSuccess(false);
			baseResponse.setStatus(ResultStatus.FAIL);
		}
		baseResponse.setResults(results);
		return results;
	}

	/**
	 * 乘客类型信息转换
	 * 
	 * @param passengerInfo
	 * @return
	 */
	private UsrReceivers getUserReciversType(FitPassengerInfoDto passengerInfo) {
		UsrReceivers receiver = new UsrReceivers();
		try {
			receiver.setIsMobileChecked("true");
			/** 乘客姓名 */
			receiver.setReceiverName(passengerInfo.getReceiverName());
			/** 生日 */
			receiver.setBrithday(passengerInfo.getBirthday());
			/** 手机号码 */
			receiver.setMobileNumber(passengerInfo.getMobileNumber());
			/** 证件号码 */
			receiver.setCardNum(passengerInfo.getCertNo());
            /**邮件**/
			receiver.setEmail(passengerInfo.getEmail());
			/** 乘客类型 */
			if (StringUtils.isNotEmpty(passengerInfo.getPeopleType())) {
				if (passengerInfo.getPeopleType().equals(PassengerType.ADULT.name())) {
					receiver.setPeopleType("PEOPLE_TYPE_ADULT");
				} else if (passengerInfo.getPeopleType().equals(PassengerType.CHILDREN.name())) {
					receiver.setPeopleType("PEOPLE_TYPE_CHILD");
				}
			}
			/** 乘客性别 */
			if (StringUtils.isNotEmpty(passengerInfo.getReceiverGender())) {
				if (passengerInfo.getReceiverGender().equals(Gender.MALE.name())) {
					receiver.setGender("M");
				} else if (passengerInfo.getReceiverGender().equals(Gender.FEMALE.name())) {
					receiver.setGender("F");
				}
			}
			/** 证件类型 */
			if (StringUtils.isNotEmpty(passengerInfo.getCertType())) {
				if (passengerInfo.getCertType().equals(IDCardType.ID.name())) {
					receiver.setCardType("ID_CARD");
				} else if (passengerInfo.getCertType().equals(IDCardType.PASSPORT.name())) {
					receiver.setCardType("HUZHAO");
				} else if (passengerInfo.getCertType().equals(IDCardType.OFFICER.name())) {
					receiver.setCardType("JUNGUAN");
				} else if (passengerInfo.getCertType().equals(IDCardType.SOLDIER.name())) {
					receiver.setCardType("SHIBING");
				} else if (passengerInfo.getCertType().equals(IDCardType.TAIBAO.name())) {
					receiver.setCardType("TAIBAOZHENG");
				} else {
					receiver.setCardType("OTHER");
				}
			}

		} catch (Exception e) {
			logger.error("VST查询常用乘客信息",e);
		}
		return receiver;
	}

	@Override
	public ResultStatus saveOrderPassengerInfo(FitOrderPassengerRequest passengerRequst) {
		try {
			if (null == passengerRequst) {
				return ResultStatus.FAIL;
			}
			List<FitPassengerInfoDto> passengerList = passengerRequst.getFitPassengers();
			if (CollectionUtils.isNotEmpty(passengerList)) {
				for (FitPassengerInfoDto passengerInfo : passengerList) {
					List<UsrReceivers> usrReceivers = new ArrayList<UsrReceivers>();
					// 判断如果receiverId存在，就做update操作，否则insert
					if (StringUtil.isNotEmptyString(passengerInfo.getReceiverId())) {
						UsrReceivers receiver = this.getUserReciversType(passengerInfo);
						receiver.setReceiverId(passengerInfo.getReceiverId());
						usrReceivers.add(receiver);
						try {
							if(logger.isInfoEnabled()){
							    logger.info("VST更新常用乘客信息：" + JSONMapper.getInstance().writeValueAsString(receiver));
							    logger.info("VST更新常用乘客信息ID：" + passengerRequst.getUserId());
							}
						} catch (Exception e) {
						    logger.error(e.getMessage());
						}
						userReceiverService.createContact(usrReceivers, passengerRequst.getUserId());
					} else {
						UsrReceivers receiver = this.getUserReciversType(passengerInfo);
						receiver.setUseOffen("true");
						usrReceivers.add(receiver);
						try {
							if(logger.isInfoEnabled()){
							    logger.info("VST添加常用乘客信息：" + JSONMapper.getInstance().writeValueAsString(receiver));
							    logger.info("VST添加常用乘客信息ID：" + passengerRequst.getUserId());
							}
						} catch (Exception e) {
							logger.error(e.getMessage());
                        }
						userReceiverService.createContact(usrReceivers, passengerRequst.getUserId());
					}
				}
			}
		} catch (Exception e) {
			logger.error("VST添加修改常用乘客信息",e);
			return ResultStatus.FAIL;
		}
		return ResultStatus.SUCCESS;
	}

}
