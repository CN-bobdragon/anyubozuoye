package com.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @ClassName ExcelUtil
 * @Description Excel操作工具类
 */
public class ExcelUtil {
    public static <T> Workbook createWorkbook(String sheetName, String[] headerCellList, List<T> list, Class<T> clazz) {
        //定义工作薄
        Workbook wb = new XSSFWorkbook();

        //表头样式
        CellStyle headerStyle = wb.createCellStyle();
        // 设置单元格对齐方式,水平居中
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置单元格背景色
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        //设置单元格填充方式
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //单元格边框
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        // 设置字体样式
        Font headerFont = wb.createFont();
        // 字体大小
        headerFont.setFontHeightInPoints((short) 12);
        // 字体样式
        headerFont.setFontName("黑体");
        headerFont.setBold(true); //字段加粗
        headerFont.setItalic(true); //字体倾斜
        headerFont.setColor(IndexedColors.RED1.getIndex());// 字体颜色
        headerStyle.setFont(headerFont);


        //创建表格sheet
        Sheet sheet = wb.createSheet(sheetName);


        Field[] fields = clazz.getDeclaredFields();

        // 在sheet中创建表头，行数从0开始
        Row headerRow = sheet.createRow(0);
        if (null != headerCellList && headerCellList.length > 0) {
            for (int i = 0; i < headerCellList.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headerCellList[i]);//表头列赋值
                cell.setCellStyle(headerStyle);//将表头样式应用到表头列上
                // 自动设置宽度
                sheet.autoSizeColumn(i);
            }
        } else { //如果没有表头列数据，则默认按表字段名称创建
            int cellNum = 0;

            for (Field field : fields) {
                String type = field.getGenericType().toString();
                //排除父表列
                if (type.equals("class java.lang.String") || type.equals("class java.lang.Integer")) {
                    Cell cell = headerRow.createCell(cellNum);
                    cell.setCellValue(field.getName());
                    cell.setCellStyle(headerStyle);
                    // 自动设置宽度
                    sheet.autoSizeColumn(cellNum);
                    cellNum++;
                }
            }
        }

        // 数据样式 和表头的样式做一下区分
        CellStyle dataStyle = wb.createCellStyle();
        //单元格边框
        dataStyle.setBorderTop(BorderStyle.THIN);
        dataStyle.setBorderLeft(BorderStyle.THIN);
        dataStyle.setBorderRight(BorderStyle.THIN);
        dataStyle.setBorderBottom(BorderStyle.THIN);
        // 设置居中样式，水平居中
        dataStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置单元格背景色
        dataStyle.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.index);
        //设置单元格填充方式
        dataStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 设置单元格内容自动换行（文字超出列宽自动换行）
//        dataStyle.setWrapText(true);


        //数据行从序号1开始
        try {
            int rowNum = 1;
            for (T t : list) {
                // 默认的行数从0开始，为了统一格式设置从1开始，就是从excel的第二行开始
                Row dataRow = sheet.createRow(rowNum++);
                Integer cellNum = 0;
                for (Field field : fields) {
                    String type = field.getGenericType().toString();
                    String name = field.getName();
                    name = name.substring(0, 1).toUpperCase() + name.substring(1);
                    Cell dataCell = dataRow.createCell(cellNum);
                    //排除父表列
                    if (type.equals("class java.lang.String") || type.equals("class java.lang.Integer")) {
                        Method m = t.getClass().getMethod("get" + name);
                        // 为当前列赋值
                        if (type.equals("class java.lang.String")) {
                            String value = (String) m.invoke(t);
                            dataCell.setCellValue(value);
                        } else {
                            Integer value = (Integer) m.invoke(t);
                            dataCell.setCellValue(value);
                        }
                        //设置数据的样式
                        dataCell.setCellStyle(dataStyle);
                        cellNum++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wb;
    }
}
