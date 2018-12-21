package com.biz.commerce.exec;

import com.biz.commerce.service.CommService;

public class CommExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strF1 = "src/com/biz/commerce/매입매출장3.txt";
		String strF2 = "src/com/biz/commerce/상품리스트.txt";
		String strP = "src/com/biz/commerce/vo/매입매출정보.txt";
		
		CommService com = new CommService(strF1, strF2, strP);
		
		com.readFile1();
		com.readFile2();
		com.saveFile();
		
		
		
				

	}

}
