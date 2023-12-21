package com.mire.biz.commodity;

import java.util.List;

public interface CommodityService {

	// 상품 등록
	void insertCommodity(CommodityVO vo);

	// 상품 수정
	void updateCommodity(CommodityVO vo);

	// 상품 삭제
	void deleteCommodity(CommodityVO vo);

	// 상품 상세 조회
	CommodityVO getCommodity(CommodityVO vo);

	//상품 목록 조회
	List<CommodityVO> getCommodityList(CommodityVO vo);

}