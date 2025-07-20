package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class Ark2 extends Job {

    public Ark2() {
        // 기본
        super();
        this.setName("아크(2초, 리레단일)");
        this.setConstant(1.7);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);

        this.setAscentDamage(2327280.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (255 + 157 + 72 + 223));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (255 + 157 + 72 + 223));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addAtt(3L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 0차
        passive = new Common();
        passive.setDescription("매직 서킷");
        passive.addAtt(25L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("미스틱 아츠 마스터리");
        passive.addAtt(20L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("너클 마스터리");
        passive.addAtt(20L);
        passive.addFinalDamage(1.05);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("융합 개시");
        passive.addCriticalP(5.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(60L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("스칼렛 버프");
        passive.addCriticalP(20.0);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("융합 진행");
        passive.addFinalDamage(1.12);
        passive.addCriticalP(20.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("너클 엑스퍼트");
        passive.addAtt(31L);
        passive.addCriticalDamage(31.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("융합 완성");
        passive.addAtt(41L);
        passive.addCriticalP(11.0);
        passive.addIgnoreDefenseList(31L);
        passive.addBossDamage(31L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("전투 광란");
        passive.addFinalDamage(1.21);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("로디드 다이스");
        passive.addAtt(40L);
        getPassiveList().add(passive);

        // 환산 보정
        this.addMainStatP(-66L);
        this.addMainStat(10L);
        this.addSubStat(0L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
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
        doping.setDescription("스칼렛 버프");
        doping.addAtt(30L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("어비스 버프");
        doping.addDamage(20L);
        doping.addBossDamage(35L);
        doping.addIgnoreDefenseList(20L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("너클 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(1L);
        doping.addCriticalDamage(1.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("융합 완성(콜렉터의 영약)");
        doping.addAtt(1L);
        doping.addBossDamage(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("전투 광란(콜렉터의 영약)");
        doping.minusFinalDamage(1.21);
        doping.addFinalDamage(1.22);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
