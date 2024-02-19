package org.mapledpmlab;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
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
        /*dealCycleList = new ArrayList<>();
        dealCycleList.add(new AranDealCycle(new Aran()));
        dealCycleList.add(new ArchMageFPDealCycle(new ArchMageFP()));
        dealCycleList.add(new ArchMageILDealCycle(new ArchMageIL()));
        dealCycleList.add(new BattleMageDealCycle(new BattleMage()));
        dealCycleList.add(new BishopDealCycle(new Bishop()));
        dealCycleList.add(new BlasterDealCycle(new Blaster()));
        dealCycleList.add(new BowmasterDealCycle(new Bowmaster()));
        dealCycleList.add(new CannonShooterDealCycle(new CannonShooter()));
        dealCycleList.add(new CaptainDealCycle(new Captain()));
        dealCycleList.add(new DarkKnightDealCycle(new DarkKnight()));
        dealCycleList.add(new DemonAvengerDealCycle(new DemonAvenger()));
        dealCycleList.add(new DemonSlayerDealCycle(new DemonSlayer()));
        dealCycleList.add(new DualBladeDealCycle(new DualBlade()));
        dealCycleList.add(new EunwolDealCycle(new Eunwol()));
        dealCycleList.add(new EvanDealCycle(new Evan()));
        dealCycleList.add(new FlameWizardDealCycle(new FlameWizard()));
        dealCycleList.add(new HeroDealCycle(new Hero()));
        dealCycleList.add(new LuminousDealCycle(new Luminous()));
        dealCycleList.add(new MarksmanDealCycle(new Marksman()));
        dealCycleList.add(new MechanicDealCycle(new Mechanic()));
        dealCycleList.add(new MercedesDealCycle(new Mercedes()));
        dealCycleList.add(new MihileDealCycle(new Mihile()));
        dealCycleList.add(new NightLordDealCycle(new NightLord()));
        dealCycleList.add(new NightWalkerDealCycle(new NightWalker()));
        dealCycleList.add(new PaladinDealCycle(new Paladin()));
        dealCycleList.add(new PathFinderDealCycle(new Pathfinder()));
        dealCycleList.add(new PhantomDealCycle(new Phantom()));
        dealCycleList.add(new ShadowerDealCycle(new Shadower()));
        dealCycleList.add(new SoulMasterDealCycle(new SoulMaster()));
        dealCycleList.add(new StrikerDealCycle(new Striker()));
        dealCycleList.add(new ViperDealCycle(new Viper()));
        dealCycleList.add(new WildHunterDealCycle(new WildHunter()));
        dealCycleList.add(new WindBreakerDealCycle(new WindBreaker()));
        dealCycleList.add(new XenonDealCycle(new Xenon()));*/
        BlasterDealCycle blasterDealCycle = new BlasterDealCycle(new Blaster());
        blasterDealCycle.applyDoping();
        blasterDealCycle.print();
        //this.exportExcel();
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
        xssfSheet.createFreezePane(1, 1);

        CellStyle cellStyle = xssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setWrapText(true);

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
            xssfSheet.setDefaultColumnWidth(50);
            dealCycle.applyDoping();

            data = new TreeMap<>();
            data.put("01", new Object[]{
                    "유니온", "링크", "하이퍼스탯", "아티팩트", "어빌리티"
            });
            data.put("02", new Object[]{
                    dealCycle.getJob().getUnion().getDescription(),
                    dealCycle.getJob().getLinkListStr(),
                    dealCycle.getJob().getHyper().getDescription(),
                    dealCycle.getJob().getArtifact().getDescription(),
                    dealCycle.getJob().getAbility().getDescription()
            });

            int colNum = 3;
            data.put("03", new Object[]{});
            colNum = colNum + 1;

            data.put("04", new Object[]{
                    "공격스킬이름", "사용횟수", "딜량", "점유율", "기타정보"
            });
            colNum = 5;
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
            data.put(String.valueOf(i + 2), dealCycleList.get(i).getObject());
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

        Row row = xssfSheet.createRow(rownum);
        row.setHeightInPoints(100.0f);
        xssfSheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 0, 6));
        Cell cell = row.createCell(0);
        cell.setCellValue("1제네4카5앜9칠흑2여명2칠요 / 쌍레 정옵 5줄 / 무기추옵 1추+보공 / 방어구 및 장신구 22성, 주흔작 / 펫장비 프펫공, 프악마 / " +
                "\n예티X핑크빈 칭호 / 모자 쿨감뚝일 경우 2초 + 18%, 에디 1초 + 6% / 유니온 8500 및 주요 캐릭터(은월, 메르세데스 등) 250레벨, 그 외 200레벨 / " +
                "\n캐릭터레벨 275 / 아케인포스 1320, 어센틱포스 200 / 몬스터라이프 40레벨 풀조합 / 길드스킬 45포인트 / " +
                "\n영메, 반빨별, 장비 명장, 익스트림 레드 및 블루, 길축, 우뿌, 유힘, 슈퍼파워, 붕뿌, 향산된 10단계 물약 / 어빌 레유유 최대옵션 / " +
                "\n리레 4렙, 웨퍼 4렙 사용(스위칭) / 리레딜은 6차 포함하여 측정 / 최종뎀 고려 X / 히어로, 팔라딘 - 두손검 착용 / 마법사 및 섀도어 20성 방패 착용 / " +
                "\n듀얼블레이드 22성 아케인 블레이드 착용, 데몬 직업군 루포실 착용 / 하이퍼 스킬은 사냥기를 제외하고 선택 / 몬스터 방어율 300% / 렙뻥, 포뻥 미적용");
        cell.setCellStyle(cellStyle);
        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);
        cell = row.createCell(2);
        cell.setCellStyle(cellStyle);
        cell = row.createCell(3);
        cell.setCellStyle(cellStyle);
        cell = row.createCell(4);
        cell.setCellStyle(cellStyle);
        cell = row.createCell(5);
        cell.setCellStyle(cellStyle);
        cell = row.createCell(6);
        cell.setCellStyle(cellStyle);

        try {
            FileOutputStream out = new FileOutputStream(new File(filePath, fileNm));
            xssfWorkbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
