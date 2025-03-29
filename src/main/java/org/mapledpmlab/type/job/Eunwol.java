package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class Eunwol extends Job {

    public Eunwol() {
        // 기본
        super();
        this.setName("은월(리웨)");
        this.setConstant(1.7);          // 무기상수
        this.setMastery(1.90 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (255 + 157 + 72 + 223));
        this.setWeaponAttMagic((long) (255 + 157 + 72 + 223));
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

        // 1차
        this.addAtt(20L);               // 가호의 증표
        this.addDamage(10L);

        // 2차
        this.addDamage(10L);            // 호기체현
        this.addCriticalP(15.0);
        this.addCriticalP(10.0);        // 너클 숙련
        this.addMainStat(60L);          // 근력 단련

        // 3차
        this.addFinalDamage(1.15);      // 정령 결속 3식
        this.addBossDamage(20L);
        this.addIgnoreDefenseList(20L); // 약화
        this.addAtt(20L);               // 일치단결
        this.addDamage(20L);
        this.addCriticalDamage(10.0);

        // 4차
        this.addBossDamage(31L);        // 정령 결속 4식
        this.addIgnoreDefenseList(31L);
        this.addFinalDamage(1.17);      // 고급 너클 숙련
        this.addCriticalP(11.0);        // 약점 간파
        this.addCriticalDamage(20.0);
        this.addFinalDamage(1.1);

        // 5차
        this.addAtt(40L);               // 로디드 다이스

        // 환산 보정
        this.addMainStatP(-57L);
        this.addMainStat(-11L);
        this.addSubStat(-10L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new StrUnion());

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
        this.addDamage(20L);        // 약화
    }
}
