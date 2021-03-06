package com.api.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.api.domain.APIDataItem;
import com.api.domain.Menu;
import com.api.mapper.MenuMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParsingData {
    public ParsingData(){}
    
    @Autowired
    MenuMapper menuMapper;

    public List<HashMap<String, Object>> getMenu(String startIdx, String endIdx, String groupNum) {
        List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();

        try {
            StringBuffer input = new StringBuffer();
            String apiUrl = "https://openapi.mnd.go.kr/3337313637333633343031323532313037/json/DS_TB_MNDT_DATEBYMLSVC_" + groupNum + "/" + startIdx + "/" + endIdx + "/";
            URL url = new URL(apiUrl);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));

            String res;

            while((res = bufferedReader.readLine()) != null) {
                input.append(res + "\n");
            }
            urlConn.disconnect();

            Gson gson = new Gson();
            HashMap<String, Object> jsonObject = gson.fromJson(input.toString(), new TypeToken<HashMap<String, Object>>(){}.getType());
            //System.out.println(jsonObject);
            String serializeString = gson.toJson(jsonObject.get("DS_TB_MNDT_DATEBYMLSVC_"+groupNum));
            //System.out.println(serializeString);

            HashMap<String, Object> jsonObject2 = gson.fromJson(serializeString, new TypeToken<HashMap<String, Object>>(){}.getType());
            serializeString = gson.toJson(jsonObject2.get("row"));
            //System.out.println(serializeString);

            List<HashMap<String, Object>> apiData = gson.fromJson(serializeString, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
            //System.out.println(apiData);

            /* For Debug
            for(Map<String, Object> map : apiData){
                for(Map.Entry<String, Object> entry : map.entrySet()){
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(map.get("lunc"));
                    System.out.println(map.get("brst"));
                    System.out.println(map.get("dinr"));
                }
            }
            */
            
            result = apiData;
            return result;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // ????????? DB??? ????????????.
    // ????????? ?????? ????????????.
    public List<HashMap<String, Object>> saveData(String startIdx, String endIdx, String groupNum) {

        try{
            List<HashMap<String, Object>> datas = getMenu(startIdx, endIdx, groupNum);
            /* For Debug
            for(Map<String, Object> map : datas){
                for(Map.Entry<String, Object> entry : map.entrySet()){
                     String key = entry.getKey();
                     Object value = entry.getValue();
                     System.out.println(map.get("lunc"));
                     System.out.println(map.get("brst"));
                     System.out.println(map.get("dinr"));
                     System.out.println("--saveMenu--");
                }
            }
            */

            Menu brst = new Menu();
            Menu lunc = new Menu();
            Menu dinr = new Menu();
            long groupId = Long.valueOf(groupNum);
            for(HashMap<String, Object> map : datas) {
                // ?????? ????????? ???????????? ?????? ?????? DB??? ??????
                brst = menuMapper.findMenuByName(map.get("brst").toString(), groupId);

                if(brst == null && !map.get("brst").toString().trim().isEmpty()) {
                    menuMapper.addMenu(map.get("brst").toString(), 1, groupId);
                } 
                lunc = menuMapper.findMenuByName(map.get("lunc").toString(), groupId);

                if(lunc == null && !map.get("lunc").toString().trim().isEmpty()) {
                    menuMapper.addMenu(map.get("lunc").toString(), 1, groupId);
                }
                dinr = menuMapper.findMenuByName(map.get("dinr").toString(), groupId);

                if(dinr == null && !map.get("dinr").toString().trim().isEmpty()) {
                    menuMapper.addMenu(map.get("dinr").toString(), 1, groupId);
                }
            }
            return datas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> message = new HashMap<String, Object>();
        message.put("error", "nodata");
        result.add(message);
        return result;
    }


    //DailyMenu??? ????????????.
    public List<HashMap<String, Object>> setDailyMenu(long groupId, String startIdx, String endIdx, String groupNum) {
        // ???????????? ?????? ???????????? ?????? ????????? ???????????? ????????? ?????? save??? ???????????? ??????
        saveData(startIdx, endIdx, groupNum);

        List<HashMap<String, Object>> datas = getMenu(startIdx, endIdx, groupNum);
        
        String date_str = "";
        Date date = new Date(20210101);

        Menu brst = new Menu();
        Menu lunc = new Menu();
        Menu dinr = new Menu();
        
        for(HashMap<String, Object> map : datas){
            if(date_str == null) {
                date_str = map.get("dates").toString();
                date = Date.valueOf(date_str);
            } 
            if(date_str != map.get("dates").toString()) {
                date_str = map.get("dates").toString();
                date = Date.valueOf(date_str);
            }
            // ?????? date??? ???????????? ???????????? ?????? ????????????????    
            List<HashMap<String, Object>> dailylist = menuMapper.findDailyMenuByDate(date, groupId);

            long brst_id = (map.get("brst").toString().trim().isEmpty()) ? -1 : menuMapper.findMenuByName(map.get("brst").toString(), groupId).getId();
            long lunc_id = (map.get("lunc").toString().trim().isEmpty()) ? -1 : menuMapper.findMenuByName(map.get("lunc").toString(), groupId).getId();
            long dinr_id = (map.get("dinr").toString().trim().isEmpty()) ? -1 : menuMapper.findMenuByName(map.get("dinr").toString(), groupId).getId();

            String brstId_str = Long.toString(brst_id);
            String luncId_str = Long.toString(lunc_id);
            String dinrId_str = Long.toString(dinr_id);

            // ?????? date??? ???????????? ????????? ?????? ????????? ?????? ????????? ?????? 
            for(HashMap<String, Object> dailymenu : dailylist) {
                // ?????? ??????????????? ??????
                if(brst_id == -1 || brstId_str.equals(dailymenu.get("menu").toString())) {
                    brst_id = -1;
                }
                if(lunc_id == -1 || luncId_str.equals(dailymenu.get("menu").toString())) {
                    lunc_id = -1;
                }
                if(dinr_id == -1 || dinrId_str.equals(dailymenu.get("menu").toString())) {
                    dinr_id = -1;
                }
            }
            // id == -1?????? ??????????????? ??????
            if(brst_id != -1) {
                menuMapper.addDailyMenu(date, 1, groupId, brst_id);
            }
            if(lunc_id != -1) {
                menuMapper.addDailyMenu(date, 2, groupId, lunc_id);
            }
            if(dinr_id != -1) {
                menuMapper.addDailyMenu(date, 3, groupId, dinr_id);
            }
        }
        return datas;
    }
}