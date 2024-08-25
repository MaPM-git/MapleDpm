package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class Aran extends Job {

    public Aran() {
        // 기본
        super();
        this.setName("아란");
        this.setConstant(1.49);         // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (304 + 187 + 72 + 241));
        this.setWeaponAttMagic((long) (304 + 187 + 72 + 241));
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
        this.addAttP(5L);               // 되찾은 기억
        
        // 1차
        this.addMainStat(20L);          // 폴암 액셀레이션
        this.addAtt(20L);               // 페이브
        this.addCriticalP(10.0);

        // 2차
        this.addCriticalP(20.0);        // 콤보 어빌리티
        this.addDamage(10L);            // 스노우 차지
        this.addFinalDamage(1.1);       // 폴암 마스터리
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addAtt(10L);               // 어드밴스드 콤보 어빌리티
        this.addCriticalDamage(10.0);
        this.addAtt(20L);
        this.addAtt(30L);               // 블레싱 마하
        this.addMagic(30L);
        this.addAtt(40L);               // 마이트
        this.addCriticalP(20.0);
        this.addBossDamage(15L);

        // 4차
        this.addAtt(31L);               // 하이 마스터리
        this.addCriticalDamage(8.0);
        this.addFinalDamage(1.16);
        this.addDamage(31L);            // 클리빙 어택
        this.addIgnoreDefenseList(41L);
        this.addAtt(31L);               // 어드밴스드 파이널 어택

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸

        // 환산 보정
        this.addMainStatP(-72L);
        this.addMainStat(21L);
        //this.addSubStat(5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new Artifact());
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
        this.addDamage(10L);            // 스노우 차지
    }
}
