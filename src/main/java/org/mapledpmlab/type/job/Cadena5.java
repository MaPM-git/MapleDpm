package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.LukUnion;

import java.util.stream.Collectors;

public class Cadena5 extends Job {

    public Cadena5() {
        // 기본
        super();
        this.setName("카데나(5초, 리웨)");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        this.setAscentDamage(4106739.0);

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
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addAtt(3L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("콜렉팅 포리프");
        passive.addMainStat(50L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("퀵서비스 마인드 I");
        passive.addAtt(10L);
        passive.addCriticalDamage(5.0);
        passive.addCriticalP(10.0);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("베이직 디텍션");
        passive.addIgnoreDefenseList(20L);
        passive.addDamage(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("위크포인트 컨버징 어택 7중첩");
        passive.addCriticalP(14.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("웨폰 엑스퍼트");
        passive.addAtt(50L);
        passive.addCriticalP(31.0);
        passive.addCriticalDamage(19.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("퀵서비스 마인드 II");
        passive.addAtt(31L);
        passive.addCriticalDamage(11.0);
        passive.addCriticalP(11.0);
        passive.addBossDamage(20L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("레디 투 다이");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        // 환산 보정
        this.addMainStatP(-63L);
        this.addMainStat(-3L);
        this.addSubStat(5L);

        this.setAbility(new ReuseBossAbnormal());
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

        this.addObject(getPassiveList());
    }
    
    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("위크포인트 컨버징 어택 7중첩");
        doping.addCriticalDamage(77.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("웨폰 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(3L);
        doping.addCriticalDamage(1.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("퀵서비스 마인드 II(콜렉터의 영약)");
        doping.addAtt(1L);
        doping.addBossDamage(1L);
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
