package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.ReuseFarm;
import org.mapledpmlab.type.link.Confidence;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.StrUnion;

public class Zero extends Job {

    public Zero() {
        // 기본
        super();
        this.setDescription("제로");
        this.setMastery(1.90 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);
        this.addMainStat(               // 메이플 용사
                (long) Math.floor(
                        (this.getLevel() + 2) * 5 * 0.16 * -1
                )
        );
        this.addObject(new ReuseBossAbnormal());
        this.addObject(new ReuseFarm());
        this.addObject(new HybridLogic());
        this.addObject(new Confidence());
        this.addObject(new StrUnion());

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

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸
    }
}
