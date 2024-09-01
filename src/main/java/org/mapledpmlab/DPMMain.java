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
import org.apache.poi.xssf.usermodel.*;
import org.mapledpmlab.type.JobContinuous.*;
import org.mapledpmlab.type.dealcycle.*;
import org.mapledpmlab.type.job.*;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;

public class DPMMain {

    List<DealCycle> dealCycleList;

    public DPMMain() {
        init();
    }

    public void init() {
        dealCycleList = new ArrayList<>();
        dealCycleList.add(new AdeleMarkerDealCycle(new Adele()));
        //dealCycleList.add(new AdeleMarker4DealCycle(new Adele()));
        dealCycleList.add(new AngelicBusterDealCycle(new AngelicBuster()));
        dealCycleList.add(new AranDealCycle(new Aran()));
        dealCycleList.add(new ArchMageFPDealCycle(new ArchMageFP()));
        dealCycleList.add(new ArchMageFPContinuousDealCycle(new ArchMageFPContinuous()));
        dealCycleList.add(new ArchMageILDealCycle(new ArchMageIL()));
        dealCycleList.add(new ArkDealCycle(new Ark()));
        dealCycleList.add(new BattleMageDealCycle(new BattleMage()));
        dealCycleList.add(new BattleMageContinuousDealCycle(new BattleMageContinuous()));
        dealCycleList.add(new Bishop2DealCycle(new Bishop()));
        dealCycleList.add(new Bishop3DealCycle(new Bishop()));
        dealCycleList.add(new Bishop2ContinuousDealCycle(new BishopContinuous()));
        dealCycleList.add(new Blaster480DealCycle(new Blaster()));
        dealCycleList.add(new Blaster510DealCycle(new Blaster()));
        dealCycleList.add(new Blaster540DealCycle(new Blaster()));
        dealCycleList.add(new Blaster480ContinuousDealCycle(new BlasterContinuous()));
        dealCycleList.add(new Blaster510ContinuousDealCycle(new BlasterContinuous()));
        dealCycleList.add(new Blaster540ContinuousDealCycle(new BlasterContinuous()));
        dealCycleList.add(new BowmasterDealCycle(new Bowmaster()));
        dealCycleList.add(new BowmasterContinuousDealCycle(new BowmasterContinuous()));
        dealCycleList.add(new CadenaDealCycle(new Cadena()));
        dealCycleList.add(new CadenaContinuousDealCycle(new CadenaContinuous()));
        dealCycleList.add(new CannonShooter3DealCycle(new CannonShooter()));
        dealCycleList.add(new CaptainDealCycle(new Captain()));
        dealCycleList.add(new CaptainContinuousDealCycle(new CaptainContinuous()));
        dealCycleList.add(new DarkKnightDealCycle(new DarkKnight()));
        dealCycleList.add(new DemonAvenger29DealCycle(new DemonAvenger()));
        dealCycleList.add(new DemonAvenger30DealCycle(new DemonAvenger()));
        dealCycleList.add(new DemonAvenger29ContinuousDealCycle(new DemonAvengerContinuous()));
        dealCycleList.add(new DemonAvenger30ContinuousDealCycle(new DemonAvengerContinuous()));
        dealCycleList.add(new DemonSlayerDealCycle(new DemonSlayerRuin()));
        dealCycleList.add(new DemonSlayerDealCycle(new DemonSlayerNormal()));
        dealCycleList.add(new DemonSlayerContinuousDealCycle(new DemonSlayerRuinContinuous()));
        dealCycleList.add(new DemonSlayerContinuousDealCycle(new DemonSlayerNormalContinuous()));
        dealCycleList.add(new DualBladeDealCycle(new DualBlade()));
        dealCycleList.add(new EunwolCancelDealCycle(new Eunwol()));
        dealCycleList.add(new EunwolDealCycle(new Eunwol()));
        dealCycleList.add(new EvanDealCycle(new Evan()));
        dealCycleList.add(new EvanContinuousDealCycle(new EvanContinuous()));
        dealCycleList.add(new FlameWizard2DealCycle(new FlameWizard()));
        dealCycleList.add(new FlameWizard3DealCycle(new FlameWizard()));
        dealCycleList.add(new HeroDealCycle(new Hero()));
        dealCycleList.add(new HoYoungDealCycle(new HoYoung()));
        dealCycleList.add(new IlliumDealCycle(new Illium()));
        dealCycleList.add(new KainDealCycle(new Kain()));
        dealCycleList.add(new KaiserDealCycle(new KaiserStat()));
        dealCycleList.add(new KaiserDealCycle(new Kaiser2()));
        dealCycleList.add(new KaiserContinuousDealCycle(new KaiserStatContinuous()));
        dealCycleList.add(new KaiserContinuousDealCycle(new Kaiser2Continuous()));
        dealCycleList.add(new KhaliDealCycle(new Khali()));
        dealCycleList.add(new KinesisDealCycle(new Kinesis()));
        dealCycleList.add(new LaraDealCycle(new Lara()));
        dealCycleList.add(new LaraContinuousDealCycle(new LaraContinuous()));
        dealCycleList.add(new LuminousDealCycle(new Luminous()));
        dealCycleList.add(new LuminousContinuousDealCycle(new LuminousContinuous()));
        dealCycleList.add(new MarksmanDealCycle(new Marksman()));
        dealCycleList.add(new MechanicDealCycle(new Mechanic()));
        dealCycleList.add(new MercedesDealCycle(new Mercedes()));
        dealCycleList.add(new MercedesContinuousDealCycle(new MercedesContinuous()));
        dealCycleList.add(new MihileDealCycle(new Mihile()));
        dealCycleList.add(new MihileContinuousDealCycle(new MihileContinuous()));
        dealCycleList.add(new NightLordDealCycle(new NightLord()));
        dealCycleList.add(new NightWalkerDealCycle(new NightWalker()));
        dealCycleList.add(new PaladinDealCycle(new Paladin()));
        dealCycleList.add(new PathFinderDealCycle(new Pathfinder()));
        dealCycleList.add(new PhantomDealCycle(new Phantom()));
        dealCycleList.add(new PhantomContinuousDealCycle(new PhantomContinuous()));
        dealCycleList.add(new ShadowerDealCycle(new Shadower()));
        dealCycleList.add(new ShadowerContinuousDealCycle(new ShadowerContinuous()));
        dealCycleList.add(new SoulMasterDealCycle(new SoulMaster()));
        dealCycleList.add(new StrikerDealCycle(new Striker()));
        dealCycleList.add(new StrikerContinuousDealCycle(new StrikerContinuous()));
        dealCycleList.add(new ViperDealCycle(new Viper()));
        dealCycleList.add(new WildHunterDealCycle(new WildHunter()));
        dealCycleList.add(new WindBreakerDealCycle(new WindBreaker()));
        dealCycleList.add(new XenonDealCycle(new Xenon()));
        dealCycleList.add(new Xenon2HologramDealCycle(new Xenon()));
        dealCycleList.add(new ZeroDealCycle(new ZeroAlpha()));
        dealCycleList.add(new ZeroDealCycle(new ZeroBeta()));
        dealCycleList.add(new ZeroContinuousDealCycle(new ZeroAlphaContinuous()));
        dealCycleList.add(new ZeroContinuousDealCycle(new ZeroBetaContinuous()));
        /*for (DealCycle dealCycle : dealCycleList) {
            if (dealCycle instanceof ZeroContinuousDealCycle) {
                dealCycle.getJobInfo();
                //break;
            }
        }*/
        this.exportExcel();
        //this.exportSVG();
    }

    private void exportSVG() {
        for (DealCycle dealCycle : dealCycleList) {
            if (dealCycle.getJob().getName().equals("제로 - 알파")) {
                continue;
            }
            if (dealCycle.getJob().getName().equals("제로 - 베타")) {
                dealCycle.getJob().setName("제로");
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
                OutputStream outputStream = new FileOutputStream(new File("버프 시간/" + dealCycle.getJob().getName() + " 버프 시간.svg"));
                Writer out = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                svgGenerator.stream(out, true);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // SVG 파일 생성
            try {
                dealCycle.calcDps();
                FileWriter writer = new FileWriter("딜그래프/" + dealCycle.getJob().getName() + " 딜그래프.svg");

                // SVG 헤더 작성
                writer.write("<svg xmlns='http://www.w3.org/2000/svg' width='720' height='2000'>");

                // 선 그래프 그리기
                drawLineGraph(writer, dealCycle.getDpsList());

                // SVG 푸터 작성
                writer.write("</svg>");

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 선 그래프를 그리는 메서드
    private static void drawLineGraph(FileWriter writer, List<Long> data) throws IOException {
        // 선 그래프 시작점
        int startX = 50;
        int startY = 450;

        // 선 그래프 경로 생성
        StringBuilder path = new StringBuilder();
        path.append("M").append(startX).append(",").append(startY).append(" ");

        // 데이터를 이용하여 선 그래프 경로 추가
        int xIncrement = 5; // X 축 증가량
        int yScale = 1; // Y 축 스케일
        for (int i = 0; i < data.size(); i++) {
            int x = startX + xIncrement * i;
            int y = startY - (int)(data.get(i) / 100000000000L) * yScale;
            path.append("L").append(x).append(",").append(y).append(" ");
        }

        // 선 그래프 스타일과 데이터 경로 추가
        writer.write("<path fill='none' stroke='blue' stroke-width='2' d='" + path + "'/>");
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
                "크리티컬확률", "공격력%", "무기총공격력", "%미적용주스탯", "버프지속시간",
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
            if (
                    dealCycle.getJob().getName().equals("제로 - 알파")
                    || dealCycle.getJob().getName().equals("제로 - 알파(컨티)")
            ) {
                continue;
            }
            if (dealCycle.getJob().getName().equals("제로 - 베타")) {
                dealCycle.getJob().setName("제로");
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

            // 이미지 삽입
            //insertImg(xssfWorkbook, xssfSheet, colNum, dealCycle);
        }

        xssfSheet = xssfWorkbook.createSheet("DPM");
        xssfSheet.setDefaultColumnWidth(20);

        data = new TreeMap<>();
        data.put("1", new Object[]{
                "직업이름", "DPM", "DPM 배율", "15초딜", "15초딜 배율", "40초 딜", "40초딜 배율", "오리진X 15초딜", "오리진X 15초딜 배율"
        });
        for (int i = 0; i < dealCycleList.size(); i++) {
            if (
                    dealCycleList.get(i).getJob().getName().equals("제로 - 알파")
                    || dealCycleList.get(i).getJob().getName().equals("제로 - 알파(컨티)")
            ) {
                continue;
            }
            if (dealCycleList.get(i).getJob().getName().equals("제로 - 베타")) {
                dealCycleList.get(i).getJob().setName("제로");
            }
            if (dealCycleList.get(i).getJob().getName().equals("제로 - 베타(컨티)")) {
                dealCycleList.get(i).getJob().setName("제로(컨티)");
            }
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
        xssfSheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 0, 8));
        Cell cell = row.createCell(0);
        cell.setCellValue("1제네4카5앜9칠흑2여명2칠요 / 쌍레 한줄 이탈 5줄 / 무기추옵 1추+보공 / 방어구 및 장신구 22성, 주흔작 / 펫장비 프펫공, 프펫마 / " +
                "\n예티X핑크빈 칭호 / 유니온 9000 및 주요 캐릭터(은월, 메르세데스 등) 250레벨, 그 외 200레벨 / 헥사 풀강 / 동일 환산(87791) / " +
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

        try {
            FileOutputStream out = new FileOutputStream(new File(filePath, fileNm));
            xssfWorkbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertImg(XSSFWorkbook xssfWorkbook, XSSFSheet xssfSheet, int colNum, DealCycle dealCycle) {
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
            OutputStream outputStream = new FileOutputStream(new File("버프 시간/" + dealCycle.getJob().getName() + " 버프 시간.svg"));
            Writer out = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            svgGenerator.stream(out, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // SVG 파일 생성
        try {
            dealCycle.calcDps();
            FileWriter writer = new FileWriter("딜그래프/" + dealCycle.getJob().getName() + " 딜그래프.svg");

            // SVG 헤더 작성
            writer.write("<svg xmlns='http://www.w3.org/2000/svg' width='720' height='500'>");

            // 선 그래프 그리기
            drawLineGraph(writer, dealCycle.getDpsList());

            // SVG 푸터 작성
            writer.write("</svg>");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String svgPath = "딜그래프/" + dealCycle.getJob().getName() + " 딜그래프.svg";
            String pngPath = "딜그래프/" + dealCycle.getJob().getName() + " 딜그래프.png";

            SVGDocument svgDocument = new SVGDocument(svgPath);
            ImageSaveOptions options = new ImageSaveOptions(ImageFormat.Png);
            Converter.convertSVG(svgDocument, options, pngPath);
            svgDocument.dispose();

            pngPath = "딜그래프/" + dealCycle.getJob().getName() + " 딜그래프_1.png";
            InputStream is = new FileInputStream(pngPath);
            byte[] bytes = IOUtils.toByteArray(is);

            xssfWorkbook.addPicture(is, XSSFWorkbook.PICTURE_TYPE_PNG);
            int picIdx = xssfWorkbook.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG);
            is.close();

            XSSFCreationHelper helper = xssfWorkbook.getCreationHelper();
            XSSFDrawing drawing = xssfSheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = helper.createClientAnchor();

            // 이미지 출력할 cell 위치
            anchor.setRow1(colNum + 10);
            anchor.setCol1(3);
            // 이미지 그리기
            XSSFPicture pic = drawing.createPicture(anchor, picIdx);
            pic.resize();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String svgPath = "버프 시간/" + dealCycle.getJob().getName() + " 버프 시간.svg";
            String pngPath = "버프 시간/" + dealCycle.getJob().getName() + " 버프 시간.png";

            SVGDocument svgDocument = new SVGDocument(svgPath);
            ImageSaveOptions options = new ImageSaveOptions(ImageFormat.Png);
            Converter.convertSVG(svgDocument, options, pngPath);
            svgDocument.dispose();

            pngPath = "버프 시간/" + dealCycle.getJob().getName() + " 버프 시간_1.png";
            InputStream is = new FileInputStream(pngPath);
            byte[] bytes = IOUtils.toByteArray(is);

            xssfWorkbook.addPicture(is, XSSFWorkbook.PICTURE_TYPE_PNG);
            int picIdx = xssfWorkbook.addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG);
            is.close();

            XSSFCreationHelper helper = xssfWorkbook.getCreationHelper();
            XSSFDrawing drawing = xssfSheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = helper.createClientAnchor();

            // 이미지 출력할 cell 위치
            anchor.setRow1(colNum + 10);
            anchor.setCol1(0);
            // 이미지 그리기
            XSSFPicture pic = drawing.createPicture(anchor, picIdx);
            pic.resize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
