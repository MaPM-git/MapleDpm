package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class Adele5Continuous extends Job {

    public Adele5Continuous() {
        // 기본
        super();
        this.setName("아델(5초, 컨티)");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        this.setAscentDamage(2806650.0);

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

        // 0차
        passive = new Common();
        passive.setDescription("페이스");
        passive.addCriticalDamage(10.0);
        passive.addAttP(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("매직 서킷");
        passive.addAtt(51L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("루디먼트");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("마스터리");
        passive.addAtt(30L);
        passive.addCriticalDamage(6.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("트레인");
        passive.addMainStat(60L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("어센트");
        passive.addAtt(30L);
        passive.addFinalDamage(1.17);
        passive.addCriticalP(20.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("엑스퍼트");
        passive.addAtt(31L);
        passive.addDamage(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("데몰리션");
        passive.addFinalDamage(1.31);
        passive.addIgnoreDefenseList(21L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어테인");
        passive.addAtt(31L);
        passive.addDamage(11L);
        passive.addCriticalP(21.0);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("바디 오브 스틸");
        passive.addMainStat(30L);
        getPassiveList().add(passive);

        // 환산 보정
        this.addMainStatP(-63L);
        this.addMainStat(10L);
        this.addSubStat(5L);

        this.setAbility(new ReuseBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new StrUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());

        this.addObject(getPassiveList());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("레조넌스");
        doping.addFinalDamage(1.1);
        doping.addIgnoreDefenseList(10L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("게더링");
        doping.addIgnoreDefenseList(10L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("그레이브");
        doping.addIgnoreDefenseList(10L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("엑스퍼트(콜렉터의 영약)");
        doping.addAtt(1L);
        doping.addDamage(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("데몰리션(콜렉터의 영약)");
        doping.minusFinalDamage(1.31);
        doping.addFinalDamage(1.32);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("어테인(콜렉터의 영약)");
        doping.addAtt(1L);
        doping.addCriticalP(1.0);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
