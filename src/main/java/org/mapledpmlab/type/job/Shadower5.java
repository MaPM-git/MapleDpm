package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalReuse;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.LukUnion;

import java.util.stream.Collectors;

public class Shadower5 extends Job {

    public Shadower5() {
        // 기본
        super();
        this.setName("섀도어(5초, 리레단일)");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        this.setAscentDamage(2553600.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (318 + 196 + 72 + 246));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (318 + 196 + 72 + 246));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat((long) (10 + 80 + 75));
        passive.addSubStat(75L);
        passive.addAtt((long) (1 + 45));
        passive.addMagic(45L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("님블 바디");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("크리티컬 엣지");
        passive.addCriticalP(25.0);
        passive.addCriticalDamage(5.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("대거 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("카르마");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("실드 마스터리");
        passive.addAtt(15L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("대거 마스터리");
        passive.addFinalDamage(1.1);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("그리드");
        passive.addAtt(25L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("크루얼 스탭");
        passive.addFinalDamage(1.24);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("블러디 파킷");
        passive.addMainStat(10L);
        passive.addCriticalDamage(20.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("섀도어 인스팅트");
        passive.addAtt(47L);
        passive.addFinalDamage(1.18);
        passive.addIgnoreDefenseList(21L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("대거 엑스퍼트");
        passive.addAtt(41L);
        passive.addCriticalDamage(15.0);
        getPassiveList().add(passive);

        // 하이퍼
        passive = new Common();
        passive.setDescription("플립 더 코인");
        passive.addCriticalP(25.0);
        passive.addStatXDamage(25L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("레디 투 다이");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-75L);
        this.addMainStat(12L);
        this.addSubStat(10L);

        this.setAbility(new BossAbnormalReuse());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new LukUnion());
        this.addPerXMainStat(20L);

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
        doping.setDescription("섀도어 인스팅트(콜렉터의 영약)");
        doping.addAtt(2L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("대거 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }

    public Long getFinalSubStat2() {
        return (long) Math.floor(
                this.getOtherStat1()
                        * (1 + this.getAllStatP() * 0.01))
                + this.getPerXOtherStat();
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat() + getFinalSubStat2()) * 0.01
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
