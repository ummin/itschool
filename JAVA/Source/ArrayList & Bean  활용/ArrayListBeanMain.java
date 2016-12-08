package kr.ac.itschool.beanlist0803w;

import java.util.ArrayList;

public class ArrayListBeanMain {

	public static void main(String[] args) {
		
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<ArrayListBean> blist = new ArrayList<ArrayListBean>();
		ArrayListBean data = new ArrayListBean();
		
		data.setCode("1001");
		data.setName("박지성");
		
		list.add("PSV");
		list.add("ManU");
		list.add("QPR");
		list.add("PSVr");
		list.add("ManU legned");
		
		data.setList(list);
		
		blist.add(data);
		
		data = new ArrayListBean();
		
		data.setCode("1002");
		data.setName("Ronaldo");
		
		list = new ArrayList<String>();
		list.add("Sporiting");
		list.add("ManU");
		list.add("RealMardrid");
		
		data.setList(list);
		
		blist.add(data);
		
		for ( ArrayListBean blist1 :blist ){
			System.out.print(blist1.getCode()+"\t");
			System.out.print(blist1.getName()+"\t");
			for ( String total : blist1.getList()){
				System.out.print(total+"\t");
			}
			System.out.println();
		}
	}
}
