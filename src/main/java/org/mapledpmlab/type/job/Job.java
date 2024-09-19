package org.mapledpmlab.type.job;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.ability.Ability;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.Hyper;
import org.mapledpmlab.type.link.*;
import org.mapledpmlab.type.union.Union;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Job extends Common {
    private Double constant;
    private Double mastery;
    private String name;
    private JobType jobType;
    private Long weaponAttMagic;
    private Ability ability;
    private Artifact artifact;
    private Hyper hyper;
    private List<Link> linkList = new ArrayList<>();
    private Union union;

    public Job() {
        this.setLevel(285L);            // 캐릭터 레벨
        this.setMainStat(this.getAp()); // 기본 스탯(275 기준)
        this.setSubStat(4L);
        this.setOtherStat1(4L);
        this.setOtherStat2(4L);
        this.addMainStat(               // 메이플 용사
                (long) Math.floor(
                        (this.getLevel() + 2) * 5 * 0.16
                )
        );

        this.addCriticalP(5.0);         // 기본 크리티컬 확률

        this.addIgnoreDefenseList(10L);  // 성향 - 카리스마
        this.addPlusBuffDuration(10L);  // 성향 - 감성
        this.addProperty(5L);           // 성향 - 통찰력
        this.addHp(2000L);              // 성향 - 의지

        this.addAtt(6L);                // 길드의 매운 맛 I
        this.addMagic(6L);
        this.addAtt(4L);                // 길드의 매운 맛 II
        this.addMagic(4L);
        this.addAtt(5L);                // 길드의 매운 맛 III
        this.addMagic(5L);
        this.addMainStat(40L);          // 팔방미인
        this.addSubStat(40L);
        this.addOtherStat1(40L);
        this.addOtherStat2(40L);
        this.addHp(2000L);

        this.addAtt(30L);               // 여제의 축복
        this.addMagic(30L);
        this.addAtt(5L);                // 연합의 의지
        this.addMagic(5L);
        this.addMainStat(5L);
        this.addSubStat(5L);
        this.addOtherStat1(5L);
        this.addOtherStat2(5L);
        this.addFinalDamage(1.1);       // 파괴의 얄다바오트
        this.addMainStat(30L);          // 로프 커넥트
        this.addSubStat(30L);
        this.addOtherStat1(30L);
        this.addOtherStat2(30L);
        this.addMainStat(6L);           // 쓸만한 미스틱 도어
        this.addSubStat(6L);
        this.addOtherStat1(6L);
        this.addOtherStat2(6L);
        this.addMainStat(6L);           // 쓸만한 샤프 아이즈
        this.addSubStat(6L);
        this.addOtherStat1(6L);
        this.addOtherStat2(6L);
        this.addCriticalP(10.0);
        this.addCriticalDamage(8.0);
        this.addMainStat(6L);           // 쓸만한 하이퍼 바디
        this.addSubStat(6L);
        this.addOtherStat1(6L);
        this.addOtherStat2(6L);
        this.addMainStat(6L);           // 쓸만한 윈드 부스터
        this.addSubStat(6L);
        this.addOtherStat1(6L);
        this.addOtherStat2(6L);
        this.addAtt(20L);               // 쓸만한 어드밴스드 블레스
        this.addMagic(20L);
        this.addMainStat(6L);
        this.addSubStat(6L);
        this.addOtherStat1(6L);
        this.addOtherStat2(6L);
        this.addAtt(30L);               // 블링크
        this.addMagic(30L);

        this.addCriticalDamage(4.55);   // 헥사스탯1(크공보 866)
        this.addAtt(30L);
        this.addMagic(30L);
        this.addBossDamage(6L);
        this.addAtt(65L);               // 헥사스탯2(공크보 866)
        this.addMagic(65L);
        this.addCriticalDamage(2.1);
        this.addBossDamage(6L);

        linkList.add(new FuryUnleashed());
        linkList.add(new EmpiricalKnowledge());
        linkList.add(new Solus());
        linkList.add(new CygnusBlessing());
        linkList.add(new WildRage());
        linkList.add(new IntensiveInsult());
        linkList.add(new Judgment());
        linkList.add(new LightWash());
        // 소울 컨트랙트
        // 시프 커닝
        // 프라이어 프리퍼레이션
    }

    public void Doping() {
        this.addCriticalP(-10.0);       // 쓸샵, 쓸어블
        this.addCriticalDamage(-8.0);
        this.addAtt(-20L);
        this.addMagic(-20L);
        
        this.addAttP(4L);               // 영웅의 메아리
        this.addMagicP(4L);

        this.addBossDamage(30L);        // 노블레스 길드 스킬
        this.addCriticalDamage(30.0);
        this.addDamage(30L);
        this.addIgnoreDefenseList(30L);

        this.addBossDamage(20L);        // 반빨별 or 고보킬
        this.addCriticalDamage(5.0);    // 고급 무기 제련(장비 명장)
        this.addAtt(30L);               // 익스트림 레드
        this.addMagic(30L);             // 익스트림 블루
        this.addAtt(30L);               // 길드의 더 큰 축복
        this.addMagic(30L);
        this.addAtt(30L);               // 마슈르의 선물 기상효과
        this.addMagic(30L);
        this.addAtt(30L);               // 유니온의 힘
        this.addMagic(30L);
        this.addAtt(30L);               // MVP 슈퍼파워 버프
        this.addMagic(30L);
        this.addAtt(30L);               // 붕어빵 뿌리기
        this.addMagic(30L);
        this.addMainStat(30L);          // 향상된 10단계 물약
        this.addAtt(50L);               // 275 인기도
        this.addMagic(50L);
        this.addCriticalP(20.0);        // 세이람의 영약
        this.addCriticalDamage(16.0);
        this.addAttP(10L);
        this.addMagicP(10L);
        this.addAtt(50L);
        this.addMagic(50L);
        this.addBossDamage(10L);
        this.addMainStat(15L);          // VIP 버프
        this.addSubStat(15L);
        this.addOtherStat1(15L);
        this.addOtherStat2(15L);
        this.addHp(1500L);
        this.addAtt(15L);
        this.addMagic(15L);
        this.addIgnoreDefenseList(15L);
        this.addBossDamage(15L);

        this.addDamage(9L);             // 시프 커닝
        this.addDamage(8L);             // 프라이어 프리퍼레이션
    }

    public Object[] getOpject() {
        Long attMagic;
        Long attMagicP;
        if (this.getAtt() > this.getMagic()) {
            attMagic = this.getAtt();
            attMagicP = this.getAttP();
        } else {
            attMagic = this.getMagic();
            attMagicP = this.getMagicP();
        }
        Object[] result = new Object[]{
                this.getName(), this.getConstant(), this.getMastery() * 2 - 1, this.getLevel(),
                this.getFinalMainStat(), this.getFinalMainStatMinusMapleWarrior(), this.getAp(),
                this.getFinalSubstat(), "X", this.getStatDamage(), this.getDamage(),
                this.getBossDamage(), this.getIgnoreDefense(), this.getCriticalDamage(),
                this.getCriticalP(), attMagicP, this.getWeaponAttMagic(), this.getPerXMainStat(),
                this.getPlusBuffDuration(), this.getReuse(), this.getCooldownReductionSec(),
                this.getFinalDamage()
        };
        return result;
    }

    public Long getFinalMainStat() {
        return (long) Math.floor(
                this.getMainStat()
                * (1 + (this.getMainStatP() + this.getAllStatP()) * 0.01))
                + this.getPerXMainStat();
    }

    public Long getFinalMainStatMinusMapleWarrior() {
        return (long) Math.floor(
                (this.getMainStat() - (long) Math.floor((this.getLevel() + 2) * 5 * 0.16))
                * (1 + (this.getMainStatP() + this.getAllStatP()) * 0.01))
                + this.getPerXMainStat();
    }

    public Long getFinalSubstat() {
        return (long) Math.floor(
                this.getSubStat()
                * (1 + this.getAllStatP() * 0.01))
                + this.getPerXSubStat();
    }

    public Long getFinalOtherStat1() {
        return (long) Math.floor(
                this.getOtherStat1()
                * (1 + this.getAllStatP() * 0.01))
                + this.getPerXOtherStat();
    }

    public Long getFinalOtherStat2() {
        return (long) Math.floor(
                this.getOtherStat2()
                * (1 + this.getAllStatP() * 0.01))
                + this.getPerXOtherStat();
    }

    public Long getAp() {
        return this.getLevel() * 5 + 18;
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat()) * 0.01
                * Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                * this.getConstant()
                * (1 + this.getDamage() * 0.01)
                * this.getFinalDamage()
        );
    }

    @Override
    public String toString() {
        return super.toString() + "Job{" +
                "constant=" + constant +
                ", mastery=" + mastery +
                ", name='" + name + '\'' +
                ", jobType=" + jobType +
                ", weaponAttMagic=" + weaponAttMagic +
                '}';
    }

    public String getLinkListStr() {
        String str = "";
        for (Link link : getLinkList()) {
            str += link.getDescription() + "\n";
        }
        str += "소울 컨트랙트\n";
        str += "시프 커닝\n";
        str += "프라이어 프리퍼레이션";
        return str;
    }
}
