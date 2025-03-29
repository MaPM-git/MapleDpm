package org.mapledpmlab.type.JobContinuous;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.LukUnion;

import java.util.stream.Collectors;

public class NightLordContinuous1 extends Job {

    public NightLordContinuous1() {
        // 기본
        super();
        this.setName("나이트로드(컨티, 1초)");
        this.setConstant(1.75);         // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION1);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (172 + 106 + 72 + 195));
        this.setWeaponAttMagic((long) (172 + 106 + 72 + 195));
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
        this.addMainStat(20L);          // 님블 바디

        // 2차
        this.addMainStat(20L);          // 자벨린 액셀레이션
        this.addCriticalP(50.0);        // 크리티컬 스로우
        this.addCriticalDamage(5.0);
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addAtt(10L);               // 스피릿 자벨린
        this.addAtt(29L);               // 플레임 표창
        this.addFinalDamage(1.25);      // 숙련된 표창술
        this.addCriticalP(20.0);
        this.addCriticalDamage(10.0);   // 아드레날린

        // 4차
        this.addBossDamage(11L);        // 퍼지 에어리어
        this.addFinalDamage(1.14);      // 다크 세레니티
        this.addIgnoreDefenseList(31L);
        this.addAtt(31L);               // 자벨린 엑스퍼트
        this.addCriticalDamage(10.0);

        // 하이퍼
        this.addAtt(50L);               // 블리딩 톡신

        // 5차
        this.addAtt(30L);               // 레디 투 다이

        // 환산 보정
        this.addMainStatP(-54L);
        this.addMainStat(6L);
        this.addSubStat(-5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new LukUnion());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }
}
