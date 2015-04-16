package com.env.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.env.dto.PtUser;

public class ReadTxt {

	public static List<PtUser> imp(){
		// TODO
				String str = ReadTxt.readTxtFile("E:\\字段拼接.txt");
				
				String []strs = str.trim().split("，");
				
				List<PtUser> us = new ArrayList<PtUser>();
				for(int i=0;i<strs.length;i++){
					
					System.out.println(strs[i]);
					
					String []str2s =strs[i].trim().split("：");
					
					PtUser u = new PtUser();
					u.setUsername(str2s[0]);
					u.setPwd(str2s[1]);
					
					int r = ReadTxt.exist(us, u);
					if(r==1){
						System.out.println(u.getUsername()+"已经存在name");
					}
					if(r==2){
						System.out.println(u.getPwd()+"已经存在field_name");
					}
					if(r==3){
						us.add(u);
					}
				}
				return us;
	}
	  /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     * @param filePath
     */
    public static String readTxtFile(String filePath){
    	
    	StringBuffer rtn = new StringBuffer();
        try {
        	
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        System.out.println(lineTxt);
                        lineTxt = lineTxt.trim().replaceAll(",", "，");
                        rtn.append(lineTxt.trim()) ;
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        System.out.println("");
        System.out.println(rtn.toString());
        
        return rtn.toString();
    }
     
    public static void main(String argv[]){
        String filePath = "E:\\字段拼接.txt";
        readTxtFile(filePath);
    }
    /**
     *  1:name已经存在，2:field_name已经存在，3：插入
     * @param us
     * @param u
     * @return
     */
    public static int exist (List<PtUser> us , PtUser u){
    	int r = 3;
    	for(PtUser ua : us){
    		if(ua.getUsername().equals(u.getUsername())){
    			r = 1;
    		}else if(ua.getPwd().equals(u.getPwd())){
    			r = 2;
    		}
    	}
		return r;
    }
}
