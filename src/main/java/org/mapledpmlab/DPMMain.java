package org.mapledpmlab;

import com.aspose.html.converters.Converter;
import com.aspose.html.dom.svg.SVGDocument;
import com.aspose.html.rendering.image.ImageFormat;
import com.aspose.html.saving.ImageSaveOptions;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xssf.usermodel.*;
import org.mapledpmlab.type.JobContinuous.*;
import org.mapledpmlab.type.dealcyclesolo.*;
import org.mapledpmlab.type.equipment.*;
import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.DuoDealCycle;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.job.*;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class DPMMain {

    List<DealCycle> soloDealCycleList;
    List<DuoDealCycle> duoDealCycleList;

    public DPMMain() {
        init();
    }

    public void init() {
        soloDealCycleList = new ArrayList<>();

        soloDealCycleList.add(new AdeleDealCycle(new Adele()));
        soloDealCycleList.add(new AdeleContinuousDealCycle(new AdeleContinuous()));
        soloDealCycleList.add(new Adele2MinContinuousDealCycle(new AdeleContinuous()));
        soloDealCycleList.add(new AngelicBusterDealCycle(new AngelicBuster()));
        soloDealCycleList.add(new AngelicBuster4RingDealCycle(new AngelicBuster()));
        soloDealCycleList.add(new AranDealCycle(new Aran()));
        soloDealCycleList.add(new ArchMageFPDealCycle(new ArchMageFP()));
        soloDealCycleList.add(new ArchMageFPContinuousDealCycle(new ArchMageFPContinuous()));
        soloDealCycleList.add(new ArchMageILDealCycle(new ArchMageIL()));
        soloDealCycleList.add(new ArchMageILContinuousDealCycle(new ArchMageILContinuous()));
        soloDealCycleList.add(new ArkDealCycle(new Ark()));
        soloDealCycleList.add(new BattleMageDealCycle(new BattleMage()));
        soloDealCycleList.add(new BattleMageContinuousDealCycle(new BattleMageContinuous()));
        soloDealCycleList.add(new Bishop2DealCycle(new Bishop()));
        soloDealCycleList.add(new Bishop3DealCycle(new Bishop()));
        soloDealCycleList.add(new Bishop2ContinuousDealCycle(new BishopContinuous()));
        soloDealCycleList.add(new Blaster480DealCycle(new Blaster()));
        soloDealCycleList.add(new Blaster510DealCycle(new Blaster()));
        soloDealCycleList.add(new Blaster540DealCycle(new Blaster()));
        soloDealCycleList.add(new Blaster480ContinuousDealCycle(new BlasterContinuous()));
        soloDealCycleList.add(new Blaster510ContinuousDealCycle(new BlasterContinuous()));
        soloDealCycleList.add(new Blaster540ContinuousDealCycle(new BlasterContinuous()));
        soloDealCycleList.add(new BowmasterDealCycle(new Bowmaster()));
        soloDealCycleList.add(new BowmasterContinuousDealCycle(new BowmasterContinuous()));
        soloDealCycleList.add(new CadenaDealCycle(new Cadena()));
        soloDealCycleList.add(new CadenaContinuousDealCycle(new CadenaContinuous()));
        soloDealCycleList.add(new CannonShooter3DealCycle(new CannonShooter()));
        soloDealCycleList.add(new CaptainDealCycle(new Captain()));
        soloDealCycleList.add(new CaptainContinuousDealCycle(new CaptainContinuous()));
        soloDealCycleList.add(new DarkKnightDealCycle(new DarkKnight()));
        soloDealCycleList.add(new DarkKnightContinuousDealCycle(new DarkKnightContinuous()));
        soloDealCycleList.add(new DarkKnight2MinContinuousDealCycle(new DarkKnightContinuous()));
        soloDealCycleList.add(new DemonAvenger29DealCycle(new DemonAvenger()));
        soloDealCycleList.add(new DemonAvenger30DealCycle(new DemonAvenger()));
        soloDealCycleList.add(new DemonAvenger29ContinuousDealCycle(new DemonAvengerContinuous()));
        soloDealCycleList.add(new DemonAvenger30ContinuousDealCycle(new DemonAvengerContinuous()));
        soloDealCycleList.add(new DemonSlayerDealCycle(new DemonSlayerRuin()));
        soloDealCycleList.add(new DemonSlayerDealCycle(new DemonSlayerNormal()));
        soloDealCycleList.add(new DemonSlayerContinuousDealCycle(new DemonSlayerRuinContinuous()));
        soloDealCycleList.add(new DemonSlayerContinuousDealCycle(new DemonSlayerNormalContinuous()));
        soloDealCycleList.add(new DualBladeDealCycle(new DualBlade()));
        soloDealCycleList.add(new EunwolCancelDealCycle(new Eunwol()));
        soloDealCycleList.add(new EunwolDealCycle(new Eunwol()));
        soloDealCycleList.add(new Eunwol4RingCancelDealCycle(new Eunwol()));
        soloDealCycleList.add(new Eunwol4RingDealCycle(new Eunwol()));
        soloDealCycleList.add(new EunwolContinuousCancelDealCycle(new EunwolContinuous()));
        soloDealCycleList.add(new EunwolContinuousDealCycle(new EunwolContinuous()));
        soloDealCycleList.add(new EvanDealCycle(new Evan()));
        soloDealCycleList.add(new EvanDealCycle(new Evan5()));
        soloDealCycleList.add(new EvanContinuousDealCycle(new EvanContinuous()));
        soloDealCycleList.add(new Evan5ContinuousDealCycle(new Evan5Continuous()));
        soloDealCycleList.add(new Evan5Cool2MinContinuousDealCycle(new Evan5Continuous()));
        soloDealCycleList.add(new FlameWizard2DealCycle(new FlameWizard()));
        soloDealCycleList.add(new FlameWizard2ContinuousDealCycle(new FlameWizardContinuous()));
        soloDealCycleList.add(new FlameWizard3DealCycle(new FlameWizard()));
        soloDealCycleList.add(new FlameWizard3ContinuousDealCycle(new FlameWizardContinuous()));
        soloDealCycleList.add(new HeroDealCycle(new Hero()));
        soloDealCycleList.add(new Hero5DealCycle(new Hero5()));
        soloDealCycleList.add(new HoYoungDealCycle(new HoYoung()));
        soloDealCycleList.add(new IlliumDealCycle(new Illium()));
        soloDealCycleList.add(new Illium2MinDealCycle(new Illium()));
        soloDealCycleList.add(new IlliumContinuousDealCycle(new IlliumContinuous()));
        soloDealCycleList.add(new Illium2MinContinuousDealCycle(new IlliumContinuous()));
        soloDealCycleList.add(new KainDealCycle(new Kain()));
        soloDealCycleList.add(new KainDealCycle(new Kain5()));
        soloDealCycleList.add(new KaiserDealCycle(new KaiserStat()));
        soloDealCycleList.add(new KaiserDealCycle(new Kaiser2()));
        soloDealCycleList.add(new KaiserDealCycle(new Kaiser5()));
        soloDealCycleList.add(new KaiserContinuousDealCycle(new KaiserStatContinuous()));
        soloDealCycleList.add(new KaiserContinuousDealCycle(new Kaiser2Continuous()));
        soloDealCycleList.add(new KaiserContinuousDealCycle(new Kaiser5Continuous()));
        soloDealCycleList.add(new KhaliDealCycle(new Khali()));
        soloDealCycleList.add(new KhaliContinuousDealCycle(new KhaliContinuous()));
        soloDealCycleList.add(new KinesisDealCycle(new Kinesis()));
        soloDealCycleList.add(new KinesisContinuousDealCycle(new KinesisContinuous()));
        soloDealCycleList.add(new LaraDealCycle(new Lara()));
        soloDealCycleList.add(new LaraDealCycle(new Lara2()));
        soloDealCycleList.add(new LaraContinuousDealCycle(new LaraContinuous()));
        soloDealCycleList.add(new LaraContinuousDealCycle(new Lara2Continuous()));
        soloDealCycleList.add(new LuminousDealCycle(new Luminous()));
        soloDealCycleList.add(new LuminousContinuousDealCycle(new LuminousContinuous()));
        soloDealCycleList.add(new LuminousDealCycle(new Luminous5()));
        soloDealCycleList.add(new LuminousContinuousDealCycle(new Luminous5Continuous()));
        soloDealCycleList.add(new Luminous2MinContinuousDealCycle(new Luminous5Continuous()));
        soloDealCycleList.add(new MarksmanDealCycle(new Marksman()));
        soloDealCycleList.add(new MarksmanContinuousDealCycle(new MarksmanContinuous()));
        soloDealCycleList.add(new MechanicDealCycle(new Mechanic()));
        soloDealCycleList.add(new MercedesDealCycle(new Mercedes()));
        soloDealCycleList.add(new MercedesContinuousDealCycle(new MercedesContinuous()));
        soloDealCycleList.add(new MercedesContinuousSylphidiaDealCycle(new MercedesContinuous()));
        soloDealCycleList.add(new MihileDealCycle(new Mihile()));
        soloDealCycleList.add(new MihileContinuousDealCycle(new MihileContinuous()));
        soloDealCycleList.add(new NightLordDealCycle(new NightLord()));
        soloDealCycleList.add(new NightLordContinuousDealCycle(new NightLordContinuous()));
        soloDealCycleList.add(new NightLordContinuousDealCycle(new NightLordContinuous1()));
        soloDealCycleList.add(new NightLordContinuousDealCycle(new NightLordContinuous2()));
        soloDealCycleList.add(new NightWalkerDealCycle(new NightWalker()));
        soloDealCycleList.add(new PaladinDealCycle(new Paladin()));
        soloDealCycleList.add(new PaladinDealCycle(new Paladin5()));
        soloDealCycleList.add(new PaladinUnityDealCycle(new Paladin()));
        soloDealCycleList.add(new PathFinderDealCycle(new Pathfinder3()));
        soloDealCycleList.add(new PathFinderDealCycle(new Pathfinder4()));
        soloDealCycleList.add(new PathFinderDealCycle(new Pathfinder5()));
        soloDealCycleList.add(new PathFinderContinuousDealCycle(new Pathfinder3Continuous()));
        soloDealCycleList.add(new PathFinderContinuousDealCycle(new Pathfinder4Continuous()));
        soloDealCycleList.add(new PathFinderContinuousDealCycle(new Pathfinder5Continuous()));
        soloDealCycleList.add(new PhantomDealCycle(new Phantom()));
        soloDealCycleList.add(new PhantomContinuousDealCycle(new PhantomContinuous()));
        soloDealCycleList.add(new ShadowerDealCycle(new Shadower()));
        soloDealCycleList.add(new ShadowerContinuousDealCycle(new ShadowerContinuous()));
        soloDealCycleList.add(new SoulMasterDealCycle(new SoulMaster()));
        soloDealCycleList.add(new StrikerDealCycle(new Striker()));
        soloDealCycleList.add(new StrikerContinuousDealCycle(new StrikerContinuous()));
        soloDealCycleList.add(new ViperDealCycle(new Viper()));
        soloDealCycleList.add(new ViperContinuousDealCycle(new ViperContinuous()));
        soloDealCycleList.add(new WildHunterDealCycle(new WildHunter()));
        soloDealCycleList.add(new WildHunter5DealCycle(new WildHunter5()));
        soloDealCycleList.add(new WindBreakerDealCycle(new WindBreaker()));
        soloDealCycleList.add(new WindBreakerContinuousDealCycle(new WindBreakerContinuous()));
        soloDealCycleList.add(new XenonDealCycle(new Xenon()));
        soloDealCycleList.add(new Xenon2HologramDealCycle(new Xenon()));
        soloDealCycleList.add(new XenonDealCycle(new Xenon5()));
        soloDealCycleList.add(new Xenon2HologramDealCycle(new Xenon5()));
        soloDealCycleList.add(new ZeroDealCycle(new ZeroAlpha()));
        soloDealCycleList.add(new ZeroDealCycle(new ZeroBeta()));
        soloDealCycleList.add(new ZeroContinuousDealCycle(new ZeroAlphaContinuous()));
        soloDealCycleList.add(new ZeroContinuousDealCycle(new ZeroBetaContinuous()));


        /*
        duoDealCycleList = new ArrayList<>();
        duoDealCycleList.add(new TwoBishopDealCycle());
        duoDealCycleList.add(new TwoBishopDealCycle2());
        duoDealCycleList.add(new BishopArchMageILDealCycle());
        duoDealCycleList.add(new BishopArkDealCycle());
        duoDealCycleList.add(new BishopBlasterDealCycle());
        duoDealCycleList.add(new BishopBowmasterDealCycle());
         */

        /*for (DealCycle dealCycle : soloDealCycleList) {
            if (dealCycle.getJob() instanceof Kain5) {
                dealCycle.getJobInfo();
                System.out.println(dealCycle.getJob().getFinalOtherStat1());
                System.out.println(dealCycle.getJob().getFinalOtherStat2());
                break;
            }
        }*/
        this.exportExcel();
    }

    private static void drawActivities(SVGGraphics2D g, DealCycle dealCycle) {
        int y = 50;
        List<Color> colorList = new ArrayList<>();
        colorList.add(Color.blue);
        colorList.add(Color.red);
        colorList.add(Color.black);
        colorList.add(Color.orange);
        colorList.add(Color.cyan);
        colorList.add(Color.darkGray);
        colorList.add(Color.gray);
        colorList.add(Color.green);
        colorList.add(Color.lightGray);
        colorList.add(Color.magenta);
        colorList.add(Color.pink);
        colorList.add(Color.yellow);
        colorList.add(Color.blue);
        colorList.add(Color.red);
        colorList.add(Color.black);
        colorList.add(Color.orange);
        colorList.add(Color.cyan);
        colorList.add(Color.darkGray);
        colorList.add(Color.gray);
        colorList.add(Color.green);
        colorList.add(Color.lightGray);
        colorList.add(Color.magenta);
        colorList.add(Color.pink);
        colorList.add(Color.yellow);
        for (int i = 0; i < dealCycle.getBuffSkillList().size(); i++) {
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString(dealCycle.getBuffSkillList().get(i).getName(), 10, 50 * i + 50);
            g.setColor(colorList.get(i));
            g.setStroke(new BasicStroke(4));
            for (SkillEvent skillEvent : dealCycle.getSkillEventList()) {
                if (skillEvent.getSkill().getClass().getName().equals(dealCycle.getBuffSkillList().get(i).getClass().getName())) {
                    g.drawLine((int) skillEvent.getStart().getTime() / 1000 + 80, 50 * i + 50, (int) skillEvent.getEnd().getTime() / 1000 + 80, 50 * i + 50);
                }
            }
        }
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        for (int i = 0; i < 13; i++) {
            g.drawString(String.valueOf(i), 90 + 60 * i, 50 * dealCycle.getBuffSkillList().size() + 50);
        }
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
        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setWrapText(true);

        DataFormat format = xssfWorkbook.createDataFormat();
        CellStyle numberStyle = xssfWorkbook.createCellStyle();
        numberStyle.setDataFormat(format.getFormat("#,##0"));
        numberStyle.setAlignment(HorizontalAlignment.LEFT);
        numberStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        numberStyle.setBorderBottom(BorderStyle.THIN);
        numberStyle.setBorderLeft(BorderStyle.THIN);
        numberStyle.setBorderRight(BorderStyle.THIN);
        numberStyle.setBorderTop(BorderStyle.THIN);
        numberStyle.setWrapText(true);

        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{
                "직업", "무기상수", "숙련도", "레벨", "주스탯 기본 수치", "주스탯 % 수치", "주스탯 % 미적용 수치",
                "부스탯1 기본 수치", "부스탯1 % 수치", "부스탯1 % 미적용 수치", "부스탯2 기본 수치", "부스탯2 % 수치", "부스탯2 % 미적용 수치", "기본 스공",
                "데미지", "최종 데미지", "보스 데미지", "방어율 무시", "공마 %",
                "크리티컬 확률", "크리티컬 데미지", "재사용 감소", "버프 지속 시간", "재사용 미적용", "속성 내성 무시",
                "상추뎀", "소환수 지속", "아케인 포스", "어센틱 포스", "무기 공마"
        });
        for (int i = 0; i < soloDealCycleList.size(); i++) {
            data.put(String.valueOf(i + 2), soloDealCycleList.get(i).getJob().getOpject());
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

        for (DealCycle dealCycle : soloDealCycleList) {
            if (
                    dealCycle.getJob().getName().equals("제로 - 알파")
                    || dealCycle.getJob().getName().equals("제로 - 알파(컨티)")
            ) {
                continue;
            }
            if (dealCycle.getJob().getName().equals("제로 - 베타")) {
                dealCycle.getJob().setName("제로(리웨)");
            }
            if (dealCycle.getJob().getName().equals("제로 - 베타(컨티)")) {
                dealCycle.getJob().setName("제로(컨티)");
            }
            xssfSheet = xssfWorkbook.createSheet(dealCycle.getJob().getName());
            xssfSheet.setDefaultColumnWidth(50);
            dealCycle.setSoloDealCycle();
            dealCycle.applyDoping();

            data = new TreeMap<>();
            data.put("01", new Object[]{
                    "유니온", "링크", "하이퍼스탯", "아티팩트", "어빌리티"
            });
            data.put("02", new Object[]{
                    dealCycle.getJob().getUnion().getDescription() + dealCycle.getJob().getUnion(),
                    dealCycle.getJob().getLinkListStr(),
                    dealCycle.getJob().getHyper().getDescription() + dealCycle.getJob().getHyper(),
                    dealCycle.getJob().getArtifact().getDescription() + dealCycle.getJob().getArtifact(),
                    dealCycle.getJob().getAbility().getDescription() + dealCycle.getJob().getAbility()
            });

            int colNum = 3;
            data.put("03", new Object[]{});
            colNum = colNum + 1;

            data.put("04", new Object[]{
                    "공격스킬이름", "사용횟수", "타수", "점유율", "기타정보"
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
                    "버프스킬이름", "사용횟수", "시작 시간", "종료 시간", "기타정보"
            });
            colNum = colNum + 1;
            for (int i = colNum; i < dealCycle.getBuffSkillList().size() + colNum; i++) {
                data.put(String.valueOf(i), dealCycle.getBuffSkillList().get(i - colNum).getObject());
            }

            colNum = colNum + dealCycle.getBuffSkillList().size();
            data.put(String.valueOf(colNum), new Object[]{});
            colNum = colNum + 1;

            data.put(String.valueOf(colNum), new Object[]{
                    "스킬 로그"
            });
            colNum = colNum + 1;
            String[] skillLogList = dealCycle.skillLog.split("\n");

            int groupSize = 500;
            int newSize = (skillLogList.length + groupSize - 1) / groupSize;
            String[] mergedList = new String[newSize];

            for (int i = 0; i < newSize; i++) {
                StringBuilder sb = new StringBuilder();
                int start = i * groupSize;
                int end = Math.min(start + groupSize, skillLogList.length);
                for (int j = start; j < end; j++) {
                    sb.append(skillLogList[j]);
                    if (j < end - 1) {
                        sb.append("\n");
                    }
                }
                mergedList[i] = sb.toString();
            }

            for (int i = colNum; i < mergedList.length + colNum; i++) {
                data.put(String.valueOf(i), new Object[]{
                        mergedList[i - colNum]
                });
            }

            colNum = colNum + dealCycle.getBuffSkillList().size();
            data.put(String.valueOf(colNum), new Object[]{});

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
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss.SSS");

            dealCycle.calcDps();
            Object[][] damageLine = new Object[681][2];
            damageLine[0] = new Object[]{"초", "데미지", "15초", simpleDateFormat.format(dealCycle.getRestraintRingStartTime()) + " ~ " + simpleDateFormat.format(dealCycle.getRestraintRingEndTime())};
            for (int i = 0; i < dealCycle.getDpsList().size(); i++) {
                if (i == 0) {
                    damageLine[i + 1] = new Object[]{i + 1, dealCycle.getDpsList().get(i), "40초", simpleDateFormat.format(dealCycle.getRestraintRingStartTime()) + " ~ " + simpleDateFormat.format(dealCycle.getFortyEndTime())};
                } else if (i == 1) {
                    damageLine[i + 1] = new Object[]{i + 1, dealCycle.getDpsList().get(i), "오리진X 15초", simpleDateFormat.format(dealCycle.getOriginXRestraintRingStartTime()) + " ~ " + simpleDateFormat.format(dealCycle.getOriginXRestraintRingEndTime())};
                } else {
                    damageLine[i + 1] = new Object[]{i + 1, dealCycle.getDpsList().get(i)};
                }
            }

            for (Object[] damage : damageLine) {
                Row row = xssfSheet.createRow(rownum++);
                int cellnum = 0;
                for (Object field : damage) {
                    Cell cell = row.createCell(cellnum++);
                    cell.setCellStyle(cellStyle);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    } else if (field instanceof Double) {
                        cell.setCellValue((Double) field);
                    } else if (field instanceof Long) {
                        cell.setCellValue((Long) field);
                        cell.setCellStyle(numberStyle);
                    }
                }
            }

            int skillCnt = dealCycle.getBuffSkillList().size() + dealCycle.getAttackSkillList().size();
            XSSFDrawing drawing = xssfSheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 2, skillCnt + 7, 5, skillCnt + 9);

            XSSFChart chart = drawing.createChart(anchor);
            chart.setTitleText("데미지 그래프");
            chart.setTitleOverlay(false);

            XDDFDataSource<String> xAxis = XDDFDataSourcesFactory.fromStringCellRange(xssfSheet, new CellRangeAddress(skillCnt + mergedList.length + 10, skillCnt + mergedList.length + 689, 0, 0));
            XDDFNumericalDataSource<Double> yAxis = XDDFDataSourcesFactory.fromNumericCellRange(xssfSheet, new CellRangeAddress(skillCnt + mergedList.length + 10, skillCnt + mergedList.length + 689, 1, 1));

            XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
            bottomAxis.setTitle("초");
            XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
            leftAxis.setTitle("데미지");
            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

            XDDFLineChartData lineChartData = (XDDFLineChartData) chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);
            XDDFLineChartData.Series series = (XDDFLineChartData.Series) lineChartData.addSeries(xAxis, yAxis);
            series.setTitle("데미지 그래프", null);
            series.setSmooth(false);
            series.setMarkerStyle(MarkerStyle.CIRCLE);

            chart.plot(lineChartData);

            // 이미지 삽입
            insertImg(xssfWorkbook, xssfSheet, colNum, 3, dealCycle);
        }

        if (duoDealCycleList != null) {
            xssfSheet = xssfWorkbook.createSheet("2인팟");
            xssfSheet.setDefaultColumnWidth(30);
            Object[][] objects = new Object[1][duoDealCycleList.size() * 4 + 1];

            objects[0][0] = "파티 조합";
            for (int i = 0; i < duoDealCycleList.size(); i++) {
                xssfSheet.addMergedRegion(new CellRangeAddress(0, 0, i * 4 + 1, i * 4 + 4));
                objects[0][i * 4 + 1] = duoDealCycleList.get(i).getName();
            }
            rownum = 0;
            for (Object[] object : objects) {
                Row row = xssfSheet.createRow(rownum++);
                int cellnum = 0;
                for (Object field : object) {
                    Cell cell = row.createCell(cellnum++);
                    cell.setCellStyle(cellStyle);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    } else if (field instanceof Double) {
                        cell.setCellValue((Double) field);
                    } else if (field instanceof Long) {
                        cell.setCellValue((Long) field);
                        cell.setCellStyle(numberStyle);
                    }
                }
            }
            for (DuoDealCycle duoDealCycle : duoDealCycleList) {
                int colNum = 1;
                insertImg(xssfWorkbook, xssfSheet, colNum, duoDealCycleList.indexOf(duoDealCycle) * 4 + 1, duoDealCycle.getDealCycle1());
                colNum = 50;
                insertImg(xssfWorkbook, xssfSheet, colNum, duoDealCycleList.indexOf(duoDealCycle) * 4 + 1, duoDealCycle.getDealCycle2());

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss.SSS");

                duoDealCycle.getDealCycle1().calcDps();
                duoDealCycle.getDealCycle2().calcDps();
                Object[][] damageLine = new Object[681][duoDealCycleList.size() * 4 + 1];
                damageLine[0][0] = "초";
                for (int i = 0; i < duoDealCycleList.size(); i++) {
                    damageLine[0][i * 4 + 1] = duoDealCycle.getDealCycle1().getJob().getName() + "데미지";
                    damageLine[0][i * 4 + 2] = duoDealCycle.getDealCycle2().getJob().getName() + "데미지";
                    damageLine[0][i * 4 + 3] = "파티 데미지";
                    damageLine[0][i * 4 + 4] = "15초 : " + simpleDateFormat.format(duoDealCycle.getDealCycle1().getRestraintRingStartTime()) + " ~ " + simpleDateFormat.format(duoDealCycle.getDealCycle1().getRestraintRingEndTime());
                }
                for (int i = 0; i < 680; i++) {
                    damageLine[i + 1][0] = i + 1;
                    for (int j = 0; j < duoDealCycleList.size(); j++) {
                        damageLine[i + 1][j * 4 + 1] = duoDealCycle.getDealCycle1().getDpsList().get(i);
                        damageLine[i + 1][j * 4 + 2] = duoDealCycle.getDealCycle2().getDpsList().get(i);
                        damageLine[i + 1][j * 4 + 3] = duoDealCycle.getDealCycle1().getDpsList().get(i) + duoDealCycle.getDealCycle2().getDpsList().get(i);
                        if (i == 0) {
                            damageLine[i + 1][j * 4 + 4] = "40초 : " + simpleDateFormat.format(duoDealCycle.getDealCycle1().getRestraintRingStartTime()) + " ~ " + simpleDateFormat.format(duoDealCycle.getDealCycle1().getFortyEndTime());
                        } else if (i == 1) {
                            damageLine[i + 1][j * 4 + 4] = "오리진X 15초 : " + simpleDateFormat.format(duoDealCycle.getDealCycle1().getOriginXRestraintRingStartTime()) + " ~ " + simpleDateFormat.format(duoDealCycle.getDealCycle1().getOriginXRestraintRingEndTime());
                        }
                    }
                }
                rownum = 165;
                for (Object[] damage : damageLine) {
                    Row row = xssfSheet.createRow(rownum++);
                    int cellnum = 0;
                    for (Object field : damage) {
                        Cell cell = row.createCell(cellnum++);
                        cell.setCellStyle(cellStyle);
                        if (field instanceof String) {
                            cell.setCellValue((String) field);
                        } else if (field instanceof Integer) {
                            cell.setCellValue((Integer) field);
                        } else if (field instanceof Double) {
                            cell.setCellValue((Double) field);
                        } else if (field instanceof Long) {
                            cell.setCellValue((Long) field);
                            cell.setCellStyle(numberStyle);
                        }
                    }
                }

                // 파티원 1
                XSSFDrawing drawing = xssfSheet.createDrawingPatriarch();
                XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, duoDealCycleList.indexOf(duoDealCycle) * 4 + 1, 100, duoDealCycleList.indexOf(duoDealCycle) * 4 + 5, 120);

                XSSFChart chart = drawing.createChart(anchor);
                chart.setTitleText(duoDealCycle.getDealCycle1().getJob().getName() + " 데미지 그래프");
                chart.setTitleOverlay(false);

                XDDFDataSource<String> xAxis = XDDFDataSourcesFactory.fromStringCellRange(xssfSheet, new CellRangeAddress(166, 845, 0, 0));
                XDDFNumericalDataSource<Double> yAxis =
                        yAxis = XDDFDataSourcesFactory.fromNumericCellRange(xssfSheet, new CellRangeAddress(166, 845, duoDealCycleList.indexOf(duoDealCycle) * 4 + 1, duoDealCycleList.indexOf(duoDealCycle) * 4 + 1));

                XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
                bottomAxis.setTitle("초");
                XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
                leftAxis.setTitle("데미지");
                leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

                XDDFLineChartData lineChartData = (XDDFLineChartData) chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);
                XDDFLineChartData.Series series = (XDDFLineChartData.Series) lineChartData.addSeries(xAxis, yAxis);
                series.setTitle("데미지 그래프", null);
                series.setSmooth(false);
                series.setMarkerStyle(MarkerStyle.CIRCLE);

                chart.plot(lineChartData);

                // 파티원 2
                drawing = xssfSheet.createDrawingPatriarch();
                anchor = drawing.createAnchor(0, 0, 0, 0, duoDealCycleList.indexOf(duoDealCycle) * 4 + 1, 121, duoDealCycleList.indexOf(duoDealCycle) * 4 + 5, 141);

                chart = drawing.createChart(anchor);
                chart.setTitleText(duoDealCycle.getDealCycle2().getJob().getName() + " 데미지 그래프");
                chart.setTitleOverlay(false);

                xAxis = XDDFDataSourcesFactory.fromStringCellRange(xssfSheet, new CellRangeAddress(166, 845, 0, 0));
                yAxis = XDDFDataSourcesFactory.fromNumericCellRange(xssfSheet, new CellRangeAddress(166, 845, duoDealCycleList.indexOf(duoDealCycle) * 4 + 2, duoDealCycleList.indexOf(duoDealCycle) * 4 + 2));

                bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
                bottomAxis.setTitle("초");
                leftAxis = chart.createValueAxis(AxisPosition.LEFT);
                leftAxis.setTitle("데미지");
                leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

                lineChartData = (XDDFLineChartData) chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);
                series = (XDDFLineChartData.Series) lineChartData.addSeries(xAxis, yAxis);
                series.setTitle("데미지 그래프", null);
                series.setSmooth(false);
                series.setMarkerStyle(MarkerStyle.CIRCLE);

                chart.plot(lineChartData);

                // 파티원 합계
                drawing = xssfSheet.createDrawingPatriarch();
                anchor = drawing.createAnchor(0, 0, 0, 0, duoDealCycleList.indexOf(duoDealCycle) * 4 + 1, 142, duoDealCycleList.indexOf(duoDealCycle) * 4 + 5, 162);

                chart = drawing.createChart(anchor);
                chart.setTitleText("파티 데미지 그래프");
                chart.setTitleOverlay(false);

                xAxis = XDDFDataSourcesFactory.fromStringCellRange(xssfSheet, new CellRangeAddress(166, 845, 0, 0));
                yAxis = XDDFDataSourcesFactory.fromNumericCellRange(xssfSheet, new CellRangeAddress(166, 845, duoDealCycleList.indexOf(duoDealCycle) * 4 + 3, duoDealCycleList.indexOf(duoDealCycle) * 4 + 3));

                bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
                bottomAxis.setTitle("초");
                leftAxis = chart.createValueAxis(AxisPosition.LEFT);
                leftAxis.setTitle("데미지");
                leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

                lineChartData = (XDDFLineChartData) chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);
                series = (XDDFLineChartData.Series) lineChartData.addSeries(xAxis, yAxis);
                series.setTitle("데미지 그래프", null);
                series.setSmooth(false);
                series.setMarkerStyle(MarkerStyle.CIRCLE);

                chart.plot(lineChartData);
            }
        }

        xssfSheet = xssfWorkbook.createSheet("DPM(솔로)");
        xssfSheet.setDefaultColumnWidth(20);

        data = new TreeMap<>();
        data.put("1", new Object[]{
                "직업이름", "DPM", "DPM 배율", "15초딜", "15초딜 배율", "40초 딜", "40초딜 배율", "오리진X 15초딜", "오리진X 15초딜 배율"
        });
        for (int i = 0; i < soloDealCycleList.size(); i++) {
            if (
                    soloDealCycleList.get(i).getJob().getName().equals("제로 - 알파")
                    || soloDealCycleList.get(i).getJob().getName().equals("제로 - 알파(컨티)")
            ) {
                continue;
            }
            if (soloDealCycleList.get(i).getJob().getName().equals("제로 - 베타")) {
                soloDealCycleList.get(i).getJob().setName("제로(리웨)");
            }
            if (soloDealCycleList.get(i).getJob().getName().equals("제로 - 베타(컨티)")) {
                soloDealCycleList.get(i).getJob().setName("제로(컨티)");
            }
            data.put(String.valueOf(i + 2), soloDealCycleList.get(i).getObject());
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
        xssfSheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 0, 8));
        Cell cell = row.createCell(0);
        cell.setCellValue("1제네4카5앜9칠흑2여명2칠요 / 쌍레 한줄 이탈 5줄 / 무기추옵 1추+보공 / 방어구 및 장신구 22성, 주흔작 / 펫장비 프펫공, 프펫마 / " +
                "\n예티X핑크빈 칭호 / 유니온 9000 및 주요 캐릭터(은월, 메르세데스 등) 250레벨, 그 외 200레벨 / 헥사 풀강 / 동일 환산(87721) / " +
                "\n캐릭터레벨 285 / 아케인포스 1350, 어센틱포스 660 / 유니온 아티팩트 54렙 / 길드스킬 60포인트 / 대형몹 / " +
                "\n영메, 반빨별, 장비 명장, 익스트림 레드 및 블루, 길축, 우뿌, 유힘, 슈퍼파워, 붕뿌, 향산된 10단계 물약, VIP 버프, 세이람의 영약 / 어빌 레유유 최대옵션 / " +
                "\n리레 4렙, 웨퍼 4렙(스위칭) 혹은 컨티 4렙 / 15초딜은 6차 포함하여 측정 / 히어로, 팔라딘 - 두손검 착용 / 마법사 및 섀도어 20성 방패 착용 / " +
                "\n듀얼블레이드 22성 아케인 블레이드 착용 / 하이퍼 스킬은 사냥기를 제외하고 선택 / 몬스터 방어율 380% / 렙뻥, 포뻥 미적용");
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
        cell = row.createCell(7);
        cell.setCellStyle(cellStyle);
        cell = row.createCell(8);
        cell.setCellStyle(cellStyle);

        if (duoDealCycleList != null) {
            xssfSheet = xssfWorkbook.createSheet("DPM(2인팟)");
            xssfSheet.setDefaultColumnWidth(20);

            data = new TreeMap<>();
            data.put("1", new Object[]{
                    "파티이름", "DPM", "DPM 배율", "15초딜", "15초딜 배율", "40초 딜", "40초딜 배율", "오리진X 15초딜", "오리진X 15초딜 배율", "비고"
            });
            for (int i = 0; i < duoDealCycleList.size(); i++) {
                data.put(String.valueOf(i + 2), duoDealCycleList.get(i).getObject());
            }

            keyset = data.keySet();
            rownum = 0;

            for (String key : keyset) {
                Row row1 = xssfSheet.createRow(rownum++);
                Object[] objArr = data.get(key);
                int cellnum = 0;
                for (Object o : objArr) {
                    Cell cell1 = row1.createCell(cellnum++);
                    cell1.setCellStyle(cellStyle);
                    if (o instanceof String) {
                        if (((String) o).charAt(0) == '=') {
                            String formula = (String) o;
                            formula = formula.substring(1);
                            cell1.setCellFormula(formula);
                        } else {
                            cell1.setCellValue((String) o);
                        }
                    } else if (o instanceof Long) {
                        cell1.setCellValue((Long) o);
                    } else if (o instanceof Double) {
                        cell1.setCellValue((Double) o);
                    }
                }
            }
        }

        List<Item> itemList = new ArrayList<>();
        itemList.add(new Badge());
        itemList.add(new Belt(JobType.ETC));
        itemList.add(new Belt(JobType.XENON));
        itemList.add(new Belt(JobType.DEMON_AVENGER));
        itemList.add(new Bottom(JobType.ETC));
        itemList.add(new Bottom(JobType.XENON));
        itemList.add(new Bottom(JobType.DEMON_AVENGER));
        itemList.add(new Cape(JobType.ETC));
        itemList.add(new Cape(JobType.XENON));
        itemList.add(new Cape(JobType.DEMON_AVENGER));
        itemList.add(new Earrings(JobType.ETC));
        itemList.add(new Earrings(JobType.XENON));
        itemList.add(new Earrings(JobType.DEMON_AVENGER));
        itemList.add(new Eye(JobType.ETC));
        itemList.add(new Eye(JobType.XENON));
        itemList.add(new Eye(JobType.DEMON_AVENGER));
        itemList.add(new Face(JobType.ETC));
        itemList.add(new Face(JobType.XENON));
        itemList.add(new Face(JobType.DEMON_AVENGER));
        itemList.add(new Gloves(JobType.ETC));
        itemList.add(new Gloves(JobType.XENON));
        itemList.add(new Gloves(JobType.DEMON_AVENGER));
        itemList.add(new Hat(JobType.ETC));
        itemList.add(new Hat(JobType.COOLDOWN_REDUCTION1));
        itemList.add(new Hat(JobType.COOLDOWN_REDUCTION2));
        itemList.add(new Hat(JobType.COOLDOWN_REDUCTION3));
        itemList.add(new Hat(JobType.COOLDOWN_REDUCTION4));
        itemList.add(new Hat(JobType.COOLDOWN_REDUCTION_MAX));
        itemList.add(new Hat(JobType.XENON));
        itemList.add(new Hat(JobType.DEMON_AVENGER));
        itemList.add(new Pendant1(JobType.ETC));
        itemList.add(new Pendant1(JobType.XENON));
        itemList.add(new Pendant1(JobType.DEMON_AVENGER));
        itemList.add(new Pendant2(JobType.ETC));
        itemList.add(new Pendant2(JobType.XENON));
        itemList.add(new Pendant2(JobType.DEMON_AVENGER));
        itemList.add(new Shoes(JobType.ETC));
        itemList.add(new Shoes(JobType.XENON));
        itemList.add(new Shoes(JobType.DEMON_AVENGER));
        itemList.add(new Shoulder(JobType.ETC));
        itemList.add(new Shoulder(JobType.XENON));
        itemList.add(new Shoulder(JobType.DEMON_AVENGER));
        itemList.add(new Top(JobType.ETC));
        itemList.add(new Top(JobType.XENON));
        itemList.add(new Top(JobType.DEMON_AVENGER));
        itemList.add(new Ring1(JobType.ETC));
        itemList.add(new Ring1(JobType.XENON));
        itemList.add(new Ring1(JobType.DEMON_AVENGER));
        itemList.add(new Ring2(JobType.ETC));
        itemList.add(new Ring2(JobType.XENON));
        itemList.add(new Ring2(JobType.DEMON_AVENGER));
        itemList.add(new Ring3(JobType.ETC));
        itemList.add(new Ring3(JobType.XENON));
        itemList.add(new Ring3(JobType.DEMON_AVENGER));
        itemList.add(new Ring4_Special());
        itemList.add(new Heart());
        itemList.add(new Pocket());
        itemList.add(new Emblem());
        itemList.add(new Medal());
        itemList.add(new SetOption());
        itemList.add(new Title());
        itemList.add(new Symbol());
        itemList.add(new Pet());
        itemList.add(new Coordi());
        itemList.add(new DragonWeapon());
        itemList.add(new MechanicWeapon());
        xssfSheet = xssfWorkbook.createSheet("장비");
        xssfSheet.setDefaultColumnWidth(50);

        data = new TreeMap<>();
        data.put("01", new Object[]{
                "부위", "옵션"
        });
        int colNum = 2;
        for (int i = colNum; i < itemList.size() + colNum; i++) {
            String tmp = String.valueOf(i);
            if (tmp.length() == 1) {
                tmp = "0" + tmp;
            }
            data.put(tmp, itemList.get(i - colNum).getObject());
        }

        keyset = data.keySet();
        rownum = 0;

        for (String key : keyset) {
            Row row1 = xssfSheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object o : objArr) {
                Cell cell1 = row1.createCell(cellnum++);
                cell1.setCellStyle(cellStyle);
                if (o instanceof String) {
                    if (((String) o).charAt(0) == '=') {
                        String formula = (String) o;
                        formula = formula.substring(1);
                        cell1.setCellFormula(formula);
                    } else {
                        cell1.setCellValue((String) o);
                    }
                } else if (o instanceof Long) {
                    cell1.setCellValue((Long) o);
                } else if (o instanceof Double) {
                    cell1.setCellValue((Double) o);
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

    public void insertImg(XSSFWorkbook xssfWorkbook, XSSFSheet xssfSheet, int colNum, int rowNum, DealCycle dealCycle) {
        if (dealCycle.getJob().getName().equals("데몬슬레이어\n(극포실, 환산 84352)")) {
            dealCycle.getJob().setName("데몬슬레이어 (극포실, 환산 84352)");
        }
        if (dealCycle.getJob().getName().equals("데몬슬레이어\n(극포실, 환산 84318, 컨티)")) {
            dealCycle.getJob().setName("데몬슬레이어 (극포실, 환산 84318, 컨티)");
        }
        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        String svgNamespaceURI = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNamespaceURI, "svg", null);

        // Create an instance of the SVG Generator
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);

        // Drawing code
        drawActivities(svgGenerator, dealCycle);

        // Save the SVG to a file
        try {
            OutputStream outputStream = new FileOutputStream(new File("../버프 시간/" + dealCycle.getJob().getName() + " 버프 시간.svg"));
            Writer out = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            svgGenerator.stream(out, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String svgPath = "../버프 시간/" + dealCycle.getJob().getName() + " 버프 시간.svg";
            String pngPath = "../버프 시간/" + dealCycle.getJob().getName() + " 버프 시간.png";

            SVGDocument svgDocument = new SVGDocument(svgPath);
            ImageSaveOptions options = new ImageSaveOptions(ImageFormat.Png);
            Converter.convertSVG(svgDocument, options, pngPath);
            svgDocument.dispose();

            pngPath = "../버프 시간/" + dealCycle.getJob().getName() + " 버프 시간_1.png";
            InputStream is = new FileInputStream(pngPath);
            byte[] bytes = IOUtils.toByteArray(is);

            xssfWorkbook.addPicture(is, XSSFWorkbook.PICTURE_TYPE_PNG);
            int picIdx = xssfWorkbook.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG);
            is.close();

            XSSFCreationHelper helper = xssfWorkbook.getCreationHelper();
            XSSFDrawing drawing = xssfSheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = helper.createClientAnchor();

            // 이미지 출력할 cell 위치
            anchor.setRow1(colNum);
            anchor.setCol1(rowNum);
            // 이미지 그리기
            XSSFPicture pic = drawing.createPicture(anchor, picIdx);
            pic.resize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
