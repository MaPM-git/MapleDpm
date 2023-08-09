package org.mapledpmlab;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mapledpmlab.type.dealcycle.*;
import org.mapledpmlab.type.job.*;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;

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
        dealCycleList.add(new BowmasterCycle(new Bowmaster()));
        dealCycleList.add(new DarkKnightDealCycle(new DarkKnight()));
        dealCycleList.add(new HeroDealCycle(new Hero()));
        dealCycleList.add(new MarksmanCycle(new Marksman()));
        dealCycleList.add(new PaladinDealCycle(new Paladin()));
        dealCycleList.add(new PathFinderCycle(new Pathfinder()));
        ArchMageFPDealCycle archMageFPDealCycle = new ArchMageFPDealCycle(new ArchMageFP());
        ArchMageILDealCycle archMageILDealCycle = new ArchMageILDealCycle(new ArchMageIL());
        BishopDealCycle bishopDealCycle = new BishopDealCycle(new Bishop());
        BowmasterCycle bowmasterCycle = new BowmasterCycle(new Bowmaster());
        DarkKnightDealCycle darkKnightDealCycle = new DarkKnightDealCycle(new DarkKnight());
        HeroDealCycle heroDealCycle = new HeroDealCycle(new Hero());
        MarksmanCycle marksmanCycle = new MarksmanCycle(new Marksman());
        PaladinDealCycle paladinDealCycle = new PaladinDealCycle(new Paladin());
        PathFinderCycle pathFinderCycle = new PathFinderCycle(new Pathfinder());
        Long totalDamage=0L;
        //for (int i=0;i<10000;i++)
        totalDamage += pathFinderCycle.getTotalDamage();
        Double share = 0.0;
        Double testShare = 0.0;
        for (AttackSkill as : pathFinderCycle.getAttackSkillList()) {
            if (as.getCumulativeDamage() == 0) {
                continue;
            }
            System.out.println(as);
            System.out.println(as.getUseCount());
            System.out.println(as.getCumulativeDamage());
            share = as.getCumulativeDamage().doubleValue() / totalDamage * 100;
            System.out.println(share + "%");
            testShare += share;
        }
        System.out.println(testShare);
        System.out.println(totalDamage);
        /*
        for (int i =1;i<4950;i++){
            for (int j=1;j<4950;j++){
                if ((i*8 + j*12) == 4948){
                    System.out.println("-----------");
                    System.out.println(i);
                    System.out.println(j);
                }
            }
        }
        */
    }

    public void exportExcel() {
        String filePath = "C:\\Users\\이원우\\Desktop\\MapleDpm";
        String fileNm = "MapleStory DPM.xlsx";

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("스펙 정리");

        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{
                "직업", "무기상수", "숙련도", "레벨", "메용O 주스탯", "메용X 주스탯", "AP",
                "부스탯1", "부스탯2", "뒷스공", "데미지", "보스 데미지", "방어율 무시", "크리티컬 데미지",
                "크리티컬 확률", "장비아이템 공격력%", "무기 총공격력", "%미적용 주스탯", "버프지속시간",
                "재사용", "쿨타임 감소"
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
                if (o instanceof String) {
                    cell.setCellValue((String) o);
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
