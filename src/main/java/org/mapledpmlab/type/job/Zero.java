package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperZero;
import org.mapledpmlab.type.link.Confidence;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class Zero extends Job {

    public Zero() {
        // 기본
        super();
        this.setName("제로");
        this.setMastery(1.90 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);

        this.setAscentDamage(2619216.0);

        Common passive = new Common();
        passive.setDescription("메이플 용사");
        passive.addMainStat(
                (long) Math.floor(
                        (this.getLevel() + 2) * 5 * 0.16 * -1
                )
        );
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("무기 잠재");
        passive.addBossDamage(70L * 2);
        passive.addAttP(9L * 2);
        passive.addAttP(21L * 2);
        passive.addAttP(3L);
        getPassiveList().add(passive);

        // 공용
        passive = new Common();
        passive.setDescription("륀느의 가호");
        passive.addMainStat(
                (long) Math.floor(
                        (this.getLevel() + 2) * 5 * 0.15
                )
        );
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("디바인 오라");
        passive.addAtt(20L);
        passive.addMagic(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("리졸브 타임");
        passive.addFinalDamage(1.17);
        passive.addCriticalP(20.0);
        passive.addMainStat(50L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("바디 오브 스틸");
        passive.addMainStat(30L);
        getPassiveList().add(passive);

        // 환산 보정
        this.addMainStatP(-15L);
        this.addMainStat(-5L);
        this.addSubStat(10L);

        this.setAbility(new ReuseBossAbnormal());
        this.setArtifact(new ArtifactNormal());
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
