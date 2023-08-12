package org.mapledpmlab;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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
        dealCycleList.add(new DarkKnightDealCycle(new DarkKnight()));
        //dealCycleList.add(new DualBladeDealCycle(new DualBlade()));
        dealCycleList.add(new HeroDealCycle(new Hero()));
        dealCycleList.add(new MarksmanDealCycle(new Marksman()));
        dealCycleList.add(new NightLordDealCycle(new NightLord()));
        dealCycleList.add(new PaladinDealCycle(new Paladin()));
        dealCycleList.add(new PathFinderDealCycle(new Pathfinder()));
        dealCycleList.add(new ShadowerDealCycle(new Shadower()));
        ArchMageFPDealCycle archMageFPDealCycle = new ArchMageFPDealCycle(new ArchMageFP());
        ArchMageILDealCycle archMageILDealCycle = new ArchMageILDealCycle(new ArchMageIL());
        BishopDealCycle bishopDealCycle = new BishopDealCycle(new Bishop());
        BowmasterDealCycle bowmasterDealCycle = new BowmasterDealCycle(new Bowmaster());
        DarkKnightDealCycle darkKnightDealCycle = new DarkKnightDealCycle(new DarkKnight());
        DualBladeDealCycle dualBladeDealCycle = new DualBladeDealCycle(new DualBlade());
        HeroDealCycle heroDealCycle = new HeroDealCycle(new Hero());
        MarksmanDealCycle marksmanDealCycle = new MarksmanDealCycle(new Marksman());
        NightLordDealCycle nightLordDealCycle = new NightLordDealCycle(new NightLord());
        PaladinDealCycle paladinDealCycle = new PaladinDealCycle(new Paladin());
        PathFinderDealCycle pathFinderDealCycle = new PathFinderDealCycle(new Pathfinder());
        ShadowerDealCycle shadowerDealCycle = new ShadowerDealCycle(new Shadower());
        Long totalDamage=0L;
        //for (int i=0;i<10000;i++)
        dualBladeDealCycle.print();
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
