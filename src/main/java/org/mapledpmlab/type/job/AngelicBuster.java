package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.DexUnion;

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

        // 3차
        this.addMainStat(20L);          // 아이언 로터스
        this.addAtt(40L);               // 콜 오브 에인션트
        this.addMainStat(40L);          // 어피니티 III
        this.addDamage(20L);

        // 4차
        this.addFinalDamage(1.26);      // 트리니티
        this.addIgnoreDefenseList(16L);
        this.addCriticalDamage(46.0);   // 소울 게이즈
        this.addAtt(31L);               // 소울슈터 엑스퍼트
        this.addCriticalP(31.0);
        this.addCriticalDamage(16.0);

        // 5차
        this.addMainStat(40L);          // 트리니티 퓨전
        this.addAtt(40L);               // 로디드 다이스

        this.setAbility(new BossCriticalAbnormal());
        this.setArtifact(new Artifact());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new DexUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }
}
