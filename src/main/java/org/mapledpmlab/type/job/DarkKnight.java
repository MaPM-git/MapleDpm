package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalReuse;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class DarkKnight extends Job {

    public DarkKnight() {
        // 기본
        super();
        this.setName("다크나이트");
        this.setConstant(1.49);         // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

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
        this.addAtt(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 2차
        this.addDamage(5L);             // 웨폰 마스터리
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addFinalDamage(1.8);       // 크로스 오버 체인
        this.addAtt(70L);               // 비홀더스 버프
        this.addMagic(70L);
        this.addCriticalP(10.0);
        this.addCriticalP(30.0);        // 로드 오브 다크니스
        this.addCriticalDamage(8.0);

        // 4차
        this.addFinalDamage(1.36);      // 리인카네이션
        this.addCriticalP(11.0);
        this.addCriticalDamage(15.0);
        this.addFinalDamage(1.08);      // 다크 레조넌스
        this.addIgnoreDefenseList(11L);
        this.addBossDamage(16L);
        this.addIgnoreDefenseList(31L);
        this.addAtt(31L);               // 어드팬스드 웨폰 마스터리
        this.addCriticalDamage(15.0);

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸

        // 환산 보정
        this.addMainStatP(-30L);
        this.addMainStat(-7L);
        this.addSubStat(-10L);

        this.setAbility(new BossAbnormalReuse());
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
}
