package org.mapledpmlab.type.JobContinuous;

import org.mapledpmlab.type.ability.BossAbnormalReuse;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.MihileUnion;

import java.util.stream.Collectors;

public class MihileContinuous extends Job {
    private final Long subStat = 4L;

    public MihileContinuous() {
        // 기본
        super();
        this.setName("미하일(컨티)");
        this.setConstant(1.24);         // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);

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
        this.addMainStat(21L);
        this.addSubStat(21L);
        //this.addBossDamage(70L);
        //this.addAttP(9L);
        this.addBossDamage(30L);
        this.addAttP(21L);
        this.addAttP(21L);

        // 0차
        this.addAttP(10L);              // 엘리멘탈 엑스퍼트
        this.addMagicP(10L);

        // 1차
        this.addCriticalP(10.0);        // 소울 어택

        // 2차
        this.addAtt(30L);               // 인커리지
        this.addMainStat(20L);          // 소드 액셀레이션
        this.addAtt(20L);               // 소드 마스터리
        this.addFinalDamage(1.2);
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addMainStat(60L);          // 로얄 오쓰
        this.addCriticalP(20.0);
        this.addFinalDamage(1.25);
        this.addCriticalP(10.0);        // 어드밴스드 소울 어택

        // 4차
        this.addFinalDamage(1.26);      // 소울 레이지
        this.addCriticalDamage(10.0);
        this.addAtt(31L);               // 어드밴스드 소드 마스터리
        this.addCriticalP(15.0);
        this.addCriticalDamage(20.0);
        this.addAtt(31L);               // 어드밴스드 파이널 어택
        this.addIgnoreDefenseList(42L);  // 컴뱃 마스터리

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸

        // 환산 보정
        this.addMainStatP(-72L);
        this.addMainStat(-7L);
        this.addSubStat(-3L);

        this.setAbility(new BossAbnormalReuse());
        this.setArtifactNormal(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.setUnion(new MihileUnion());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifactNormal());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }
    
    @Override
    public void Doping() {
        super.Doping();
        this.addAtt(100L);              // 로얄 가드
        this.addDamage(5L);             // 소울 링크
        this.addFinalDamage(1.25);      // 어드밴스드 소울 어택
        this.addDamage(10L);            // 데들리 차지
    }
}
