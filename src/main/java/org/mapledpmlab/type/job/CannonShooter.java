package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.link.PirateBlessing;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class CannonShooter extends Job {

    public CannonShooter() {
        // 기본
        super();
        this.setName("캐논슈터");
        this.setConstant(1.5);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (348 + 214 + 72 + 256));
        this.setWeaponAttMagic((long) (348 + 214 + 72 + 256));
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
        this.addAtt(20L);               // 빌드업 캐논

        // 2차
        this.addCriticalP(20.0);        // 크리티컬 파이어
        this.addCriticalDamage(5.0);
        this.addMainStat(20L);          // 캐논 액셀레이션
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addFinalDamage(1.1);       // 오크통 룰렛
        this.addCriticalDamage(10.0);
        this.addCriticalP(20.0);
        this.addFinalDamage(1.05);      // 리인포스 캐논
        this.addAtt(40L);
        this.addFinalDamage(1.05);      // 반격의 슈터

        // 4차
        this.addFinalDamage(1.31);      // 오버버닝 캐논
        this.addIgnoreDefenseList(20L);
        this.addMainStat(61L);          // 하이퍼 몽키 스펠
        this.addSubStat(61L);
        this.addOtherStat1(61L);
        this.addOtherStat2(61L);
        this.addBossDamage(41L);        // 파이렛 스피릿

        // 5차
        this.addAtt(40L);               // 로디드 다이스

        // 환산 보정
        this.addMainStatP(-60L);
        this.addMainStat(6L);
        this.addSubStat(8L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new PirateBlessing());
        this.setUnion(new StrUnion());
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
        this.addDamage(40L);            // 몽키 퓨리어스
    }
}
