package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.LukUnion;

import java.util.stream.Collectors;

public class Xenon2 extends Job {
    private final Long starforce = 0L;

    public Xenon2() {
        // 기본
        super();
        this.setName("제논(2초, 리레단일)");
        this.setConstant(1.3125);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.XENON);

        this.setAscentDamage(2867620.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (255 + 157 + 72 + 223));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (255 + 157 + 72 + 223));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(2L);
        passive.addSubStat(2L);
        passive.addOtherStat1(2L);
        passive.addOtherStat2(2L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("기본 스탯(285 기준)");
        passive.setMainStat(
                this.getLevel() * 5 + 18 - 326 - 326
        );
        passive.setSubStat(330L);
        passive.setOtherStat1(330L);
        passive.addMainStat((long) (4 + 5 + 30 + 6 + 6 + 6 + 6));
        passive.addSubStat((long) (4 + 5 + 30 + 6 + 6 + 6 + 6));
        passive.addOtherStat1((long) (4 + 5 + 30 + 6 + 6 + 6 + 6));
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("심볼");
        passive.addPerXMainStat(-28200L);
        passive.addPerXMainStat(7200L + 6336);
        passive.addPerXSubStat(7200L + 6336);
        passive.addPerXOtherStat(7200L + 6336);
        //passive.addPerXMainStat((long) (144 * 4 + 96 * 20));
        getPassiveList().add(passive);
        
        // 0차
        passive = new Common();
        passive.setDescription("멀티래터럴 I");
        passive.addDamage(3L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("컨버전 스타포스");
        passive.addMainStat(70L);
        passive.addSubStat(70L);
        passive.addOtherStat1(70L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("서플라이 20");
        passive.addAllStatP(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("멀티래터럴 II");
        passive.addDamage(5L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("리니어 퍼스펙티브");
        passive.addCriticalP(40.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("마이너리티 서포트");
        passive.addMainStat(25L);
        passive.addSubStat(25L);
        passive.addOtherStat1(25L);
        passive.addOtherStat2(25L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("제논 마스터리");
        passive.addAtt(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("멀티래터럴 III");
        passive.addDamage(7L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("듀얼브리드 디펜시브");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addOtherStat1(10L);
        passive.addOtherStat2(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("멀티래터럴 IV");
        passive.addDamage(10L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("메이플 용사");
        passive.addMainStat(
                (long) Math.floor(
                        ((this.getLevel() + 2) * 5 - 326 - 326) * 0.16
                )
        );
        passive.addSubStat((long) Math.floor(326 * 0.16));
        passive.addOtherStat1((long) Math.floor(326 * 0.16));
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("제논 엑스퍼트");
        passive.addAtt(31L);
        passive.addCriticalDamage(8.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("오펜시브 매트릭스");
        passive.addIgnoreDefenseList(31L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("멀티래터럴 V");
        passive.addDamage(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("멀티래터럴 VI");
        passive.addDamage(5L);
        passive.addFinalDamage(1.15);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("로디드 다이스");
        passive.addAtt(40L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("레디 투 다이");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addAllStatP(-120L);
        this.addMainStat(14L);
        this.addSubStat(13L);
        this.addOtherStat1(13L);
        this.addAtt(0L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new LukUnion());
        this.addPerXMainStat(10L);
        this.addPerXSubStat(10L);
        this.addPerXOtherStat(10L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("서플라이 20");
        doping.addAllStatP(-20L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("인클라인 파워");
        doping.addAtt(30L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("제논 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }

    public Long getFinalSubStat2() {
        return (long) Math.floor(
                (this.getOtherStat1()
                * (1 + this.getAllStatP() * 0.01))
                + this.getPerXOtherStat());
    }

    public Long getStrDex() {
        return getFinalSubstat() + getFinalSubStat2();
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() + getStrDex()) * 4 * 0.01
                        * Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }

    @Override
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
                this.getSubStat(), this.getAllStatP(), this.getPerXSubStat(), this.getOtherStat1(), this.getAllStatP(), this.getPerXOtherStat(), this.getStatDamage(),
                this.getDamage(), String.format("%.2f", this.getFinalDamage() * 100 - 100), this.getBossDamage(),
                String.format("%.4f", this.getIgnoreDefense() * 100), attMagicBase, attMagicP, attMagicAbs, this.getCriticalP(), this.getCriticalDamage(),
                this.getCooldownReductionSec() + "초 / " + this.getCooldownReductionP() + "%", this.getPlusBuffDuration(), this.getReuse(),
                this.getProperty(), statusAdditionalDmg, "30", "1350", "660", this.getWeaponAttMagic()
        };
        return result;
    }
}
