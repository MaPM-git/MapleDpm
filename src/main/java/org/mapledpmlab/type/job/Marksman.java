package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperArcher;
import org.mapledpmlab.type.link.*;
import org.mapledpmlab.type.union.DexUnion;

import java.util.stream.Collectors;

public class Marksman extends Job {

    public Marksman() {
        // 기본
        super();
        this.setName("신궁");
        this.setConstant(1.35);         // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
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
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addAtt(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 1차
        this.addCriticalP(40.0);        // 크리티컬 샷

        // 2차
        this.addMainStat(20L);          // 크로스보우 액셀레이션
        this.addAtt(30L);               // 소울 애로우 : 석궁
        this.addFinalDamage(1.2);       // 크로스보우 마스터리
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addCriticalDamage(20.0);   // 익스트림 아쳐리 : 석궁
        this.addDamage(15L);              // 마크맨쉽
        this.addIgnoreDefenseList(25L);

        // 4차
        this.addFinalDamage(1.08);      // 어드밴스드 인핸스 애로우
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(31L); // 애로우 일루전
        this.addCriticalP(26.0 - 20 - 10);   // 샤프 아이즈
        this.addCriticalDamage(16.0 - 8);
        this.addIgnoreDefenseList(5L);
        this.addAtt(31L);               // 크로스보우 엑스퍼트
        this.addCriticalDamage(15.0);
        this.addMainStat(82L);          // 일루전 스탭
        this.addFinalDamage(1.16);      // 어디셔널 볼트
        this.addFinalDamage(1.11);      // 라스트맨 스탠딩

        // 환산 보정
        this.addMainStatP(-60L);
        //this.addMainStat(3L);
        this.addSubStat(-5L);

        this.setAbility(new BossCriticalAbnormal());
        this.setArtifactNormal(new ArtifactNormal());
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

        this.addObject(this.getAbility());
        this.addObject(this.getArtifactNormal());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperArcher(this.getLevel()));
        this.addObject(this.getHyper());
    }
    
    @Override
    public void Doping() {
        super.Doping();
        this.addDamage(2L);             // 모탈 블로우
        this.addFinalDamage(1.04);      // 포커스 온
        this.addIgnoreDefenseList(13L);
        this.addCriticalP(-6.0);        // 샤프 아이즈
        this.addCriticalDamage(-16.0);
    }
}
