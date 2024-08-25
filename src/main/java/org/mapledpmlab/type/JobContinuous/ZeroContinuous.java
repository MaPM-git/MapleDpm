package org.mapledpmlab.type.JobContinuous;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperZero;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.link.Confidence;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class ZeroContinuous extends Job {

    public ZeroContinuous() {
        // 기본
        super();
        this.setName("제로");
        this.setMastery(1.90 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);
        this.addMainStat(               // 메이플 용사
                (long) Math.floor(
                        (this.getLevel() + 2) * 5 * 0.16 * -1
                )
        );

        // 공용
        this.addMainStat(               // 륀느의 가호
                (long) Math.floor(
                        (this.getLevel() + 2) * 5 * 0.15
                )
        );
        this.addAtt(20L);               // 디바인 오라
        this.addMagic(20L);
        this.addFinalDamage(1.25);      // 리졸브 타임
        this.addCriticalP(20.0);
        this.addMainStat(50L);

        // 무기 잠재
        this.addBossDamage(40L * 2);
        this.addAttP(18L * 2);
        this.addAttP(21L * 2);
        this.addAttP(3L);

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸

        // 환산 보정
        this.addMainStatP(-6L);
        this.addMainStat(3L);
        this.addSubStat(5L);


        this.setAbility(new ReuseBossAbnormal());
        this.setArtifact(new Artifact());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new Confidence());
        this.setUnion(new StrUnion());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperZero(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }
}
