package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class Blaster extends Job {

    public Blaster() {
        // 기본
        super();
        this.setName("블래스터(리웨)");
        this.setConstant(1.7);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

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

        // 2차
        this.addCriticalP(30.0);        // 건틀렛 마스터리
        this.addAtt(20L);
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);
        this.addDamage(15L);            // 차지 마스터리

        // 3차
        this.addAttP(15L);              // 콤비네이션 트레이닝

        // 4차
        this.addCriticalDamage(21.0);   // 건틀렛 엑스퍼트
        this.addBossDamage(21L);
        this.addIgnoreDefenseList(38L); // 어드밴스드 차지 마스터리
        this.addAtt(42L);               // 콤비네이션 트레이닝 II
        this.addCriticalP(40.0);

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸

        // 환산 보정
        this.addMainStatP(-57L);
        this.addMainStat(11L);
        this.addSubStat(5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
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
        this.addFinalDamage(1.7);       // 콤비네이션 트레이닝
        this.addFinalDamage(1.1);       // 해머 스매시
    }
}
