package com.xiekc.vhr.utils;

import com.xiekc.vhr.bean.*;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Kecheng Xie
 * @since: 2019-11-19 19:37
 **/
public class POIUtils {
    public static ResponseEntity<byte[]> employee2Excel(List<Employee> list) {
        // 1.创建一个Excel文档
        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight((short)12);
        // font.setFontName();

        // 2.创建文档摘要
        workbook.createInformationProperties();
        // 3.获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        // 文档类别
        docInfo.setCategory("员工信息");
        // 文档管理员
        docInfo.setManager("xiekc");
        // 公司信息
        docInfo.setCompany("www.xiekc.com");
        // 4.获取文档摘要信息
        SummaryInformation summInfo = workbook.getSummaryInformation();
        // 文档标题
        summInfo.setTitle("员工信息表");
        // 文档作者
        summInfo.setAuthor("xiekc");
        // 文档备注
        summInfo.setComments("本文档由xiekc提供");

        // 5.创建样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        HSSFCellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFSheet sheet = workbook.createSheet("员工信息表");

        //设置每一列的宽度
        sheet.setColumnWidth(0, 5 * 256);
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 12 * 256);
        sheet.setColumnWidth(3, 5 * 256);
        sheet.setColumnWidth(4, 5 * 256);
        sheet.setColumnWidth(5, 20 * 256);
        sheet.setColumnWidth(6, 10 * 256);
        sheet.setColumnWidth(7, 10 * 256);
        sheet.setColumnWidth(8, 16 * 256);
        sheet.setColumnWidth(9, 10 * 256);
        sheet.setColumnWidth(10, 20 * 256);
        sheet.setColumnWidth(11, 20 * 256);
        sheet.setColumnWidth(12, 10 * 256);
        sheet.setColumnWidth(13, 10 * 256);
        sheet.setColumnWidth(14, 10 * 256);
        sheet.setColumnWidth(15, 10 * 256);
        sheet.setColumnWidth(16, 10 * 256);
        sheet.setColumnWidth(17, 10 * 256);
        sheet.setColumnWidth(18, 10 * 256);
        sheet.setColumnWidth(19, 10 * 256);
        sheet.setColumnWidth(20, 10 * 256);
        sheet.setColumnWidth(21, 10 * 256);
        sheet.setColumnWidth(22, 10 * 256);
        sheet.setColumnWidth(23, 10 * 256);
        sheet.setColumnWidth(24, 20 * 256);

        // 6.创建标题行
        HSSFRow r0 = sheet.createRow(0);

        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("编号");
        c0.setCellStyle(headerStyle);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("姓名");
        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("工号");
        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("性别");
        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("出生日期");
        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("身份证号码");
        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("婚姻状况");
        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("民族");
        HSSFCell c8 = r0.createCell(8);
        c8.setCellStyle(headerStyle);
        c8.setCellValue("籍贯");
        HSSFCell c9 = r0.createCell(9);
        c9.setCellStyle(headerStyle);
        c9.setCellValue("政治面貌");
        HSSFCell c10 = r0.createCell(10);
        c10.setCellStyle(headerStyle);
        c10.setCellValue("电子邮件");
        HSSFCell c11 = r0.createCell(11);
        c11.setCellStyle(headerStyle);
        c11.setCellValue("电话号码");
        HSSFCell c12 = r0.createCell(12);
        c12.setCellStyle(headerStyle);
        c12.setCellValue("联系地址");
        HSSFCell c13 = r0.createCell(13);
        c13.setCellStyle(headerStyle);
        c13.setCellValue("所属部门");
        HSSFCell c14 = r0.createCell(14);
        c14.setCellStyle(headerStyle);
        c14.setCellValue("职位");
        HSSFCell c15 = r0.createCell(15);
        c15.setCellStyle(headerStyle);
        c15.setCellValue("职称");
        HSSFCell c16 = r0.createCell(16);
        c16.setCellStyle(headerStyle);
        c16.setCellValue("聘用形式");
        HSSFCell c17 = r0.createCell(17);
        c17.setCellStyle(headerStyle);
        c17.setCellValue("入职日期");
        HSSFCell c18 = r0.createCell(18);
        c18.setCellStyle(headerStyle);
        c18.setCellValue("转正日期");
        HSSFCell c19 = r0.createCell(19);
        c19.setCellStyle(headerStyle);
        c19.setCellValue("合同起始日期");
        HSSFCell c20 = r0.createCell(20);
        c20.setCellStyle(headerStyle);
        c20.setCellValue("合同截止日期");
        HSSFCell c21 = r0.createCell(21);
        c21.setCellStyle(headerStyle);
        c21.setCellValue("合同期限");
        HSSFCell c22 = r0.createCell(22);
        c22.setCellStyle(headerStyle);
        c22.setCellValue("最高学历");
        HSSFCell c23 = r0.createCell(23);
        c23.setCellStyle(headerStyle);
        c23.setCellValue("专业");
        HSSFCell c24 = r0.createCell(24);
        c24.setCellStyle(headerStyle);
        c24.setCellValue("毕业院校");

        for (int i = 0; i < list.size(); i++) {
            Employee employee = list.get(i);
            HSSFRow row = sheet.createRow(i + 1);

            row.createCell(0).setCellValue(employee.getId());
            row.createCell(1).setCellValue(employee.getName());
            row.createCell(2).setCellValue(employee.getWorkID());
            row.createCell(3).setCellValue(employee.getGender());
            HSSFCell cell4 = row.createCell(4);
            cell4.setCellStyle(dateStyle);
            cell4.setCellValue(employee.getBirthday());
            row.createCell(5).setCellValue(employee.getIdCard());
            row.createCell(6).setCellValue(employee.getWedlock());
            row.createCell(7).setCellValue(employee.getNation().getName());
            row.createCell(8).setCellValue(employee.getNativePlace());
            row.createCell(9).setCellValue(employee.getPoliticsStatus().getName());
            row.createCell(10).setCellValue(employee.getEmail());
            row.createCell(11).setCellValue(employee.getPhone());
            row.createCell(12).setCellValue(employee.getAddress());
            row.createCell(13).setCellValue(employee.getDepartment().getName());
            row.createCell(14).setCellValue(employee.getPosition().getName());
            row.createCell(15).setCellValue(employee.getJobLevel().getName());
            row.createCell(16).setCellValue(employee.getEngageForm());
            HSSFCell cell17 = row.createCell(17);
            cell17.setCellValue(employee.getBeginDate());
            cell17.setCellStyle(dateStyle);
            HSSFCell cell18 = row.createCell(18);
            cell18.setCellValue(employee.getConversionTime());
            cell18.setCellStyle(dateStyle);
            HSSFCell cell19 = row.createCell(19);
            cell19.setCellValue(employee.getBeginContract());
            cell19.setCellStyle(dateStyle);
            HSSFCell cell20 = row.createCell(20);
            cell20.setCellValue(employee.getEndContract());
            cell20.setCellStyle(dateStyle);
            HSSFCell cell21 = row.createCell(21);
            cell21.setCellValue(employee.getContractTerm());
            // cell21.setCellStyle(dateStyle);
            row.createCell(22).setCellValue(employee.getTiptopDegree());
            row.createCell(23).setCellValue(employee.getSpecialty());
            row.createCell(24).setCellValue(employee.getSchool());
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachmeent", new String("员工表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);


    }

    public static List<Employee> excel2Employee(MultipartFile file, List<Nation> allNations, List<PoliticsStatus> allPoliticsStatus, List<Department> allDepartments, List<Position> allPositions, List<JobLevel> allJobLevels) {
        ArrayList<Employee> list = new ArrayList<>();
        Employee employee = null;

        try {
            // 1.创建一个workbook对象
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            // 2.获取表单的数量
            int numberOfSheets = workbook.getNumberOfSheets();

            for (int i = 0; i < numberOfSheets; i++) {
                // 3.获取表单
                HSSFSheet sheet = workbook.getSheetAt(i);
                // 4.获取行数
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                // 5.遍历行
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        //标题行不解析
                        continue;
                    }
                    // 6.获取行
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        //防止中间有空行
                        continue;
                    }
                    // 7.获取列数
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    employee = new Employee();

                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        if (cell.getCellType() ==null){
                            System.out.println("java.lang.NullPointerException: null异常");
                        }
                        switch (cell.getCellType()) {
                            case STRING:
                                String cellValue = cell.getStringCellValue();
                                switch (k) {
                                    case 1:
                                        employee.setName(cellValue);
                                        break;
                                    case 2:
                                        employee.setWorkID(cellValue);
                                        break;
                                    case 3:
                                        employee.setGender(cellValue);
                                        break;

                                    case 5:
                                        employee.setIdCard(cellValue);
                                        break;
                                    case 6:
                                        employee.setWedlock(cellValue);
                                        break;
                                    case 7:
                                        for (Nation nation : allNations) {
                                            if (cellValue.equals(nation.getName())){
                                                employee.setNationId(nation.getId()); //民族
                                                break;
                                            }
                                        }
                                        break;
                                    case 8:
                                        employee.setNativePlace(cellValue);
                                        break;
                                    case 9:
                                        for (PoliticsStatus politicsStatus : allPoliticsStatus) {
                                            if (cellValue.equals(politicsStatus.getName())){
                                                employee.setPoliticId(politicsStatus.getId()); //民族
                                                break;
                                            }
                                        }
                                        break;
                                    case 10:
                                        employee.setEmail(cellValue);
                                        break;
                                    case 11:
                                        employee.setPhone(cellValue);
                                        break;
                                    case 12:
                                        employee.setAddress(cellValue);
                                        break;
                                    case 13:
                                        for (Department department : allDepartments) {
                                            if (cellValue.equals(department.getName())){
                                                employee.setDepartmentId(department.getId());
                                                break;
                                            }
                                        }

                                        employee.setDepartmentName(cellValue); //部门
                                        break;
                                    case 14:
                                        for (Position position : allPositions) {
                                            if (cellValue.equals(position.getName())){
                                                employee.setPosId(position.getId());
                                                break;
                                            }
                                        }

                                        //职位
                                        break;
                                    case 15:
                                        for (JobLevel jobLevel : allJobLevels) {
                                            if (cellValue.equals(jobLevel.getName())){
                                                employee.setJobLevelId(jobLevel.getId());
                                                break;
                                            }
                                        }

                                        //职称
                                        break;
                                    case 16:
                                        employee.setEngageForm(cellValue);
                                        break;

                                    //    学历
                                    case 22:
                                        employee.setTiptopDegree(cellValue);
                                        break;
                                    //    专业
                                    case 23:
                                        employee.setSpecialty(cellValue);
                                        break;
                                    case 24:
                                        //毕业院校
                                        employee.setSchool(cellValue);
                                        break;
                                    default:
                                        break;
                                }


                            default:
                                switch (k) {
                                    case 4:
                                        employee.setBirthday(cell.getDateCellValue());
                                        break;
                                    case 17:
                                        //入职日期
                                        employee.setBeginDate(cell.getDateCellValue());
                                        break;
                                    case 18:
                                        //转正日期
                                        employee.setConversionTime(cell.getDateCellValue());
                                        break;
                                    case 19:
                                        //合同起始日期
                                        employee.setBeginContract(cell.getDateCellValue());
                                        break;
                                    case 20:
                                        //合同截止日期
                                        employee.setEndContract(cell.getDateCellValue());
                                        break;
                                    case 21:
                                        //合同期限
                                        employee.setContractTerm(cell.getNumericCellValue());
                                        break;
                                    default:
                                        break;
                                }
                        }

                    }
                    list.add(employee);
                }
                // list.add(employee);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
