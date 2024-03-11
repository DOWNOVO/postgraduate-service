package com.zjz.untils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CheckFormat {

    /**
     * 检验单选题excel格式
     */
    public static boolean selectQuestion(Workbook we){
        //获取第一个工作表对象
        Sheet sheet = we.getSheetAt(0);
        // 获取第一行数据（假如第一行就是列名）
        Row sheetTitleRow = sheet.getRow(sheet.getFirstRowNum());
        // 取出最后一列
        short lastCellNum = sheetTitleRow.getLastCellNum();
        //excel应有的列名
        ArrayList arrayList = new ArrayList();
        arrayList.add("selectquestion_describe");
        arrayList.add("selectquestion_A");
        arrayList.add("selectquestion_B");
        arrayList.add("selectquestion_C");
        arrayList.add("selectquestion_D");
        arrayList.add("selectquestion_answer");
        arrayList.add("selectquestion_Knowledgepoints");
        arrayList.add("selectquestion_analysis");
        arrayList.add("selectquestion_subject");

        for (int i = 0; i < lastCellNum; i++) {
            //防止长度溢出
            if (i >= arrayList.size()){
                return false;
            }
            String s = arrayList.get(i).toString();
            //取出每一列的名
            String cellValue = sheetTitleRow.getCell(i).getStringCellValue();
            if (!s.equals(cellValue)){
                return false;
            }
        }
        return true;
    }


    /**
     * 检验多选题excel格式
     */
    public static boolean manyselectquestion(Workbook we){
        //获取第一个工作表对象
        Sheet sheet = we.getSheetAt(0);
        // 获取第一行数据（假如第一行就是列名）
        Row sheetTitleRow = sheet.getRow(sheet.getFirstRowNum());
        // 取出最后一列
        short lastCellNum = sheetTitleRow.getLastCellNum();
        //excel应有的列名
        ArrayList arrayList = new ArrayList();
        arrayList.add("manyselectquestion_describe");
        arrayList.add("manyselectquestion_A");
        arrayList.add("manyselectquestion_B");
        arrayList.add("manyselectquestion_C");
        arrayList.add("manyselectquestion_D");
        arrayList.add("manyselectquestion_answer");
        arrayList.add("manyselectquestion_Knowledgepoints");
        arrayList.add("manyselectquestion_analysis");
        arrayList.add("manyselectquestion_subject");

        for (int i = 0; i < lastCellNum; i++) {
            //防止长度溢出
            if (i >= arrayList.size()){
                return false;
            }
            String s = arrayList.get(i).toString();
            //取出每一列的名
            String cellValue = sheetTitleRow.getCell(i).getStringCellValue();
            if (!s.equals(cellValue)){
                return false;
            }
        }
        return true;
    }

    /**
     * 检验判断题excel格式
     */
    public static boolean judgmentquestion(Workbook we){
        //获取第一个工作表对象
        Sheet sheet = we.getSheetAt(0);
        // 获取第一行数据（假如第一行就是列名）
        Row sheetTitleRow = sheet.getRow(sheet.getFirstRowNum());
        // 取出最后一列
        short lastCellNum = sheetTitleRow.getLastCellNum();
        //excel应有的列名
        ArrayList arrayList = new ArrayList();
        arrayList.add("judgmentquestion_describe");
        arrayList.add("judgmentquestion_answer");
        arrayList.add("judgmentquestion_Knowledgepoints");
        arrayList.add("judgmentquestion_analysis");
        arrayList.add("judgmentquestion_subject");

        for (int i = 0; i < lastCellNum; i++) {
            //防止长度溢出
            if (i >= arrayList.size()){
                return false;
            }
            String s = arrayList.get(i).toString();
            //取出每一列的名
            String cellValue = sheetTitleRow.getCell(i).getStringCellValue();
            if (!s.equals(cellValue)){
                return false;
            }
        }
        return true;
    }

    /**
     * 检验填空题题excel格式
     */
    public static boolean packquestion(Workbook we){
        //获取第一个工作表对象
        Sheet sheet = we.getSheetAt(0);
        // 获取第一行数据（假如第一行就是列名）
        Row sheetTitleRow = sheet.getRow(sheet.getFirstRowNum());
        // 取出最后一列
        short lastCellNum = sheetTitleRow.getLastCellNum();
        //excel应有的列名
        ArrayList arrayList = new ArrayList();
        arrayList.add("packquestion_describe");
        arrayList.add("packquestion_answer");
        arrayList.add("packquestion_Knowledgepoints");
        arrayList.add("packquestion_analysis");
        arrayList.add("packquestion_subject");

        for (int i = 0; i < lastCellNum; i++) {
            //防止长度溢出
            if (i >= arrayList.size()){
                return false;
            }
            String s = arrayList.get(i).toString();
            //取出每一列的名
            String cellValue = sheetTitleRow.getCell(i).getStringCellValue();
            if (!s.equals(cellValue)){
                return false;
            }
        }
        return true;
    }

}
