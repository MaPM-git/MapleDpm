package org.mapledpmlab.old.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class Eunwol extends Job {

    public Eunwol() {
        // 기본
        super();
        this.setName("은월");
        this.setConstant(1.7);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
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
        this.addAtt(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 2차
        this.addMainStat(60L);          // 근력 단련

        // 3차
        this.addDamage(20L);            // 정령 결속 3식
        this.addAtt(20L);

        // 4차
        this.addFinalDamage(1.15);      // 정령 결속 4식
        this.addBossDamage(31L);
        this.addIgnoreDefenseList(31L);
        this.addFinalDamage(1.17);      // 고급 너클 숙련
        this.addCriticalDamage(22.0);
        this.addCriticalP(26.0);        // 약점 간파
        this.addCriticalDamage(10.0);
        this.addFinalDamage(1.1);

        // 5차
        this.addAtt(40L);               // 로디드 다이스

        // 환산 보정
        this.addMainStatP(3L);
        this.addMainStat(1L);
        this.addSubStat(10L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new Artifact());
        this.getLinkList().add(new PhantomInstinct());
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
        this.addDamage(20L);        // 약화
        this.addDamage(35L);        // 정령 결속 극대화
        this.addAtt(20L);
        this.addBossDamage(20L);
        this.addIgnoreDefenseList(20L);
    }
}
