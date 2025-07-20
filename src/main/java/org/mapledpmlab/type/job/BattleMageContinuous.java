package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class BattleMageContinuous extends Job {

    public BattleMageContinuous() {
        // 기본
        super();
        this.setName("배틀메이지(0초, 컨티)");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.96 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        this.setAscentDamage(2338525.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addMagic((long) (406 + 250 + 72 + 276));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addMagicP(9L);
        passive.addMagicP(21L);
        passive.addMagicP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (406 + 250 + 72 + 276));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat((long) (10 + 80 + 75));
        passive.addSubStat(75L);
        passive.addAtt(45L);
        passive.addMagic((long) (1 + 45));
        //passive.addBossDamage(70L);
        //passive.addMagicP(9L);
        passive.addBossDamage(30L);
        passive.addMagicP(21L);
        passive.addMagicP(21L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("아트 오브 스태프");
        passive.addMagic(20L);
        passive.addCriticalP(15.0);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("스태프 마스터리");
        passive.addMagic(30L);
        passive.addCriticalP(20.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("하이 위즈덤");
        passive.addMainStat(40L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("배틀 마스터리");
        passive.addFinalDamage(1.3);
        passive.addCriticalDamage(10.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("다크 오라");
        passive.addMagicP(15L);
        passive.addDamage(10L);
        passive.addBossDamage(5L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("배틀 레이지");
        passive.addDamage(25L);
        passive.addCriticalP(21.0);
        passive.addCriticalDamage(10.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("스태프 엑스퍼트");
        passive.addMagic(31L);
        passive.addCriticalDamage(21.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("스펠 부스트");
        passive.addFinalDamage(1.22);
        passive.addMagicP(10L);
        passive.addDamage(6L);
        passive.addIgnoreDefenseList(31L);
        getPassiveList().add(passive);

        // 환산 보정
        this.addMainStatP(-6L);
        this.addMainStat(-13L);
        this.addSubStat(8L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.setUnion(new IntUnion());
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
        doping.setDescription("디버프 오라");
        doping.addIgnoreDefenseList(20L);
        doping.addFinalDamage(1.05);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("배틀 레이지(콜렉터의 영약)");
        doping.addDamage(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("스태프 엑스퍼트(콜렉터의 영약)");
        doping.addMagic(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("스펠 부스트(콜렉터의 영약)");
        doping.minusFinalDamage(1.22);
        doping.addFinalDamage(1.23);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat()) * 0.01
                        * Math.floor(this.getMagic() * (1 + this.getMagicP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}
