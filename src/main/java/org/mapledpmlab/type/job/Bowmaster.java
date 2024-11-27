package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperArcher;
import org.mapledpmlab.type.link.*;
import org.mapledpmlab.type.union.DexUnion;

import java.util.stream.Collectors;

public class Bowmaster extends Job {

    public Bowmaster() {
        // 기본
        super();
        this.setName("보우마스터(리웨)");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

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
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 1차
        this.addCriticalP(40.0);        // 크리티컬 샷

        // 2차
        this.addMainStat(20L);          // 보우 액셀레이션
        this.addAtt(30L);               // 소울 애로우 : 활
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addAtt(40L);               // 익스트림 아쳐리 : 활
        this.addFinalDamage(1.3);
        this.addAttP(25L);              // 마크맨쉽
        this.addIgnoreDefenseList(25L);

        // 4차
        this.addFinalDamage(1.06);      // 어드밴스드 퀴버
        this.addCriticalP(26.0 - 10);   // 샤프 아이즈
        this.addCriticalDamage(16.0 - 8);
        this.addIgnoreDefenseList(5L);
        this.addAtt(62L);               // 보우 엑스퍼트
        this.addCriticalDamage(16.0);
        this.addMainStat(82L);          // 일루전 스탭
        this.addAtt(21L);               // 어드밴스드 파이널 어택
        this.addIgnoreDefenseList(40L); // 아머 피어싱
        this.addFinalDamage(1.07);

        // 환산 보정
        this.addMainStatP(-63L);
        this.addMainStat(-10L);
        this.addSubStat(-10L);

        this.setAbility(new BossCriticalAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new AdventurerCuriosity());
        for (Link link : this.getLinkList()) {
            if (link instanceof CygnusBlessing) {
                this.getLinkList().remove(link);
                break;
            }
        }
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new DexUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperArcher(this.getLevel()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();
        this.addDamage(35L);            // 모탈 블로우
        this.addCriticalP(-20.0);       // 세이람의 영약
        this.addCriticalDamage(-16.0);
    }
}
