package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.ability.BossAbnormalBuff;
import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.ability.BuffBossAbnormal;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.DexUnion;
import org.mapledpmlab.type.union.DexUnion2;

import java.util.stream.Collectors;

public class AngelicBuster extends Job {

    public AngelicBuster() {
        // 기본
        super();
        this.setName("엔젤릭버스터");
        this.setConstant(1.7);          // 무기상수
        this.setMastery(1.96 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);

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
        this.addOtherStat1(10L);
        this.addOtherStat2(10L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 2차
        this.addAtt(20L);               // 소울슈터 마스터리
        this.addMainStat(40L);          // 이너 파이어
        this.addFinalDamage(1.05);
        this.addDamage(10L);            // 어피니티 II
        this.addCriticalP(25.0);

        // 3차
        this.addMainStat(20L);          // 샤이닝 로터스
        this.addFinalDamage(1.14);
        this.addAtt(40L);               // 콜 오브 에인션트
        this.addIgnoreDefenseList(16L);
        this.addCriticalDamage(6.0);
        this.addMainStat(40L);          // 어피니티 III
        this.addDamage(10L);
        this.addFinalDamage(1.1);
        this.addCriticalP(10.0);        // 어텐션
        this.addCriticalDamage(15.0);

        // 4차
        this.addCriticalDamage(31.0);   // 소울 게이즈
        this.addAtt(31L);               // 소울슈터 엑스퍼트
        this.addFinalDamage(1.23);

        // 하이퍼
        this.addIgnoreDefenseList(15L); // 피니투라 페투치아-리듀스 아머

        // 5차
        this.addMainStat(40L);          // 트리니티 퓨전
        this.addAtt(40L);               // 로디드 다이스

        // 환산 보정
        this.addMainStatP(-57L);
        this.addMainStat(-4L);
        this.addSubStat(8L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new Artifact());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new DexUnion2());
        this.addPerXMainStat(20L);

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
        this.addDamage(25L);            // 어피니티 IV
    }
}
