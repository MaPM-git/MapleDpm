package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.PirateBlessing;
import org.mapledpmlab.type.union.DexUnion2;

import java.util.stream.Collectors;

public class Captain extends Job {

    public Captain() {
        // 기본
        super();
        this.setName("캡틴(리웨)");
        this.setConstant(1.5);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

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
        this.addSubStat(10L);
        this.addAtt(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 1차
        this.addCriticalP(20.0);        // 크리티컬 로어
        this.addCriticalDamage(5.0);

        // 2차
        this.addAtt(10L);               // 인피닛 불릿
        this.addMainStat(20L);          // 건 액셀레이션
        this.addCriticalP(10.0);        // 건 마스터리
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addAtt(60L);               // 할로포인트 불릿
        this.addFinalDamage(1.2);       // 풀메탈 자켓
        this.addCriticalP(30.0);
        this.addIgnoreDefenseList(20L);

        // 4차
        this.addCriticalDamage(21.0);   // 컨티뉴얼 에이밍
        this.addAttP(21L);              // 파이렛 스타일
        this.addCriticalDamage(26.0);   // 크루 커맨더십
        this.addFinalDamage(1.08);      // 캡틴 디그니티
        this.addAtt(31L);

        // 5차
        this.addAtt(40L);               // 로디드 다이스

        // 환산 보정
        this.addMainStatP(-39L);
        this.addMainStat(-2L);
        this.addSubStat(5L);

        this.setAbility(new ReuseBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new PirateBlessing());
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
        this.addFinalDamage(1.27);      // 컨티뉴얼 에이밍
        this.addDamage(16L);            // 오펜스 폼
        this.addAtt(48L);               // 크루 커맨더십
        this.addCriticalDamage(5.0);
    }
}
