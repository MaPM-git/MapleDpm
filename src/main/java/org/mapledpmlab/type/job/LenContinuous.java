package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class LenContinuous extends Job {

    public LenContinuous() {
        // 기본
        super();
        this.setName("렌(0초, 컨티)");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        this.setAscentDamage(2809750.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (340 + 210 + 72 + 253));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (340 + 210 + 72 + 253));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addAtt(3L);
        //passive.addBossDamage(70L);
        //passive.addAttP(9L);
        passive.addBossDamage(30L);
        passive.addAttP(21L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("청허심경");
        passive.addAtt(30L);
        passive.addCriticalP(15.0);
        passive.addFinalDamage(1.05);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("장검 숙련");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("신체 단련");
        passive.addMainStat(60L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("청허심경 II");
        passive.addCriticalP(20.0);
        passive.addFinalDamage(1.1);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("청허심경 III");
        passive.addCriticalP(10.0);
        passive.addFinalDamage(1.1);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("고급 장검 숙련");
        passive.addAtt(51L);
        passive.addFinalDamage(1.09);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("청허심경 IV");
        passive.addAtt(61L);
        passive.addFinalDamage(1.21);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("진안");
        passive.addDamage(15L);
        passive.addCriticalDamage(11.0);
        passive.addIgnoreDefenseList(42L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-51L);
        this.addMainStat(7L);
        this.addSubStat(5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
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

        Common doping = new Common();
        doping.setDescription("고급 장검 숙련(콜렉터의 영약)");
        doping.minusFinalDamage(1.09);
        doping.addFinalDamage(1.1);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("고급 장검 숙련(콜렉터의 영약)");
        doping.addDamage(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
