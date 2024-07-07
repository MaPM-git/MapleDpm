package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.ability.PassiveBossAbnormal;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.equipment.MechanicWeapon;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.DexUnion;
import org.mapledpmlab.type.union.DexUnion2;

import java.util.stream.Collectors;

public class Mechanic extends Job {

    public Mechanic() {
        // 기본
        super();
        this.setName("메카닉");
        this.setConstant(1.5);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (249 + 154 + 72 + 221));
        this.setWeaponAttMagic((long) (249 + 154 + 72 + 221));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        this.addAttP(3L);

        // 보조
        this.addMainStat(10L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        
        // 0차
        this.addDamage(10L);            // 히든 피스

        // 1차
        this.addAtt(40L);               // 메탈아머 : 휴먼

        // 2차
        this.addAtt(20L);               // 메카닉 마스터리
        this.addCriticalP(15.0);
        this.addCriticalDamage(5.0);
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addCriticalP(30.0);        // 메탈아머 : 탱크
        this.addFinalDamage(1.39);      // 오버 튜닝
        this.addCriticalP(20.0);
        this.addIgnoreDefenseList(30L);

        // 4차
        this.addAtt(56L);               // 메탈아머 익스트림
        this.addDamage(46L);            // 로봇 마스터리

        // 5차
        this.addAtt(40L);               // 로디드 다이스

        // 환산 보정
        this.addMainStatP(-30L);
        this.addMainStat(-14L);
        this.addSubStat(-5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new Artifact());
        this.getLinkList().add(new HybridLogic());
        this.setUnion(new DexUnion2());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    public void addTotal(JobType jobType) {
        super.addTotal(jobType);
        MechanicWeapon mechanicWeapon = new MechanicWeapon();
        this.addMainStat(mechanicWeapon.getMainStat());
        this.addSubStat(mechanicWeapon.getSubStat());
        this.addAtt(mechanicWeapon.getAtt());
    }
}
