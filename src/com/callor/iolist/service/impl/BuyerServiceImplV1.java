package com.callor.iolist.service.impl;

import java.util.List;

import com.callor.iolist.models.BuyerDto;
import com.callor.iolist.service.BuyerService;

public class BuyerServiceImplV1 implements BuyerService{

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printList(List<BuyerDto> buyerList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void PrintBuyer(BuyerDto buyerDto) {
		System.out.printf("%s\t",buyerDto.buId);
		System.out.printf("%s\t",buyerDto.buName);
		System.out.printf("%s\t",buyerDto.buTel);
		System.out.printf("%s\n",buyerDto.buAddr);
	}

	@Override
	public BuyerDto findByBuId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuyerDto findByBuName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuyerDto findByBuTel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String newBuId() {
		// TODO Auto-generated method stub
		return null;
	}

}
