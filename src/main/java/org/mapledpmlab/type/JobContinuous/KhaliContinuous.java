package org.mapledpmlab.type.JobContinuous;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.NatureFriend;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.LukUnion;

import java.util.stream.Collectors;

public class KhaliContinuous extends Job {

    public KhaliContinuous() {
        // 기본
        super();
        this.setName("칼리(컨티)");
        this.setConstant(1.30);         // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

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
        //this.addBossDamage(70L);
        //this.addAttP(9L);
        this.addBossDamage(30L);
        this.addAttP(21L);
        this.addAttP(21L);

        // 1차
        this.addAtt(30L);               // 플레어

        // 2차
        this.addAtt(30L);               // 차크람 마스터리
        this.addCriticalP(35.0);        // 임펄스
        this.addCriticalDamage(20.0);
        this.addMainStat(60L);          // 피지컬 트레이닝

        // 3차
        this.addFinalDamage(1.3);       // 인투이션
        this.addIgnoreDefenseList(20L);
        this.addAtt(30L);

        // 4차
        this.addAtt(31L);               // 차크람 엑스퍼트
        this.addCriticalDamage(20.0);
        this.addFinalDamage(1.42);      // 리뎀션
        this.addIgnoreDefenseList(21L);
        this.addBossDamage(31L);

        // 5차
        this.addAtt(30L);               // 레디 투 다이

        // 환산 보정
        this.addMainStatP(-36L);
        this.addMainStat(-6L);
        this.addSubStat(5L);

        this.setAbility(new ReuseBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new NatureFriend());
        this.getLinkList().add(new PhantomInstinct());
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
