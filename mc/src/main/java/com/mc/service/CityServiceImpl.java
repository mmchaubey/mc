package com.mc.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service("cityService")
public class CityServiceImpl implements CityService{
	
	public String isconnected(String origin, String destination) {
		boolean flag = false;
		//read from text file
		File file;
		BufferedReader br = null;
		try {
			file = ResourceUtils.getFile("classpath:city.txt");
			InputStream in = new FileInputStream(file);
			Reader reader = new InputStreamReader(in, "UTF-8");
			br = new BufferedReader(reader);
			String s;
			while ((s = br.readLine()) != null) {
				    if(s.contains(origin) && s.contains(destination) && (s.indexOf(origin) < s.indexOf(destination))) {
				    	flag = true;
				    	break;
				    }
				}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		//String returnValue = flag? "yes":"no";
			
        return flag? "yes":"no";
		
	}

}
