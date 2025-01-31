package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.ability.ReuseBossCritical;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperArcher;
import org.mapledpmlab.type.link.CygnusBlessing;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Link;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.DexUnion;

import java.util.stream.Collectors;

public class WildHunter5 extends Job {

    public WildHunter5() {
        // 기본
        super();
        this.setName("와일드헌터(리웨, 5초)");
        this.setConstant(1.35);         // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
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
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addAtt(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 재규어
        this.addCriticalP(5.0);
        this.addPlusBuffDuration(10L);

        // 1차
        this.addCriticalDamage(8.0);    // 서먼 재규어
        this.addAtt(20L);               // 오토매틱 슈팅 디바이스
        this.addCriticalP(25.0);        // 네이처스 라스

        // 2차
        this.addAtt(20L);               // 소울 애로우 : 석궁
        this.addAttP(10L);              // 하울링
        this.addMainStat(20L);          // 크로스보우 액셀레이션
        this.addDamage(10L);            // 크로스보우 마스터리
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addAttP(25L);              // 비스트 폼
        this.addFinalDamage(1.1);
        this.addMainStat(40L);          // 플러리
        this.addCriticalP(18.0);        // 재규어 링크
        this.addCriticalDamage(12.0);
        this.addAtt(10L);

        // 4차
        this.addCriticalP(21.0 - 10);   // 샤프 아이즈
        this.addCriticalDamage(16.0 - 8);
        this.addFinalDamage(1.2);       // 익스텐드 매거진
        this.addMainStat(62L);
        this.addAtt(31L);               // 크로스보우 엑스퍼트
        this.addCriticalDamage(20.0);
        this.addIgnoreDefenseList(33L);  // 와일드 인스팅트
        this.addAtt(21L);               // 어드밴스드 파이널 어택

        // 5차
        this.addAtt(65L);               // 재규어 스톰

        // 환산 보정
        this.addMainStatP(-90L);
        this.addMainStat(10L);
        this.addSubStat(10L);

        this.setAbility(new ReuseBossCritical());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        for (Link link : this.getLinkList()) {
            if (link instanceof CygnusBlessing) {
                this.getLinkList().remove(link);
                break;
            }
        }
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new DexUnion());

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
        this.addAttP(-10L);             // 하울링
        this.addCriticalP(-20.0);       // 세이람의 영약
        this.addCriticalDamage(-16.0);
    }
}
