package com.biz.commerce.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.biz.commerce.vo.CommVo;

public class CommService {

	List<CommVo> cList;
	String strIn;
	String strOut;
	String strP;
	
	public CommService(String strIn, String strOut, String strP) {
		cList = new ArrayList();
		this.strIn = strIn;
		this.strOut = strOut;
		this.strP = strP;
	}
	
	public void readFile1() {
		FileReader fr;
		BufferedReader bf;
		
		try {
			fr = new FileReader(strIn);
			bf = new BufferedReader(fr);
			
			while(true) {
				String read = bf.readLine();
				if(read == null)break;
				String[] strR = read.split(":");
				CommVo vo = new CommVo();
				
				vo.setStrDate(strR[0]);
				vo.setStrCode(strR[1]);
				vo.setIntIO(Integer.valueOf(strR[2]));
				vo.setIntPri(Integer.valueOf(strR[3]));
				vo.setIntQuan(Integer.valueOf(strR[4]));
				
				
				cList.add(vo);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void readFile2() {
		FileReader fr;
		BufferedReader bf;
		
		try {
			fr = new FileReader(strOut);
			bf = new BufferedReader(fr);
			int i = 0;
			while(true) {
				String read = bf.readLine();
				if(read == null)break;
				String[] strR = read.split(":");
				CommVo vo = cList.get(i);
				i++;
				
				vo.setStrCode(strR[0]);
				vo.setStrName(strR[1]);
				vo.setIntIO(Integer.valueOf(strR[2]));
				vo.setIntIP(Integer.valueOf(strR[3]));
				vo.setIntOP(Integer.valueOf(strR[4]));
				cList.add(vo);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void saveFile() {
		
		this.readFile1();
		this.readFile2();
		
		FileWriter fw;
		PrintWriter pw;
		String strI ="src/com/biz/commerce/vo/매입매출정보.txt";
		//String strC = v.getStrCode();
		
		
		try {
			fw = new FileWriter(strI );
			pw = new PrintWriter(fw);
		
		for(CommVo vo : cList) {
			
			
				String strIo ;
				int in = 0;
				int out = 0;
			
				if(vo.getIntIO() == 1) {
					strIo = "매입";
					in = vo.getIntPri() * vo.getIntQuan(); 
					pw.println(vo.getStrDate() + ":" + strIo + ":" 
							+ vo.getStrCode() + ":" + vo.getStrName() + ":" + vo.getIntPri() + ":"
							+ vo.getIntQuan() + ":" + in + ":" + out);
					
				} else {
					strIo = "매출";
					out = vo.getIntPri() * vo.getIntQuan(); 
					pw.println(vo.getStrDate() + ":" + strIo + ":" 
							+ vo.getStrCode() + ":" + vo.getStrName() + ":" + vo.getIntPri() + ":"
							+ vo.getIntQuan() + ":" + in + ":" + out);
				}
				
			}
			
			fw.close();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
