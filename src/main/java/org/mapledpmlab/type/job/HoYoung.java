package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.PassiveBossAbnormal;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.Confidence;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.LukUnion;

import java.util.stream.Collectors;

public class HoYoung extends Job {

    public HoYoung() {
        // 기본
        super();
        this.setName("호영");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (318 + 196 + 72 + 246));
        this.setWeaponAttMagic((long) (318 + 196 + 72 + 246));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        this.addAttP(3L);

        // 보조
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addAtt(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 0차
        this.addAttP(10L);              // 괴이봉인
        this.addFinalDamage(1.1);

        // 2차
        this.addAtt(25L);               // 부채 숙련
        this.addCriticalP(30.0);        // 심안
        this.addCriticalDamage(10.0);
        this.addMainStat(60L);          // 신체 단련

        // 3차
        this.addAtt(50L);               // 수라
        this.addCriticalP(10.0);
        this.addCriticalDamage(20.0);
        this.addBossDamage(20L);
        this.addIgnoreDefenseList(10L);

        // 4차
        this.addAtt(42L);               // 고급 부채 숙련
        this.addFinalDamage(1.3);
        this.addDamage(11L);            // 득도
        this.addAtt(12L);               // 점정
        this.addFinalDamage(1.12);
        this.addCriticalP(12.0);
        this.addCriticalDamage(12.0);
        this.addIgnoreDefenseList(12L);

        // 5차
        this.addAtt(30L);               // 레디 투 다이

        // 환산 보정
        this.addMainStatP(-12L);
        this.addMainStat(-18L);
        //this.addSubStat(10L);

        this.setAbility(new PassiveBossAbnormal());
        this.setArtifact(new Artifact());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new Confidence());
        this.setUnion(new LukUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }
}
