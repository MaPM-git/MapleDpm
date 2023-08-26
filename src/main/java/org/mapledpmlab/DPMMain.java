package org.mapledpmlab;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mapledpmlab.type.dealcycle.*;
import org.mapledpmlab.type.job.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class DPMMain {

    List<DealCycle> dealCycleList;

    public DPMMain() {
        init();
    }

    public void init() {
        dealCycleList = new ArrayList<>();
        dealCycleList.add(new ArchMageFPDealCycle(new ArchMageFP()));
        dealCycleList.add(new ArchMageILDealCycle(new ArchMageIL()));
        dealCycleList.add(new BishopDealCycle(new Bishop()));
        dealCycleList.add(new BowmasterDealCycle(new Bowmaster()));
        dealCycleList.add(new CannonShooterDealCycle(new CannonShooter()));
        dealCycleList.add(new CaptainDealCycle(new Captain()));
        dealCycleList.add(new DarkKnightDealCycle(new DarkKnight()));
        dealCycleList.add(new DualBladeDealCycle(new DualBlade()));
        dealCycleList.add(new HeroDealCycle(new Hero()));
        dealCycleList.add(new MarksmanDealCycle(new Marksman()));
        dealCycleList.add(new NightLordDealCycle(new NightLord()));
        dealCycleList.add(new PaladinDealCycle(new Paladin()));
        dealCycleList.add(new PathFinderDealCycle(new Pathfinder()));
        dealCycleList.add(new ShadowerDealCycle(new Shadower()));
        dealCycleList.add(new ViperDealCycle(new Viper()));
        this.exportExcel();
    }

    public void exportExcel() {
        String filePath = "C:\\Users\\이원우\\Desktop\\MapleDpm";
        String fileNm = "MapleStory DPM.xlsx";

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("스펙 정리(도핑 전)");
        xssfSheet.setDefaultColumnWidth(15);
        xssfSheet.setColumnWidth(1, 3000);
        xssfSheet.setColumnWidth(2, 3000);
        xssfSheet.setColumnWidth(3, 3000);
        xssfSheet.setColumnWidth(5, 3000);
        xssfSheet.setColumnWidth(6, 3000);
        xssfSheet.setColumnWidth(7, 3000);
        xssfSheet.setColumnWidth(9, 3000);
        xssfSheet.setColumnWidth(19, 3000);

        CellStyle cellStyle = xssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);

        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{
                "직업", "무기상수", "숙련도", "레벨", "메용O주스탯", "메용X주스탯", "AP",
                "부스탯1", "부스탯2", "뒷스공", "데미지", "보스데미지   ", "방어율무시", "크리티컬데미지",
                "크리티컬확률", "장비공격력%", "무기총공격력", "%미적용주스탯", "버프지속시간",
                "재사용", "쿨타임감소", "최종데미지"
        });
        for (int i = 0; i < dealCycleList.size(); i++) {
            data.put(String.valueOf(i + 2), dealCycleList.get(i).getJob().getOpject());
        }

        Set<String> keyset = data.keySet();
        int rownum = 0;

        for (String key : keyset) {
            Row row = xssfSheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object o : objArr) {
                Cell cell = row.createCell(cellnum++);
                cell.setCellStyle(cellStyle);
                if (o instanceof String) {
                    cell.setCellValue((String) o);
                } else if (o instanceof Long) {
                    cell.setCellValue((Long) o);
                } else if (o instanceof Double) {
                    cell.setCellValue((Double) o);
                }
            }
        }

        for (DealCycle dealCycle : dealCycleList) {
            xssfSheet = xssfWorkbook.createSheet(dealCycle.getJob().getName());
            xssfSheet.setDefaultColumnWidth(20);
            xssfSheet.setColumnWidth(0, 10000);
            xssfSheet.setColumnWidth(1, 4000);
            xssfSheet.setColumnWidth(3, 5000);
            xssfSheet.setColumnWidth(4, 10000);
            dealCycle.applyDoping();

            data = new TreeMap<>();
            data.put("01", new Object[]{
                    "공격스킬이름", "사용횟수", "딜량", "점유율", "기타정보"
            });
            int colNum = 2;
            for (int i = colNum; i < dealCycle.getAttackSkillList().size() + colNum; i++) {
                String tmp = String.valueOf(i);
                if (tmp.length() == 1) {
                    tmp = "0" + tmp;
                }
                data.put(tmp, dealCycle.getAttackSkillList().get(i - colNum).getOpject());
            }

            colNum = colNum + dealCycle.getAttackSkillList().size();
            data.put(String.valueOf(colNum), new Object[]{});
            colNum = colNum + 1;

            data.put(String.valueOf(colNum), new Object[]{
                    "공격스킬이름", "", "", "", "기타정보"
            });

            colNum = colNum + 1;
            for (int i = colNum; i < dealCycle.getDelaySkillList().size() + colNum; i++) {
                data.put(String.valueOf(i), dealCycle.getDelaySkillList().get(i - colNum).getOpject());
            }
            colNum = colNum + dealCycle.getDelaySkillList().size();
            data.put(String.valueOf(colNum), new Object[]{});
            colNum = colNum + 1;
            data.put(String.valueOf(colNum), new Object[]{
                    "버프스킬이름", "", "", "", "기타정보"
            });
            colNum = colNum + 1;
            for (int i = colNum; i < dealCycle.getBuffSkillList().size() + colNum; i++) {
                data.put(String.valueOf(i), dealCycle.getBuffSkillList().get(i - colNum).getOpject());
            }

            keyset = data.keySet();
            rownum = 0;

            for (String key : keyset) {
                Row row = xssfSheet.createRow(rownum++);
                Object[] objArr = data.get(key);
                int cellnum = 0;
                for (Object o : objArr) {
                    Cell cell = row.createCell(cellnum++);
                    cellStyle.setWrapText(true);
                    cell.setCellStyle(cellStyle);
                    if (o instanceof String) {
                        cell.setCellValue((String) o);
                    } else if (o instanceof Long) {
                        cell.setCellValue((Long) o);
                    } else if (o instanceof Double) {
                        cell.setCellValue((Double) o);
                    }
                }
            }
        }

        xssfSheet = xssfWorkbook.createSheet("DPM");
        xssfSheet.setDefaultColumnWidth(20);

        data = new TreeMap<>();
        data.put("1", new Object[]{
                "직업이름", "DPM", "DPM 배율", "리레딜", "리레딜 배율", "40초 딜", "40초딜 배율"
        });
        for (int i = 0; i < dealCycleList.size(); i++) {
            data.put(String.valueOf(i + 2), dealCycleList.get(i).getOpject());
        }

        keyset = data.keySet();
        rownum = 0;

        for (String key : keyset) {
            Row row = xssfSheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object o : objArr) {
                Cell cell = row.createCell(cellnum++);
                cell.setCellStyle(cellStyle);
                if (o instanceof String) {
                    if (((String) o).charAt(0) == '=') {
                        String formula = (String) o;
                        formula = formula.substring(1);
                        cell.setCellFormula(formula);
                    } else {
                        cell.setCellValue((String) o);
                    }
                } else if (o instanceof Long) {
                    cell.setCellValue((Long) o);
                } else if (o instanceof Double) {
                    cell.setCellValue((Double) o);
                }
            }
        }

        try {
            FileOutputStream out = new FileOutputStream(new File(filePath, fileNm));
            xssfWorkbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
