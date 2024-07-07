package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalReuse;
import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.LukUnion;

import java.util.stream.Collectors;

public class Phantom extends Job {
    private final Long subStat = 4L;

    public Phantom() {
        // 기본
        super();
        this.setName("팬텀");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (326 + 201 + 72 + 249));
        this.setWeaponAttMagic((long) (326 + 201 + 72 + 249));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        this.addAttP(3L);

        // 보조
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 0차
        this.addSubStat(40L);

        // 2차
        this.addMainStat(20L);          // 케인 액셀레이션
        this.addMainStat(60L);          // 럭 모노폴리

        // 3차
        this.addMainStat(60L);          // 럭 오브 팬텀시프
        this.addAtt(40L);               // 문 라이트
        this.addCriticalP(35.0);        // 어큐트 센스
        this.addFinalDamage(1.3);

        // 4차
        this.addDamage(31L);            // 프레이 오브 아리아
        this.addIgnoreDefenseList(31L);
        this.addAtt(41L);               // 케인 엑스퍼트
        this.addCriticalDamage(15.0);
        this.addFinalDamage(1.32);

        // 하이퍼
        this.addAtt(50L);               // 블리딩 톡신

        // 5차
        this.addAtt(30L);               // 레디 투 다이

        // 환산 보정
        this.addMainStatP(-48L);
        this.addSubStat(-5L);

        this.setAbility(new BossAbnormalReuse());
        this.setArtifact(new Artifact());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new LukUnion());

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
        this.addAtt(30L);           // 스피릿 블레이드
        this.addFinalDamage(1.2);   // 크로스 오버 체인
    }
}
