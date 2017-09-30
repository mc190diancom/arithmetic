package com.miu360;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	private static ArrayList<String> imgAddr;
	private static ArrayList<String> localAddr;
	
	public static void main(String[] args) {
		init();
		System.out.println(compareTo().size()+"==="+compareTo2().size()+"==="+compareTo3().size());
	}

	private static void init() {
		imgAddr = new ArrayList<>();
		localAddr = new ArrayList<>();
		for(int i=0;i<100000;i++){
			imgAddr.add(i+",");
			localAddr.add((i+100)+",");
		}
	}

	/**
	 * 返回localAddr中没用的文件名
	 * @return
	 */
	private static List<String> compareTo() {
		long t = System.currentTimeMillis();
		
        Map<String,Integer> map = new HashMap<String,Integer>(imgAddr.size());  
        List<String> diff = new ArrayList<String>(); 
        for (String string : imgAddr) {  
            map.put(string, 1);  
        }  
        for (String string : localAddr) {  
            boolean cc = map.containsKey(string);  
            if(!cc){//在map中不存在，即是没用的
            	diff.add(string);
            }else{//
            }
        }  
        System.out.println("containsKey:"+(System.currentTimeMillis() - t));
        return diff;  
	}
	
	private static List<String> compareTo2() {
		long t = System.currentTimeMillis();
		
        Map<String,Integer> map = new HashMap<String,Integer>(imgAddr.size());  
        List<String> diff = new ArrayList<String>(); 
        for (String string : imgAddr) {  
            map.put(string, 1);  
        }  
        for (String string : localAddr) {  
            Integer cc = map.get(string);  
            if(cc != null){//在map中不存在，即是没用的
            	
            }else{//
            	diff.add(string);
            }
        }  
        System.out.println("get:"+(System.currentTimeMillis() - t));
        return diff;  
	}

	private static List<String> compareTo3() {
		long t = System.currentTimeMillis();
		List<String> diff = new ArrayList<String>(); 
		for(String string : localAddr){
            if(!imgAddr.contains(string)){
            	diff.add(string);
			}
		}
        System.out.println("contains:"+(System.currentTimeMillis() - t));
        return diff;  
	}
}
