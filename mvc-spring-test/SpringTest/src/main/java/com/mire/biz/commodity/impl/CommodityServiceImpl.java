package com.mire.biz.commodity.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mire.biz.commodity.CommodityService;
import com.mire.biz.commodity.CommodityVO;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	public CommodityDAO commodityDAO;
	
	@Override
	public void insertCommodity(CommodityVO vo) {
		// TODO Auto-generated method stub
		commodityDAO.insertCommodity(vo);
	}

	@Override
	public void updateCommodity(CommodityVO vo) {
		// TODO Auto-generated method stub
		commodityDAO.updateCommodity(vo);;
	}

	@Override
	public void deleteCommodity(CommodityVO vo) {
		// TODO Auto-generated method stub
		commodityDAO.deleteCommodity(vo);;
	}

	@Override
	public CommodityVO getCommodity(CommodityVO vo) {
		// TODO Auto-generated method stub
		return commodityDAO.getCommodity(vo);
	}

	@Override
	public List<CommodityVO> getCommodityList(CommodityVO vo) {
		// TODO Auto-generated method stub
		return commodityDAO.getCommodityList(vo);
	}

}
