package org.mapledpmlab.type.etc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.ability.Ability;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.equipment.*;
import org.mapledpmlab.type.hyper.Hyper;
import org.mapledpmlab.type.job.*;
import org.mapledpmlab.type.link.*;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
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
    @JsonIgnore
    private Ability ability;
    @JsonIgnore
    private Artifact artifact;
    @JsonIgnore
    private Hyper hyper;
    @JsonIgnore
    private List<Link> linkList = new ArrayList<>();
    @JsonIgnore
    private Union union;
    private List<Common> passiveList = new ArrayList<>();
    private List<Common> dopingList = new ArrayList<>();
    private Double ascentDamage = 0.0;
    private Long calculatedAscentDamage = 0L;

    public Job() {
        this.setLevel(285L);            // 캐릭터 레벨
        Common passive = new Common();
        passive.setDescription("기본 스탯(285레벨 기준)");
        passive.setMainStat(this.getAp());
        passive.setSubStat(4L);
        passive.setOtherStat1(4L);
        passive.setOtherStat2(4L);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("용사류 스킬");
        passive.setMainStat(
                (long) Math.floor(
                        (this.getLevel() + 2) * 5 * 0.16
                )
        );
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("기본 크리티컬 확률");
        passive.setCriticalP(5.0);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("성향(카리스마, 감성, 통찰력, 의지)");
        passive.addIgnoreDefenseList(10L);
        passive.setPlusBuffDuration(10L);
        passive.setProperty(5L);
        passive.setHp(2000L);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("길드 패시브");
        passive.addAtt(6L);
        passive.addMagic(6L);
        passive.addAtt(4L);
        passive.addMagic(4L);
        passive.addAtt(5L);
        passive.addMagic(5L);
        passive.addMainStat(40L);
        passive.addSubStat(40L);
        passive.addOtherStat1(40L);
        passive.addOtherStat2(40L);
        passive.addHp(2000L);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("여제의 축복");
        passive.addAtt(30L);
        passive.addMagic(30L);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("연합의 의지");
        passive.addAtt(5L);
        passive.addMagic(5L);
        passive.addMainStat(5L);
        passive.addSubStat(5L);
        passive.addOtherStat1(5L);
        passive.addOtherStat2(5L);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("파괴의 얄다바오트");
        passive.addFinalDamage(1.1);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("로프 커넥트");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        passive.addOtherStat1(30L);
        passive.addOtherStat2(30L);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("쓸만한 미스틱 도어");
        passive.addMainStat(6L);
        passive.addSubStat(6L);
        passive.addOtherStat1(6L);
        passive.addOtherStat2(6L);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("쓸만한 샤프 아이즈");
        passive.addMainStat(6L);
        passive.addSubStat(6L);
        passive.addOtherStat1(6L);
        passive.addOtherStat2(6L);
        passive.addCriticalP(10.0);
        passive.addCriticalDamage(8.0);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("쓸만한 하이퍼 바디");
        passive.addMainStat(6L);
        passive.addSubStat(6L);
        passive.addOtherStat1(6L);
        passive.addOtherStat2(6L);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("쓸만한 윈드 부스터");
        passive.addMainStat(6L);
        passive.addSubStat(6L);
        passive.addOtherStat1(6L);
        passive.addOtherStat2(6L);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("쓸만한 어드밴스드 블레스");
        passive.addAtt(20L);
        passive.addMagic(20L);
        passive.addMainStat(6L);
        passive.addSubStat(6L);
        passive.addOtherStat1(6L);
        passive.addOtherStat2(6L);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("블링크");
        passive.addAtt(30L);
        passive.addMagic(30L);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("헥사스탯1(크공보 866)");
        passive.addCriticalDamage(4.55);
        passive.addAtt(30L);
        passive.addMagic(30L);
        passive.addBossDamage(6L);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("헥사스탯2(공크보 866)");
        passive.addAtt(65L);
        passive.addMagic(65L);
        passive.addCriticalDamage(2.1);
        passive.addBossDamage(6L);
        passiveList.add(passive);

        passive = new Common();
        passive.setDescription("헥사스탯3(보공크 866)");
        passive.addBossDamage(13L);
        passive.addAtt(30L);
        passive.addMagic(30L);
        passive.addCriticalDamage(2.1);
        passiveList.add(passive);

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
        Common doping = new Common();
        doping.setDescription("렙뻥");
        doping.addFinalDamage(1.2);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("쓸샵, 쓸어블 수치 제외(세이람)");
        doping.addCriticalP(-10.0);
        doping.addCriticalDamage(-8.0);
        doping.addAtt(-20L);
        doping.addMagic(-20L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("메아리류 스킬");
        doping.addAttP(4L);
        doping.addMagicP(4L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("노블레스 길드 스킬");
        doping.addBossDamage(30L);
        doping.addCriticalDamage(30.0);
        doping.addDamage(30L);
        doping.addIgnoreDefenseList(30L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("반빨별 or 고보킬");
        doping.addBossDamage(20L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("고급 무기 제련(장비 명장)");
        doping.addCriticalDamage(5.0);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("익스트림 레드/블루");
        doping.addAtt(30L);
        doping.addMagic(30L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("길드의 더 큰 축복");
        doping.addAtt(30L);
        doping.addMagic(30L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("마슈르의 선물 기상효과");
        doping.addAtt(30L);
        doping.addMagic(30L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("유니온의 힘");
        doping.addAtt(30L);
        doping.addMagic(30L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("MVP 슈퍼파워 버프");
        doping.addAtt(30L);
        doping.addMagic(30L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("붕어빵 뿌리기");
        doping.addAtt(30L);
        doping.addMagic(30L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("향상된 10단계 물약");
        doping.addMainStat(30L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("275 인기도");
        doping.addAtt(50L);
        doping.addMagic(50L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("세이람의 영약");
        doping.addCriticalP(20.0);
        doping.addCriticalDamage(16.0);
        doping.addAttP(10L);
        doping.addMagicP(10L);
        doping.addAtt(50L);
        doping.addMagic(50L);
        doping.addBossDamage(10L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("VIP 버프");
        doping.addMainStat(15L);
        doping.addSubStat(15L);
        doping.addOtherStat1(15L);
        doping.addOtherStat2(15L);
        doping.addHp(1500L);
        doping.addAtt(15L);
        doping.addMagic(15L);
        doping.addIgnoreDefenseList(15L);
        doping.addBossDamage(15L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("콜렉터의 영약");
        doping.addMainStat(30L);
        doping.addSubStat(30L);
        doping.addOtherStat1(30L);
        doping.addOtherStat2(30L);
        doping.addHp(400L);
        doping.addAtt(100L);
        doping.addMagic(100L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("시프 커닝");
        doping.addDamage(9L);
        dopingList.add(doping);

        doping = new Common();
        doping.setDescription("프라이어 프리퍼레이션");
        doping.addDamage(8L);
        dopingList.add(doping);
    }

    @JsonIgnore
    public Object[] getOpject() {
        Long attMagicBase;
        Long attMagicP;
        Long attMagicAbs;
        Long statusAdditionalDmg;
        if (this.getAtt() > this.getMagic()) {
            attMagicBase = this.getAtt();
            attMagicP = this.getAttP();
            attMagicAbs = this.getPerXAtt();
        } else {
            attMagicBase = this.getMagic();
            attMagicP = this.getMagicP();
            attMagicAbs = this.getPerXAtt();
        }
        if (this.getAbilityDescription().contains("상태")) {
            statusAdditionalDmg = 14L;
        } else {
            statusAdditionalDmg = 6L;
        }
        Object[] result = new Object[]{
                this.getName(), this.getConstant(), this.getMastery() * 2 - 1, this.getLevel(),
                this.getMainStat(), this.getMainStatP() + this.getAllStatP(), this.getPerXMainStat(),
                this.getSubStat(), this.getAllStatP(), this.getPerXSubStat(), "X", "X", "X", this.getStatDamage(),
                this.getDamage(), String.format("%.2f", this.getFinalDamage() * 100 - 100), this.getBossDamage(),
                String.format("%.4f", this.getIgnoreDefense() * 100), attMagicBase, attMagicP, attMagicAbs, this.getCriticalP(), this.getCriticalDamage(),
                this.getCooldownReductionSec() + "초 / " + this.getCooldownReductionP() + "%", this.getPlusBuffDuration(), this.getReuse(),
                this.getProperty(), statusAdditionalDmg, "30", "1350", "660", this.getWeaponAttMagic()
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

    @JsonProperty("ability")
    public String getAbilityDescription() {
        return ability.getDescription();
    }

    @JsonProperty("artifact")
    public String getArtifactDescription() {
        return artifact.getDescription();
    }

    @JsonProperty("hyper")
    public String getHyperDescription() {
        return hyper.getDescription();
    }

    @JsonProperty("union")
    public String getUnionDescription() {
        return union.getDescription();
    }

    public void calculateAscentDamage() {
        Long calculatedAscentDamage = 0L;

        this.addBossDamage(20L);
        this.addAtt(30L);
        this.addMagic(30L);
        this.addAtt(30L);
        this.addMagic(30L);
        this.addAtt(30L);
        this.addMagic(30L);
        this.addAtt(30L);
        this.addMagic(30L);
        this.addAtt(30L);
        this.addMagic(30L);
        this.addMainStat(30L);
        this.addAtt(50L);
        this.addMagic(50L);
        this.addMainStat(15L);
        this.addSubStat(15L);
        this.addOtherStat1(15L);
        this.addOtherStat2(15L);
        this.addHp(1500L);
        this.addAtt(15L);
        this.addMagic(15L);
        this.addBossDamage(15L);

        this.minusObject(new Ring1(this.getJobType()));
        this.minusObject(new Ring2(this.getJobType()));
        this.minusObject(new Ring3(this.getJobType()));
        this.minusObject(new Ring4_Special());
        this.minusObject(new Hat(this.getJobType()));

        this.addCriticalDamage(-8.0);   // 쓸샵
        this.addAtt(-20L);              // 쓸어블
        this.addMagic(-20L);
        if (!this.getName().contains("데몬어벤져") && !this.getName().contains("제로")) {
            this.addMainStat(- (long) Math.floor((this.getLevel() + 2) * 5 * 0.16));    // 메용
        }

        if (this.getName().contains("엔젤릭버스터")) {
            this.addCriticalDamage(-21.0);
        } else if (this.getName().contains("아란")) {
            this.addAtt(-30L);
            this.addMagic(-30L);
        } else if (this.getName().contains("아크메이지")) {
            this.addMagic(-30L);
        } else if (this.getName().contains("비숍")) {
            this.addAtt(-51L);
            this.addMagic(-51L);
            this.addAtt(20L);
            this.addMagic(20L);
            this.addBossDamage(-10L);
        } else if (this.getName().contains("보우마스터")) {
            this.addCriticalDamage(-16.0 + 8);
        } else if (this.getName().contains("캐논슈터")) {
            this.addMainStat(-61L);
            this.addSubStat(-61L);
            this.addOtherStat1(-61L);
            this.addOtherStat2(-61L);
        } else if (this.getName().contains("캡틴")) {
            this.addAttP(-21L);
        } else if (this.getName().contains("다크나이트")) {
            this.minusFinalDamage(1.2);
            this.minusFinalDamage(1.08);
            this.addBossDamage(-16L);
            this.addAtt(-70L);
            this.addMagic(-70L);
            this.minusFinalDamage(1.36);
            this.addCriticalDamage(-15.0);
        } else if (this.getName().contains("데몬어벤져")) {
            this.addMainStatP(-25L);
            this.addMainStatP(-40L);
            this.addHp(-475L);
        } else if (this.getName().contains("데몬슬레이어")) {
            this.addDamage(-45L);
        } else if (this.getName().contains("듀얼블레이드")) {
            this.addDamage(-10L);
        } else if (this.getName().contains("에반")) {
            this.addMagic(-40L);
        } else if (this.getName().contains("히어로")) {
            this.addAtt(-30L);
            this.minusFinalDamage(2.3);
            this.addBossDamage(-20L);
        } else if (this.getName().contains("카이저")) {
            this.addAtt(-20L);
        } else if (this.getName().contains("루미너스")) {
            this.addMagic(-40L);
        } else if (this.getName().contains("신궁")) {
            this.addCriticalDamage(-16.0 + 8);
        } else if (this.getName().contains("메르세데스")) {
            this.addAttP(-31L);
            this.addAtt(-80L);
            this.minusFinalDamage(1.05);
        } else if (this.getName().contains("미하일")) {
            this.addAtt(-30L);
            this.addDamage(-5L);
        } else if (this.getName().contains("나이트로드")) {
            this.addAtt(-50L);
        } else if (this.getName().contains("팔라딘")) {
            this.addAtt(-20L);
            this.minusFinalDamage(1.21);
        } else if (this.getName().contains("패스파인더")) {
            this.addCriticalDamage(-16.0 + 8);
        } else if (this.getName().contains("소울마스터")) {
            this.minusFinalDamage(1.25);
        } else if (this.getName().contains("바이퍼")) {
            this.addAttP(-15L);
        } else if (this.getName().contains("와일드헌터")) {
            this.addAttP(-10L);
            this.addCriticalDamage(-16.0 + 8);
        } else if (this.getName().contains("윈드브레이커")) {
            this.addDamage(-10L);
            this.addCriticalDamage(-16.0 + 8);
        } else if (this.getName().contains("제논")) {
            this.addAllStatP(-20L);
        } else if (this.getName().contains("제로")) {
            this.addAtt(-20L);
            this.addMagic(-20L);
            this.addMainStat(- (long) Math.floor((this.getLevel() + 2) * 5 * 0.15));
        }

        if (this instanceof Xenon2) {
            calculatedAscentDamage = (long) Math.floor(
                    (this.getFinalMainStat() + this.getFinalSubstat() + ((Xenon2) this).getFinalSubStat2()) * 4 * 0.01
                            * (Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                            + this.getPerXAtt())
                            * this.getConstant()
                            * (1 + (this.getDamage() + this.getBossDamage() + this.getStatXDamage() + 60) * 0.01)
                            * this.getFinalDamage()
                            * this.getMastery()
                            * this.getAscentDamage() * 0.01
                            * (1 + 0.35 + this.getCriticalDamage() * 0.01)
                            * (1 - 3.8 * (1 - this.getIgnoreDefense()) * (1 - this.getStatXIgnoreDefense()) * (1 - 1))
            );
        } else if (this instanceof Xenon2Continuous) {
            calculatedAscentDamage = (long) Math.floor(
                    (this.getFinalMainStat() + this.getFinalSubstat() + ((Xenon2Continuous) this).getFinalSubStat2()) * 4 * 0.01
                            * (Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                            + this.getPerXAtt())
                            * this.getConstant()
                            * (1 + (this.getDamage() + this.getBossDamage() + this.getStatXDamage() + 60) * 0.01)
                            * this.getFinalDamage()
                            * this.getMastery()
                            * this.getAscentDamage() * 0.01
                            * (1 + 0.35 + this.getCriticalDamage() * 0.01)
                            * (1 - 3.8 * (1 - this.getIgnoreDefense()) * (1 - this.getStatXIgnoreDefense()) * (1 - 1))
            );
        } else if (this instanceof Xenon5) {
            calculatedAscentDamage = (long) Math.floor(
                    (this.getFinalMainStat() + this.getFinalSubstat() + ((Xenon5) this).getFinalSubStat2()) * 4 * 0.01
                            * (Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                            + this.getPerXAtt())
                            * this.getConstant()
                            * (1 + (this.getDamage() + this.getBossDamage() + this.getStatXDamage() + 60) * 0.01)
                            * this.getFinalDamage()
                            * this.getMastery()
                            * this.getAscentDamage() * 0.01
                            * (1 + 0.35 + this.getCriticalDamage() * 0.01)
                            * (1 - 3.8 * (1 - this.getIgnoreDefense()) * (1 - this.getStatXIgnoreDefense()) * (1 - 1))
            );
        } else if (this instanceof Xenon5Continuous) {
            calculatedAscentDamage = (long) Math.floor(
                    (this.getFinalMainStat() + this.getFinalSubstat() + ((Xenon5Continuous) this).getFinalSubStat2()) * 4 * 0.01
                            * (Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                            + this.getPerXAtt())
                            * this.getConstant()
                            * (1 + (this.getDamage() + this.getBossDamage() + this.getStatXDamage() + 60) * 0.01)
                            * this.getFinalDamage()
                            * this.getMastery()
                            * this.getAscentDamage() * 0.01
                            * (1 + 0.35 + this.getCriticalDamage() * 0.01)
                            * (1 - 3.8 * (1 - this.getIgnoreDefense()) * (1 - this.getStatXIgnoreDefense()) * (1 - 1))
            );
        } else if (this instanceof DemonAvenger2Continuous) {
            calculatedAscentDamage = (long) Math.floor(
                    (((DemonAvenger2Continuous) this).getFinalHp() + ((DemonAvenger2Continuous) this).getStr()) * 0.01
                            * (Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                            + this.getPerXAtt())
                            * this.getConstant()
                            * (1 + (this.getDamage() + this.getBossDamage() + this.getStatXDamage() + 60) * 0.01)
                            * this.getFinalDamage()
                            * this.getMastery()
                            * this.getAscentDamage() * 0.01
                            * (1 + 0.35 + this.getCriticalDamage() * 0.01)
                            * (1 - 3.8 * (1 - this.getIgnoreDefense()) * (1 - this.getStatXIgnoreDefense()) * (1 - 1))
            );
        } else if (this instanceof DemonAvenger2) {
            calculatedAscentDamage = (long) Math.floor(
                    (((DemonAvenger2) this).getFinalHp() + ((DemonAvenger2) this).getStr()) * 0.01
                            * (Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                            + this.getPerXAtt())
                            * this.getConstant()
                            * (1 + (this.getDamage() + this.getBossDamage() + this.getStatXDamage() + 60) * 0.01)
                            * this.getFinalDamage()
                            * this.getMastery()
                            * this.getAscentDamage() * 0.01
                            * (1 + 0.35 + this.getCriticalDamage() * 0.01)
                            * (1 - 3.8 * (1 - this.getIgnoreDefense()) * (1 - this.getStatXIgnoreDefense()) * (1 - 1))
            );
        } else if (this.getMagic() > this.getAtt()) {
            calculatedAscentDamage = (long) Math.floor(
                    (this.getFinalMainStat() * 4 + this.getFinalSubstat()) * 0.01
                            * (Math.floor(this.getMagic() * (1 + this.getMagicP() * 0.01))
                            + this.getPerXAtt())
                            * this.getConstant()
                            * (1 + (this.getDamage() + this.getBossDamage() + this.getStatXDamage() + 60) * 0.01)
                            * this.getFinalDamage()
                            * this.getMastery()
                            * this.getAscentDamage() * 0.01
                            * (1 + 0.35 + this.getCriticalDamage() * 0.01)
                            * (1 - 3.8 * (1 - this.getIgnoreDefense()) * (1 - this.getStatXIgnoreDefense()) * (1 - 1))
            );
        } else if (this instanceof Cadena5) {
            calculatedAscentDamage = (long) Math.floor(
                    (this.getFinalMainStat() * 4 + this.getFinalSubstat() + ((Cadena5) this).getFinalSubStat2()) * 0.01
                            * (Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                            + this.getPerXAtt())
                            * this.getConstant()
                            * (1 + (this.getDamage() + this.getBossDamage() + this.getStatXDamage() + 60) * 0.01)
                            * this.getFinalDamage()
                            * this.getMastery()
                            * this.getAscentDamage() * 0.01
                            * (1 + 0.35 + this.getCriticalDamage() * 0.01)
                            * (1 - 3.8 * (1 - this.getIgnoreDefense()) * (1 - this.getStatXIgnoreDefense()) * (1 - 1))
            );
        } else if (this instanceof Cadena5Continuous) {
            calculatedAscentDamage = (long) Math.floor(
                    (this.getFinalMainStat() * 4 + this.getFinalSubstat() + ((Cadena5Continuous) this).getFinalSubStat2()) * 0.01
                            * (Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                            + this.getPerXAtt())
                            * this.getConstant()
                            * (1 + (this.getDamage() + this.getBossDamage() + this.getStatXDamage() + 60) * 0.01)
                            * this.getFinalDamage()
                            * this.getMastery()
                            * this.getAscentDamage() * 0.01
                            * (1 + 0.35 + this.getCriticalDamage() * 0.01)
                            * (1 - 3.8 * (1 - this.getIgnoreDefense()) * (1 - this.getStatXIgnoreDefense()) * (1 - 1))
            );
        } else if (this instanceof DualBlade5) {
            calculatedAscentDamage = (long) Math.floor(
                    (this.getFinalMainStat() * 4 + this.getFinalSubstat() + ((DualBlade5) this).getFinalSubStat2()) * 0.01
                            * (Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                            + this.getPerXAtt())
                            * this.getConstant()
                            * (1 + (this.getDamage() + this.getBossDamage() + this.getStatXDamage() + 60) * 0.01)
                            * this.getFinalDamage()
                            * this.getMastery()
                            * this.getAscentDamage() * 0.01
                            * (1 + 0.35 + this.getCriticalDamage() * 0.01)
                            * (1 - 3.8 * (1 - this.getIgnoreDefense()) * (1 - this.getStatXIgnoreDefense()) * (1 - 1))
            );
        } else if (this instanceof DualBlade5Continuous) {
            calculatedAscentDamage = (long) Math.floor(
                    (this.getFinalMainStat() * 4 + this.getFinalSubstat() + ((DualBlade5Continuous) this).getFinalSubStat2()) * 0.01
                            * (Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                            + this.getPerXAtt())
                            * this.getConstant()
                            * (1 + (this.getDamage() + this.getBossDamage() + this.getStatXDamage() + 60) * 0.01)
                            * this.getFinalDamage()
                            * this.getMastery()
                            * this.getAscentDamage() * 0.01
                            * (1 + 0.35 + this.getCriticalDamage() * 0.01)
                            * (1 - 3.8 * (1 - this.getIgnoreDefense()) * (1 - this.getStatXIgnoreDefense()) * (1 - 1))
            );
        } else if (this instanceof Shadower5) {
            calculatedAscentDamage = (long) Math.floor(
                    (this.getFinalMainStat() * 4 + this.getFinalSubstat() + ((Shadower5) this).getFinalSubStat2()) * 0.01
                            * (Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                            + this.getPerXAtt())
                            * this.getConstant()
                            * (1 + (this.getDamage() + this.getBossDamage() + this.getStatXDamage() + 60) * 0.01)
                            * this.getFinalDamage()
                            * this.getMastery()
                            * this.getAscentDamage() * 0.01
                            * (1 + 0.35 + this.getCriticalDamage() * 0.01)
                            * (1 - 3.8 * (1 - this.getIgnoreDefense()) * (1 - this.getStatXIgnoreDefense()) * (1 - 1))
            );
        } else if (this instanceof Shadower5Continuous) {
            calculatedAscentDamage = (long) Math.floor(
                    (this.getFinalMainStat() * 4 + this.getFinalSubstat() + ((Shadower5Continuous) this).getFinalSubStat2()) * 0.01
                            * (Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                            + this.getPerXAtt())
                            * this.getConstant()
                            * (1 + (this.getDamage() + this.getBossDamage() + this.getStatXDamage() + 60) * 0.01)
                            * this.getFinalDamage()
                            * this.getMastery()
                            * this.getAscentDamage() * 0.01
                            * (1 + 0.35 + this.getCriticalDamage() * 0.01)
                            * (1 - 3.8 * (1 - this.getIgnoreDefense()) * (1 - this.getStatXIgnoreDefense()) * (1 - 1))
            );
        } else {
            calculatedAscentDamage = (long) Math.floor(
                    (this.getFinalMainStat() * 4 + this.getFinalSubstat()) * 0.01
                            * (Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                            + this.getPerXAtt())
                            * this.getConstant()
                            * (1 + (this.getDamage() + this.getBossDamage() + this.getStatXDamage() + 60) * 0.01)
                            * this.getFinalDamage()
                            * this.getMastery()
                            * this.getAscentDamage() * 0.01
                            * (1 + 0.35 + this.getCriticalDamage() * 0.01)
                            * (1 - 3.8 * (1 - this.getIgnoreDefense()) * (1 - this.getStatXIgnoreDefense()) * (1 - 1))
            );
        }

        this.addObject(new Ring1(this.getJobType()));
        this.addObject(new Ring2(this.getJobType()));
        this.addObject(new Ring3(this.getJobType()));
        this.addObject(new Ring4_Special());
        this.addObject(new Hat(this.getJobType()));

        this.addBossDamage(-20L);
        this.addAtt(-30L);
        this.addMagic(-30L);
        this.addAtt(-30L);
        this.addMagic(-30L);
        this.addAtt(-30L);
        this.addMagic(-30L);
        this.addAtt(-30L);
        this.addMagic(-30L);
        this.addAtt(-30L);
        this.addMagic(-30L);
        this.addMainStat(-30L);
        this.addAtt(-50L);
        this.addMagic(-50L);
        this.addMainStat(-15L);
        this.addSubStat(-15L);
        this.addOtherStat1(-15L);
        this.addOtherStat2(-15L);
        this.addHp(-1500L);
        this.addAtt(-15L);
        this.addMagic(-15L);
        this.addBossDamage(-15L);

        this.addCriticalDamage(8.0);    // 쓸샵
        this.addAtt(20L);               // 쓸어블
        this.addMagic(20L);
        if (!this.getName().contains("데몬어벤져") && !this.getName().contains("제로")) {
            this.addMainStat((long) Math.floor((this.getLevel() + 2) * 5 * 0.16));  // 메용
        }

        if (this.getName().contains("엔젤릭버스터")) {
            this.addCriticalDamage(21.0);
        } else if (this.getName().contains("아란")) {
            this.addAtt(30L);
            this.addMagic(30L);
        } else if (this.getName().contains("아크메이지")) {
            this.addMagic(30L);
        } else if (this.getName().contains("비숍")) {
            this.addAtt(51L);
            this.addMagic(51L);
            this.addAtt(-20L);
            this.addMagic(-20L);
            this.addBossDamage(10L);
        } else if (this.getName().contains("보우마스터")) {
            this.addCriticalDamage(16.0 - 8);
        } else if (this.getName().contains("캐논슈터")) {
            this.addMainStat(61L);
            this.addSubStat(61L);
            this.addOtherStat1(61L);
            this.addOtherStat2(61L);
        } else if (this.getName().contains("캡틴")) {
            this.addAttP(21L);
        } else if (this.getName().contains("다크나이트")) {
            this.addFinalDamage(1.2);
            this.addFinalDamage(1.08);
            this.addBossDamage(16L);
            this.addAtt(70L);
            this.addMagic(70L);
            this.addFinalDamage(1.36);
            this.addCriticalDamage(15.0);
        } else if (this.getName().contains("데몬어벤져")) {
            this.addMainStatP(25L);
            this.addMainStatP(40L);
            this.addHp(475L);
        } else if (this.getName().contains("데몬슬레이어")) {
            this.addDamage(45L);
        } else if (this.getName().contains("듀얼블레이드")) {
            this.addDamage(10L);
        } else if (this.getName().contains("에반")) {
            this.addMagic(40L);
        } else if (this.getName().contains("히어로")) {
            this.addAtt(30L);
            this.addFinalDamage(2.3);
            this.addBossDamage(20L);
        } else if (this.getName().contains("카이저")) {
            this.addAtt(20L);
        } else if (this.getName().contains("루미너스")) {
            this.addMagic(40L);
        } else if (this.getName().contains("신궁")) {
            this.addCriticalDamage(16.0 - 8);
        } else if (this.getName().contains("메르세데스")) {
            this.addAttP(31L);
            this.addAtt(80L);
            this.addFinalDamage(1.05);
        } else if (this.getName().contains("미하일")) {
            this.addAtt(30L);
            this.addDamage(5L);
        } else if (this.getName().contains("나이트로드")) {
            this.addAtt(50L);
        } else if (this.getName().contains("팔라딘")) {
            this.addAtt(20L);
            this.addFinalDamage(1.21);
        } else if (this.getName().contains("패스파인더")) {
            this.addCriticalDamage(16.0 - 8);
        } else if (this.getName().contains("소울마스터")) {
            this.addFinalDamage(1.25);
        } else if (this.getName().contains("바이퍼")) {
            this.addAttP(15L);
        } else if (this.getName().contains("와일드헌터")) {
            this.addAttP(10L);
            this.addCriticalDamage(16.0 - 8);
        } else if (this.getName().contains("윈드브레이커")) {
            this.addDamage(10L);
            this.addCriticalDamage(16.0 - 8);
        } else if (this.getName().contains("제논")) {
            this.addAllStatP(20L);
        } else if (this.getName().contains("제로")) {
            this.addAtt(20L);
            this.addMagic(20L);
            this.addMainStat((long) Math.floor((this.getLevel() + 2) * 5 * 0.15));
        }

        this.setCalculatedAscentDamage(calculatedAscentDamage);
    }
}
