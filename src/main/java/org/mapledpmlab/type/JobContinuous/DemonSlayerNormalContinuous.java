package org.mapledpmlab.type.JobContinuous;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperDemonSlayer;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class DemonSlayerNormalContinuous extends Job {

    public DemonSlayerNormalContinuous() {
        // 기본
        super();
        this.setName("데몬슬레이어");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

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
        //this.addBossDamage(70L);
        //this.addAttP(9L);
        this.addBossDamage(30L);
        this.addAttP(21L);
        this.addAttP(21L);

        // 1차
        this.addMainStat(20L);          // 데몬 액셀레이션

        // 2차
        this.addFinalDamage(1.1);       // 웨폰 마스터리
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);
        this.addAtt(50L);               // 아웃레이지
        this.addCriticalP(20.0);

        // 3차
        this.addFinalDamage(1.3);       // 컨센트레이션
        this.addCriticalP(15.0);        // 이블 토쳐

        // 4차
        this.addIgnoreDefenseList(31L);  // 다크 바인드
        this.addDamage(36L);            // 메타모포시스
        this.addAtt(51L);               // 어드밴스드 웨폰 마스터리

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸

        // 환산 보정
        this.addMainStatP(33L);
        this.addMainStat(-2L);
        this.addSubStat(-5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new Artifact());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new StrUnion());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperDemonSlayer(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();
        this.addFinalDamage(1.15);      // 이블 토쳐
        this.addIgnoreDefenseList(15L); // 데몬 임팩트 : 데몬 체인
    }
}
