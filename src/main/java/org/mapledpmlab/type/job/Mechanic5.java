package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.equipment.MechanicWeapon;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.DexUnion2;

import java.util.stream.Collectors;

public class Mechanic5 extends Job {

    public Mechanic5() {
        // 기본
        super();
        this.setName("메카닉(5초, 리레단일)");
        this.setConstant(1.5);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        this.setAscentDamage(2993625.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (249 + 154 + 72 + 221));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (249 + 154 + 72 + 221));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);
        
        // 0차
        passive = new Common();
        passive.setDescription("히든 피스");
        passive.addDamage(10L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("메카닉 마스터리");
        passive.addAtt(20L);
        passive.addCriticalP(15.0);
        passive.addCriticalDamage(5.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("메탈아머 : 탱크");
        passive.addCriticalP(30.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("오버 튜닝");
        passive.addFinalDamage(1.42);
        passive.addCriticalP(20.0);
        passive.addIgnoreDefenseList(30L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("메탈아머 익스트림");
        passive.addAtt(56L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("로봇 마스터리");
        passive.addDamage(46L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("로디드 다이스");
        passive.addAtt(40L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-72L);
        this.addMainStat(-4L);
        this.addSubStat(-5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.setUnion(new DexUnion2());

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
        doping.setDescription("로봇 마스터리(콜렉터의 영약)");
        doping.addDamage(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }

    public void addTotal(JobType jobType) {
        super.addTotal(jobType);
        MechanicWeapon mechanicWeapon = new MechanicWeapon();
        this.addMainStat(mechanicWeapon.getMainStat());
        this.addSubStat(mechanicWeapon.getSubStat());
        this.addAtt(mechanicWeapon.getAtt());
    }
}
