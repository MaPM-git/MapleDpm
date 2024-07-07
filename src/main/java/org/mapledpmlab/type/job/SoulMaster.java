package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.AdeleUnion;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class SoulMaster extends Job {

    public SoulMaster() {
        // 기본
        super();
        this.setName("소울마스터");
        this.setConstant(1.34);         // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (340 + 210 + 72 + 253));
        this.setWeaponAttMagic((long) (340 + 210 + 72 + 253));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        this.addAttP(3L);

        // 보조
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addOtherStat1(10L);
        this.addOtherStat2(10L);
        this.addAtt(3L);
        this.addMagic(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 0차
        this.addAttP(10L);              // 엘리멘탈 엑스퍼트
        this.addMagicP(10L);
        this.addMainStat(               // 엘리멘탈 하모니
                (this.getLevel() - 1) / 2
        );

        // 2차
        this.addIgnoreDefenseList(10L);  // 엘리멘트 : 소울
        this.addMainStat(20L);          // 님블 핑거
        this.addAtt(20L);               // 이너 트러스트
        this.addMainStat(40L);          // 피지컬 트레이닝
        this.addSubStat(20L);

        // 3차
        this.addAtt(30L);               // 이너 샤우트
        this.addMainStat(40L);

        // 4차
        this.addMainStat(31L);          // 소울 플레지
        this.addSubStat(31L);
        this.addCriticalP(10.0);
        this.addAtt(51L);               // 소드 엑스퍼트
        this.addCriticalDamage(12.0);
        this.addIgnoreDefenseList(32L);  // 언포시어블
        this.addBossDamage(16L);
        this.addFinalDamage(1.25);      // 마스터 오브 더 소드
        this.addCriticalP(35.0);

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸

        // 환산 보정
        this.addMainStatP(-18L);
        this.addMainStat(1L);
        this.addSubStat(5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new Artifact());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new AdeleUnion());

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
        this.addAtt(20L);               // 엘리멘트 : 소울
        this.addAtt(15L);               // 소울 블레싱
        this.addAtt(15L);               // 소울 블레싱 II
        this.addFinalDamage(1.1);       // 소울 블레싱 III
    }
}
