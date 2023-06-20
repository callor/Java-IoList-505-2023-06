package com.callor.iolist.exec;

import com.callor.iolist.service.ProductService;
import com.callor.iolist.service.impl.ProductServiceImplV1;

public class ExecD {
	
	public static void main(String[] args) {
		ProductService productService = new ProductServiceImplV1();
		productService.insert();
	}

}
