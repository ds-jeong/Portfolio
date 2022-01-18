package com.inface.infaceCBP.utils;


import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.text.SimpleDateFormat;

public class ExcelCellRef {

    /**
     * Cell에 해당하는 Column Name을 가져온다(A,B,C..)
     * 만약 Cell이 Null이라면 int cellIndex의 값으로
     * Column Name을 가져온다.
     * @param cell
     * @param cellIndex
     * @return
     */
    public static String getName(Cell cell, int cellIndex) {
        int cellNum = 0;
        if(cell != null) {
            cellNum = cell.getColumnIndex();
        }
        else {
            cellNum = cellIndex;
        }

        return CellReference.convertNumToColString(cellNum);
    }

    @SuppressWarnings("deprecation")
    public static String getValue(Cell cell) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String value = "";
        switch (cell.getCellType()){
            case XSSFCell.CELL_TYPE_FORMULA:
                value = cell.getCellFormula();
                break;
            case XSSFCell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)){ // 숫자- 날짜 타입이다.
                    value = formatter.format(cell.getDateCellValue());
                }else{ // 숫자 타입
                    Integer i = (int)cell.getNumericCellValue(); // 리턴타입이 double 임. integer로 형변환 해주고
                    value = i.toString(); // integer 로 형변환된 값을 String 으로 받아서 value값에 넣어준다.
                }
                // 숫자일 경우, String형으로 변경하여 값을 읽는다.
                            /*cell.setCellType( HSSFCell.CELL_TYPE_STRING );
                            value = cell.getStringCellValue();*/
                break;
            case XSSFCell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case XSSFCell.CELL_TYPE_BLANK:
                //value = cell.getBooleanCellValue()+"";
                value = " ";
                break;
            case XSSFCell.CELL_TYPE_ERROR:
                value = cell.getErrorCellValue()+"";
                break;
        }
        //아래코드로는 날짜형식 Cell이 숫자로 넘어오고, 숫자형식에는 .0이 붙여서 데이터가넘어오므로, 위 코드로 변경 *2022-01-18 수정
       /* if(cell == null) {
            value = "";
        }
        else {
            if( cell.getCellType() == Cell.CELL_TYPE_FORMULA ) {
                value = cell.getCellFormula();
            }
            else if( cell.getCellType() == Cell.CELL_TYPE_NUMERIC ) {
                value = cell.getNumericCellValue() + "";
            }
            else if( cell.getCellType() == Cell.CELL_TYPE_STRING ) {
                value = cell.getStringCellValue();
            }
            else if( cell.getCellType() == Cell.CELL_TYPE_BOOLEAN ) {
                value = cell.getBooleanCellValue() + "";
            }
            else if( cell.getCellType() == Cell.CELL_TYPE_ERROR ) {
                value = cell.getErrorCellValue() + "";
            }
            else if( cell.getCellType() == Cell.CELL_TYPE_BLANK ) {
                value = "";
            }
            else {
                value = cell.getStringCellValue();
            }
        }
*/
        return value;
    }
}
